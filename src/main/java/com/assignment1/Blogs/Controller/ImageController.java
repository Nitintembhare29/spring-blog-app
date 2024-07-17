package com.assignment1.Blogs.Controller;

import com.assignment1.Blogs.Dto.AddImageRequestDto;
import com.assignment1.Blogs.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/add")
    public ResponseEntity addImage(@RequestBody AddImageRequestDto addImageRequestDto){
        String response = imageService.addImage(addImageRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteImage(@PathVariable int id){
        String response = imageService.deleteImage(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/countImagesInScreen/{id}/{screenDimension}")
    public ResponseEntity countImage(@PathVariable int id, @PathVariable String screenDimension){
        int response = imageService.countImage(id, screenDimension);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
