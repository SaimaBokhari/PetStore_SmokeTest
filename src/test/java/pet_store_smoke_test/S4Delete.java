package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.PetStoreDeleteResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class S4Delete extends PetStoreBaseUrl {
    /*
    Given
         https://petstore.swagger.io/v2/pet/4321
    When
         User sends Delete request
    Then
         Status code is 200
    And
         Response body is {
    "code": 200,
    "type": "unknown",
    "message": "4321"
}
     */

    @Test
    public void put01() {
        // Set the URL
        spec.pathParams("first", "pet", "second", 4321);

        // Set the expected data
        PetStoreDeleteResponsePojo expectedData = new PetStoreDeleteResponsePojo(200, "unknown", "4321");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).when().delete("/{first}/{second}");
        response.prettyPrint();

        // Do assertion
        // de-serialization
        PetStoreDeleteResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(),PetStoreDeleteResponsePojo.class);
        System.out.println("actualData = " + actualData);


        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getCode(),actualData.getCode());
        assertEquals(expectedData.getType(),actualData.getType());
        assertEquals(expectedData.getMessage(),actualData.getMessage());




    }
}
