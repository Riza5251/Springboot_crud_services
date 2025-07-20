package net.javaguides.Springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
@Schema(description = "Userdto model Information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @Schema(description = "users firstname")
    @NotEmpty(message = "User FirstName should not be empty null or blank !!!")
    private String firstName;
    @Schema(description = "users lastname")
    @NotEmpty(message = "User lastName should not be null blank or empty")
    private String lastName;
    @Schema(description = "users email address")
    @NotEmpty(message = "User Email should not be blank or null ")
    @Email(message = "Email should be valid ")
    private String email;
}
