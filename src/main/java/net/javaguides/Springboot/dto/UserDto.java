package net.javaguides.Springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "User FirstName should not be empty null or blank !!!")
    private String firstName;
    @NotEmpty(message = "User lastName should not be null blank or empty")
    private String lastName;
    @NotEmpty(message = "User Email should not be blank or null ")
    @Email(message = "Email should be valid ")
    private String email;
}
