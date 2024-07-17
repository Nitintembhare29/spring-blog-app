package com.assignment1.Blogs.Controller;

import com.assignment1.Blogs.Dto.AddUserRequestDto;
import com.assignment1.Blogs.Dto.UpdateUserDto;
import com.assignment1.Blogs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody AddUserRequestDto addUserRequestDto){
        String response = userService.addUser(addUserRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //http://localhost:5050/users/delete?userId=3
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam("userId") int userId){
        String response = userService.deleteUser(userId);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updatePass(@RequestBody UpdateUserDto updateUserDto){
        String response = userService.updatePass(updateUserDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
