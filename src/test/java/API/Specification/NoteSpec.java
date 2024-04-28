package API.Specification;

import API.DTO.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.ArrayList;
import java.util.List;
import static API.Properties.*;


public class NoteSpec {
    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;

    public void createNoteRequestSpecification(NoteCreationDTO noteCreationDTO) {
        List<NoteCreationDTO> noteList = new ArrayList<>();
        noteList.add(noteCreationDTO);
        requestSpec = new RequestSpecBuilder()

                .addHeader("Authorization", "Bearer " + AuthorizationSpec.token)
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .setBasePath(CREATE_NOTE)
                .setBody(noteList)
                .build();
    }

    public void archiveNoteRequestSpecification() {
        requestSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + AuthorizationSpec.token)
                .setBaseUri(BASE_URI)
                .setBasePath(ARCHIVE_NOTE)
                //Сделать поиск номеров заметок
                .setContentType("application/json")
                .build();
    }

    public void createNoteResponseSpecification(int status) {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    public void postNote() {
        RestAssured.given(requestSpec).log().all()
                .post()
                .then().log().all().spec(responseSpec);

    }

    public void putNotes() {
        RestAssured.given(requestSpec)
                .put()
                .then().log().all().spec(responseSpec);
    }

    public void deleteNotes() {
        RestAssured.given(requestSpec)
                .delete()
                .then().log().all().spec(responseSpec);
    }
}
