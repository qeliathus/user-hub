package by.potapcuk.converter;

import by.potapchuk.core.User;
import by.potapchuk.core.UserRole;
import by.potapchuk.service.converter.UserConverter;
import by.potapchuk.service.dto.UserDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

class UserConverterTest {

    @Test
    public void testConvert_equalUser()  {
        User user = new User();
        user.setMail("test@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setSurname("Smith");
        user.setRole(UserRole.CUSTOMER_USER);

        UserConverter userConverter = new UserConverter();
        UserDTO userDTO = userConverter.convert(user);

        assertEquals("test@example.com", userDTO.getMail());
        assertEquals("John", userDTO.getFirstName());
        assertEquals("Doe", userDTO.getLastName());
        assertEquals("Smith", userDTO.getSurname());
        assertEquals(UserRole.CUSTOMER_USER, userDTO.getRole());
    }

    @Test
    public void testConvert_equalUsers() {
        User user1 = new User();
        user1.setMail("test1@example.com");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setSurname("Smith");
        user1.setRole(UserRole.CUSTOMER_USER);

        User user2 = new User();
        user2.setMail("test2@example.com");
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setSurname("Johnson");
        user2.setRole(UserRole.SALE_USER);

        List<User> userList = Arrays.asList(user1, user2);

        UserConverter userConverter = new UserConverter();

        List<UserDTO> userDTOList = userConverter.convert(userList);

        assertEquals(2, userDTOList.size());
        assertEquals("test1@example.com", userDTOList.get(0).getMail());
        assertEquals("test2@example.com", userDTOList.get(1).getMail());
    }
}
