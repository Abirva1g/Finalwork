package Tests.API;

import API.DTO.NoteCreationDTO;
import API.Specification.AuthorizationSpec;
import API.Specification.NoteSpec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

@DisplayName("Создание и удаление заметок")
public class EditNoteTest {
    NoteSpec noteSpec = new NoteSpec();
    AuthorizationSpec authorizationSpec = new AuthorizationSpec();

    @BeforeEach
    public void before() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "ASSEROV");
        paramsLogin.put("password", "Qwerty$4");
        authorizationSpec.getToken(paramsLogin);
    }

    @Test
    @DisplayName(value ="Создание заметки")
    public void createNote() {
        NoteCreationDTO[] noteCreationDTO = new NoteCreationDTO[1];
        noteCreationDTO[0] = NoteCreationDTO.builder()
                .name("Итоговое")
                .content("Задание")
                .color("#fdcfe8")
                .priority(200)
                .build();
        noteSpec.createNoteRequestSpecification(noteCreationDTO[0]);
        noteSpec.createNoteResponseSpecification(201);
        noteSpec.postNote();
    }

    @Test
    @DisplayName(value ="Редактирование заметки")
    public void editNote(){
        NoteCreationDTO[] noteCreationDTO = new NoteCreationDTO[1];
        noteCreationDTO[0] = NoteCreationDTO.builder()
                .id(192)
                .name("Урок 15")
                .content("Редактирование заметки")
                .color("#fdcfe8")
                .priority(200)
                .build();
        noteSpec.createNoteRequestSpecification(noteCreationDTO[0]);
        noteSpec.createNoteResponseSpecification(204);
        noteSpec.putNotes();
    }

    @Test
    @DisplayName(value ="Архивирования заметки")
    public void archiveNote(){
        noteSpec.archiveNoteRequestSpecification();
        noteSpec.createNoteResponseSpecification(204);
        noteSpec.deleteNotes();
    }
}
