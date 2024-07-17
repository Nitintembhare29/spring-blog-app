package com.assignment1.Blogs.Service;

import com.assignment1.Blogs.Dto.AddImageRequestDto;
import com.assignment1.Blogs.Model.Blog;
import com.assignment1.Blogs.Model.Image;
import com.assignment1.Blogs.Repository.BlogRepository;
import com.assignment1.Blogs.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ImageRepository imageRepository;

    public String addImage(AddImageRequestDto addImageRequestDto){
         // find blog with blogId
        Blog blog = blogRepository.findById(addImageRequestDto.getBlogId()).get();

        // create Image object
        Image image = new Image();
        image.setDescription(addImageRequestDto.getDescription());
        image.setImageDimension(addImageRequestDto.getImageDimension());
        image.setBlog(blog);

        blog.getImageList().add(image);
        blogRepository.save(blog);
        return "Image added successfully";
    }

    public String deleteImage (int id){
        imageRepository.deleteById(id);
        return "image deleted successfully";
    }

    public int countImage(int id, String screenDimension){
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions
        Image image = imageRepository.findById(id).get();
        String[]screenDim = screenDimension.split("X");
        int screeH = Integer.parseInt(screenDim[0]);
        int screeW = Integer.parseInt(screenDim[1]);

        String[]imageDim = image.getImageDimension().split("X");
        int imageH = Integer.parseInt(imageDim[0]);
        int imageW = Integer.parseInt(imageDim[1]);

        return (screeH/imageH) * (screeW/imageW);
    }


}
