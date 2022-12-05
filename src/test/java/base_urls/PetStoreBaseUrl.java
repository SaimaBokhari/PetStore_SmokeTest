package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class PetStoreBaseUrl {
    protected RequestSpecification spec;

    @BeforeEach   // from new junit.jupiter annotation...  @Before was for Junit

    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2").build();
    }
}
