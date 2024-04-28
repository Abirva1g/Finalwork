package API.Specification;

import API.DTO.UserCreationDTO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static API.Properties.BASE_URI;
import static API.Properties.PATH_REGISTRATION;

public class RegistrationSpec {
    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;
    public void createRequestSpecificationRegistration(UserCreationDTO userCreationDTO){
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_REGISTRATION)
                .setContentType(ContentType.JSON)
                .setBody(userCreationDTO)
                .build();
    }

    public void createResponseSpecificationRegistration (int status){
        responseSpec= new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    public void postRegistration(){
        RestAssured.given(requestSpec).log().all()
                .post()
                .then().log().all().spec(responseSpec);
    }

    public void postRegistrationFail(String message){
        RestAssured.given(requestSpec).log().all()
                .post()
                .then().log().all().spec(responseSpec)
                .body("level", Matchers.equalTo("ERROR")
                , "message", Matchers.equalTo(message));
    }
}
