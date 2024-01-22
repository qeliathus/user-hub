package by.potapchuk.contorller;

import by.potapchuk.core.UserRole;
import by.potapchuk.service.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddUser() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setMail("test@example.com");
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setSurname("Smith");
        userDTO.setRole(UserRole.CUSTOMER_USER);
        String jsonRequest = objectMapper.writeValueAsString(userDTO);
        ResultActions resultActions = mockMvc.perform(post("/api/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdd_shouldReturnBadRequest_whenInvalidFirstName() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setMail("test@example.com");
        userDTO.setFirstName("ThisIsAnInvalidFirstNameThatExceedsTwentyCharacters");
        userDTO.setLastName("Doe");
        userDTO.setSurname("Smith");
        userDTO.setRole(UserRole.CUSTOMER_USER);
        String jsonRequest = objectMapper.writeValueAsString(userDTO);
        ResultActions resultActions = mockMvc.perform(post("/api/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testAdd_shouldReturnBadRequest_whenInvalidMail() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setMail("ThisIsAnInvalidMailThatNotStandard");
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setSurname("Smith");
        userDTO.setRole(UserRole.CUSTOMER_USER);
        String jsonRequest = objectMapper.writeValueAsString(userDTO);
        ResultActions resultActions = mockMvc.perform(post("/api/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

}
