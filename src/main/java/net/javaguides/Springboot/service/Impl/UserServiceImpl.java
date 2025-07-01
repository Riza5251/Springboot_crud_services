package net.javaguides.Springboot.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.Springboot.dto.UserDto;
import net.javaguides.Springboot.entity.User;
import net.javaguides.Springboot.exception.EmailAlreadyExistException;
import net.javaguides.Springboot.exception.ResourceNotFoundException;
import net.javaguides.Springboot.mapper.AutoUserMapper;
import net.javaguides.Springboot.mapper.UserMapper;
import net.javaguides.Springboot.repository.UserRepository;
import net.javaguides.Springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {


    // injecting the user repo
    private UserRepository userRepository;

    //injecting the modelmapper class
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        // jpa entity need to be saved in the db so we will convert that dto object into the jpa
       //User user1= UserMapper.mapToUser(userDto);
//        User user2 = new User();
//        user2.setFirstName(userDto.getFirstName());
//        user2.setLastName(userDto.getLastName());
//        user2.setEmail(userDto.getEmail());

      //  User user1= modelMapper.map(userDto,User.class);

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent())
        {
            throw new EmailAlreadyExistException("Emal Already Exist");
        }
        User user1= AutoUserMapper.MAPPER.mapToUser(userDto);

        User saveuser = userRepository.save(user1);

       // UserDto saveus = UserMapper.mapToUserDto(saveuser);
//        UserDto saveus = modelMapper.map(saveuser,UserDto.class);

        UserDto saveus = AutoUserMapper.MAPPER.mapToUserDto(saveuser);
        return saveus;
    }
    @Override
    public UserDto getUserById(Long userid)
    {
       User user = userRepository.findById(userid).orElseThrow(()-> new ResourceNotFoundException("user","id",userid));
      // User getuser =  optionalUser.get();
       // return UserMapper.mapToUserDto(getuser);
//       return modelMapper.map(getuser,UserDto.class);
       return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

   @Override
    public List<UserDto> getAllUsers() {
        List<User> userlist = userRepository.findAll();
        //this is the logic to convert the entire list of user to usersDto we are using stream and map method
       // return userlist.stream().map(UserMapper::mapToUserDto).toList();
//       return userlist.stream().map((user)->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
       return userlist.stream().map((user)->AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        //User user1=UserMapper.mapToUser(user);
       User existUser = userRepository.findById(user.getId()).orElseThrow(()-> new ResourceNotFoundException("user","id",user.getId()));
       existUser.setFirstName(user.getFirstName());
       existUser.setLastName(user.getLastName());
       existUser.setEmail(user.getEmail());
       User update = userRepository.save(existUser);
       // return UserMapper.mapToUserDto(update);
//       return modelMapper.map(update,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(update);
    }

    @Override
    public void deleteUser(Long userId) {

        User existUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
        userRepository.deleteById(userId);
    }
}
