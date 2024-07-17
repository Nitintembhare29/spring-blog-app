package com.assignment1.Blogs.Service;

import com.assignment1.Blogs.Dto.AddBlogRequestDto;
import com.assignment1.Blogs.Model.Blog;
import com.assignment1.Blogs.Model.User;
import com.assignment1.Blogs.Repository.BlogRepository;
import com.assignment1.Blogs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    public String createBlog(AddBlogRequestDto addBlogRequestDto){

        // find user with userId and add blog to user's blogList and save
        User user = userRepository.findById(addBlogRequestDto.getUserId()).get();

        // create blog object
        Blog blog = new Blog();
        blog.setTitle(addBlogRequestDto.getTitle());
        blog.setContent(addBlogRequestDto.getContent());
        blog.setPublishDate(new Date());
        blog.setUser(user);

        user.getBlogList().add(blog);
        userRepository.save(user);
        return "blog added successfully";
    }

    public String deleteBlog(int userId, int blogId){
        // find user and get blogList and remove blog and save
        User user = userRepository.findById(userId).get();

        List<Blog> blogList = user.getBlogList();

        Iterator<Blog> iterator = blogList.iterator();
        while (iterator.hasNext()) {
            Blog b = iterator.next();
            if (b.getId() == blogId) {
                iterator.remove();
                break;
            }
        }
        user.setBlogList(blogList);
        userRepository.save(user);
        return "blog deleted successfully";
    }
}
