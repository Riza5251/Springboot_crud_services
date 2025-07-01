package net.javaguides.Springboot.controller;

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
@PostMapping("/create")
public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user)
{
    UserDto savedUser=userService.createUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.OK);

}

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userid)
    {
        UserDto getuser = userService.getUserById(userid);
        return new ResponseEntity<>(getuser,HttpStatus.FOUND);
    }
   @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        List<UserDto> users= userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userid, @Valid @RequestBody UserDto user)
    {
        user.setId(userid);
        UserDto updated= userService.updateUser(user);
        return new ResponseEntity<>(updated,HttpStatus.OK);

    }
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
