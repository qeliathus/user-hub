package by.potapchuk.service.dto;


import by.potapchuk.core.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "Email is required")
    @NotNull(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 50, message = "Email should be at most 50 characters")
    private String mail;

    @NotBlank(message = "First name is required")
    @NotNull(message = "First name is required")
    @Size(max = 20, message = "First name should be at most 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @NotNull(message = "Last name is required")
    @Size(max = 40, message = "Last name should be at most 40 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String lastName;

    @NotBlank(message = "Surname name is required")
    @NotNull(message = "Surname name is required")
    @Size(max = 40, message = "Surname should be at most 40 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String surname;

    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
