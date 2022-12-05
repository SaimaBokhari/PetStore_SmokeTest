package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.PetStoreDeleteResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class S5Get extends PetStoreBaseUrl {
     /*
    Negative test: Testing with negative values


    Given
         https://petstore.swagger.io/v2/pet/4321
    When
         User sends Get request
    Then
         Status code is 404
    And
         Response body is {
    "code": 1,
    "type": "error",
    "message": "Pet not found"
}
     */


    @Test
    public void get02() {
        // Set the URL
        spec.pathParams("first", "booking", "second", 4321);

        // Set the expected data
        PetStoreDeleteResponsePojo expectedData = new PetStoreDeleteResponsePojo(1, "error", "Pet not found");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do assertion
        // de-serialization
        PetStoreDeleteResponsePojo actualData = JsonUtils.covertJsonToJavaObject(response.asString(),PetStoreDeleteResponsePojo.class);
        System.out.println("actualData = " + actualData);


        assertEquals(404, response.statusCode());
        assertEquals(expectedData.getCode(),actualData.getCode());
        assertEquals(expectedData.getType(),actualData.getType());
        assertEquals(expectedData.getMessage(),actualData.getMessage());




    }
}

