package net.javaguides.Springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.Springboot.dto.UserDto;
import net.javaguides.Springboot.entity.User;
import net.javaguides.Springboot.exception.ErrorDetails;
import net.javaguides.Springboot.exception.ResourceNotFoundException;
import net.javaguides.Springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
@Tag(name="CRUD rest api for user resources",
        description = "Crud API's- Create User Delete User Update User Get user Get All user"
) // provides additional information about the tag in the swagger doc
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    // injecting the dependency of user service
    private UserService userService;


//    public ResponseEntity<User> createUser(@RequestBody User user)
//    {
//        User savedUser =  userService.createUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }

    @Operation(summary = "Create user rest api",
                description = "saves the user in the database") // tells about the operation of the api
    @ApiResponse(responseCode = "201",
    description = "HTTP status created ") // possible response that the api will return
@PostMapping("/create")
public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user)
{
    UserDto savedUser=userService.createUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.OK);

}

    @Operation(summary = "Get user rest api",
            description = "return the user with the given id from the database ") // tells about the operation of the api
    @ApiResponse(responseCode = "200",
            description = "HTTP status 200 success ")
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userid)
    {
        UserDto getuser = userService.getUserById(userid);
        return new ResponseEntity<>(getuser,HttpStatus.FOUND);
    }

    @Operation(summary = "Get all user  rest api",
            description = "extracts or return all the user from the database ") // tells about the operation of the api
    @ApiResponse(responseCode = "200",
            description = "HTTP status 200 success ")
   @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        List<UserDto> users= userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @Operation(summary = "update user  rest api",
            description = "updates the  existing user in the database") // tells about the operation of the api
    @ApiResponse(responseCode = "200",
            description = "HTTP status 200 success  ")
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userid, @Valid @RequestBody UserDto user)
    {
        user.setId(userid);
        UserDto updated= userService.updateUser(user);
        return new ResponseEntity<>(updated,HttpStatus.OK);

    }
    @Operation(summary = "Delete user rest api",
            description = "deletes the user with a particular id from  the database") // tells about the operation of the api
    @ApiResponse(responseCode = "200",
            description = "HTTP status 200 success ")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);

    }
//     @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest)
//    {
//           ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),exception.getMessage(), webRequest.getDescription(false),"USER_NOT_FOUND" );
//
//           return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
