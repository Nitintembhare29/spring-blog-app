package com.assignment1.Blogs.Service;

import com.assignment1.Blogs.Dto.AddUserRequestDto;
import com.assignment1.Blogs.Dto.UpdateUserDto;
import com.assignment1.Blogs.Model.User;
import com.assignment1.Blogs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserRequestDto addUserRequestDto) {

        // create object of user class
        User user = new User();
        user.setFirstName(addUserRequestDto.getFirstName());
        user.setLastName(addUserRequestDto.getLastName());
        user.setUsername(addUserRequestDto.getUsername());
        user.setPassword(addUserRequestDto.getPassword());
        userRepository.save(user);
        return "User added successfully";
    }

    public String deleteUser(int userId){
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }

    public String updatePass(UpdateUserDto updateUserDto){
        User user = userRepository.findById(updateUserDto.getUserId()).get();

        user.setPassword(updateUserDto.getPassword());
        userRepository.save(user);
        return "Password changed successfully";
    }

}
