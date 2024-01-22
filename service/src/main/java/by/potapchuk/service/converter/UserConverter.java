package by.potapchuk.service.converter;

import by.potapchuk.core.User;
import by.potapchuk.service.dto.UserDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public List<UserDTO> convert(List<User> users) {
        return users.stream().map(this::convert).collect(Collectors.toList());
    }

    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setMail(user.getMail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setSurname(user.getSurname());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
