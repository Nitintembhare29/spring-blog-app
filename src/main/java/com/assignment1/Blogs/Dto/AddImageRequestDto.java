package com.assignment1.Blogs.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddImageRequestDto {

    private String imageDimension;
    private String description;
    private int blogId;
}
