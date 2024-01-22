package by.potapchuk.service;

import by.potapchuk.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    UserDTO addUser(UserDTO userDTO);

    Page<UserDTO> getAllUsers(Pageable pageable);
}
