package Registration;

import API.DTO.User;
import API.DTO.UserCreationDTO;
import API.Specification.RegistrationSpec;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
@DisplayName(value = "Регистрация")
public class RegistrationTest {
    private User newUser;
    private UserCreationDTO userCreationDTO;
    RegistrationSpec registrationSpec = new RegistrationSpec();
    @Before
    public void before() {
        newUser = new User();
        newUser = newUser.generateUser();

    }
   @Test
    @DisplayName(value = "Проверка регистрации только с обязательными полями")

    public void registrationWithRequiredFieldsTest() {
        userCreationDTO = UserCreationDTO.builder().login(newUser.getLogin())
                .password(newUser.getPassword())
                .build();
        registrationSpec.createRequestSpecificationRegistration (userCreationDTO);
        registrationSpec.createResponseSpecificationRegistration(201);
        registrationSpec.postRegistration();
    }


    @Test
    @DisplayName(value = "Проверка регистрации со всеми полями")
    public void registryWithAllFieldsFieldsTest() {
        userCreationDTO = UserCreationDTO.builder().login(newUser.getLogin())
                .password(newUser.getPassword())
                .email((newUser.getEmail()))
                .roles(newUser.getRoles())
                .build();
        registrationSpec.createRequestSpecificationRegistration (userCreationDTO);
        registrationSpec.createResponseSpecificationRegistration(201);
        registrationSpec.postRegistration();
    }
    @Test
    @DisplayName(value = "Проверка регистрации только с отправкой логина")
    public void registryOnlyWithLoginTest()  {
        userCreationDTO = UserCreationDTO.builder().login(newUser.getLogin())
                .build();
        registrationSpec.createRequestSpecificationRegistration (userCreationDTO);
        registrationSpec.createResponseSpecificationRegistration(500);
        registrationSpec.postRegistrationFail("Password is required");
    }

    @Test
    @DisplayName(value = "Проверка регистрации только с отправкой пароля")
    public void registryOnlyWithPasswordTest()  {
        userCreationDTO = UserCreationDTO.builder().password(newUser.getPassword())
                .build();
        registrationSpec.createRequestSpecificationRegistration (userCreationDTO);
        registrationSpec.createResponseSpecificationRegistration(500);
        registrationSpec.postRegistrationFail("Login is required");
    }

    @Test
    @DisplayName(value = "Проверка регистрации со всеми полями + создание заметки")
    public void registryWithAllFieldsFieldsAndNoteTest() {
        userCreationDTO = UserCreationDTO.builder().login(newUser.getLogin())
                .password(newUser.getPassword())
                .email((newUser.getEmail()))
                .roles(newUser.getRoles())
                .notes(newUser.getNotes())
                .build();
        registrationSpec.createRequestSpecificationRegistration (userCreationDTO);
        registrationSpec.createResponseSpecificationRegistration(201);
        registrationSpec.postRegistration();
    }

}
