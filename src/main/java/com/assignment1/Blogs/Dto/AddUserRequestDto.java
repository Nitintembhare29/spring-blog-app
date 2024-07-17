package com.assignment1.Blogs.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserRequestDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
