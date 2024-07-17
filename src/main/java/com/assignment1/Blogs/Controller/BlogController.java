package com.assignment1.Blogs.Controller;

import com.assignment1.Blogs.Dto.AddBlogRequestDto;
import com.assignment1.Blogs.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/add")
    public ResponseEntity createBlog(@RequestBody AddBlogRequestDto addBlogRequestDto){
        String response = blogService.createBlog(addBlogRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{blogId}/{userId}")
    public ResponseEntity deleteBlog(@PathVariable int blogId, @PathVariable int userId){
        String response = blogService.deleteBlog(userId, blogId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
