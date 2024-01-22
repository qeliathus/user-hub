package by.potapchuk.service;

import by.potapchuk.core.User;
import by.potapchuk.repository.UserRepository;
import by.potapchuk.service.converter.UserConverter;
import by.potapchuk.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        user.setMail(userDTO.getMail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setSurname(userDTO.getSurname());
        user.setRole(userDTO.getRole());

        User savedUser = userRepository.save(user);
        return userConverter.convert(savedUser);
    }

    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<User> usersPage = userRepository.findAll(pageable);
        List<UserDTO> users = userConverter.convert(usersPage.getContent());
        return new PageImpl<>(users, pageable, usersPage.getTotalElements());
    }
}
