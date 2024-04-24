package API.DTO;

import java.util.ArrayList;
import lombok.Data;
import java.util.List;


@Data
public class User {
    private String login;
    private String password;
    private String email;
    private List<Role> roles;
    private List<Note> notes;
    public void setDefaultRoles(){
        Role defaultRole = new Role();
        defaultRole.setId("2");
        defaultRole.setName("ROLE_USER");

        List<Role> defaultListRole = new ArrayList<>();
        defaultListRole.add(defaultRole);
        this.roles = defaultListRole;
    }

    public User generateUser () {
        int numberGenerated = 100 + (int)(Math.random() * 10000);
        User newUser = new User();
        newUser.setLogin("Aserov"+ numberGenerated);
        newUser.setPassword("123");
        newUser.setEmail("Aserov"+ numberGenerated + "@mail.ru");
        newUser.setDefaultRoles();
        newUser.setDefaultNotes();
        return newUser;
    }


    public void setDefaultNotes() {
        Note defaultNote = new Note();
        defaultNote.setName("ИТОГОВОЕ");
        defaultNote.setContent("ЗАДАНИЕ");
        defaultNote.setColor("#fdcfe8");
        defaultNote.setPriority(35);

        List<Note> defaultListNote = new ArrayList<>();
        defaultListNote.add(defaultNote);
        this.notes = defaultListNote;
    }
}
