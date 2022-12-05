package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.Category;
import pojos.PetStorePet;
import pojos.Tags;
import utils.JsonUtils;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class S2Put extends PetStoreBaseUrl {
    /*
Given
    https://petstore.swagger.io/v2/pet
And
   {
      "id": 4321,
      "category": {
        "id": 0,
        "name": "Cat"
      },
      "name": "Latte",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "My lovely cat"
        }
      ],
      "status": "available"
    }
When
    User sends Put request

Then
    Http Status code is 200

And
    Response body is like: {
      "id": 4321,
      "category": {
        "id": 0,
        "name": "Cat"
      },
      "name": "Latte",
      "photoUrls": [
        "string"
      ],
      "tags": [
        {
          "id": 0,
          "name": "My lovely cat"
        }
      ],
      "status": "available"
    }
 */
    @Test
    public void put01(){
        // Set the URL
        spec.pathParam("first","pet");

        // Set the expected data .. serialization with pojo class
        Category category = new Category(0, "Cat");
        Tags tags = new Tags(0, "My lovely cat");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("string");  // for photoUrl

        ArrayList<Tags> arrayListTags = new ArrayList<>();
        arrayListTags.add(tags);

        PetStorePet expectedData = new PetStorePet(4321,category, "Latte", arrayList,arrayListTags, "available"  );
        System.out.println("expectedData = " + expectedData);

        // Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}");
        response.prettyPrint();

        // Do assertion with pojo class and ObjectMapper
        // de-serialization
        PetStorePet actualData = JsonUtils.covertJsonToJavaObject(response.asString(),PetStorePet.class);
        System.out.println("actualData = " + actualData);

        // now assert

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getCategory().getId(), actualData.getCategory().getId());
        assertEquals(expectedData.getCategory().getName(), actualData.getCategory().getName());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getPhotoUrls(), actualData.getPhotoUrls());
//        assertEquals(expectedData.getTags().get(0), actualData.getTags().get(0));
//        assertEquals(expectedData.getTags().get("My cute cat"), actualData.getTags().get("My cute cat"));
        assertEquals(expectedData.getStatus(), actualData.getStatus());


    }
}
