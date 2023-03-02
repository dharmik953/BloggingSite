package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.BookMark;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.repositories.BookMarkRepository;
import com.training.bloggingsite.services.interfaces.BookmarkService;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.utils.PostConvertor;
import com.training.bloggingsite.utils.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    @Autowired
    BookMarkRepository bookMarkRepository;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Override
    public List<PostDto> getAllBookMarkedPost(UserDto userDto) {
        List< BookMark > bookMarkList=bookMarkRepository.findAll().stream().
                filter(s->s.getUser().getId()==userDto.getId()).toList();
        List<Post> post=bookMarkList.stream().map(s->s.getPost()).toList();
        List<PostDto> postDtos=new ArrayList<>();
        for(Post p:post){
            postDtos.add(PostConvertor.toPostDto(p));
        }

        return postDtos;
    }

    @Override
    public PostDto deleteBookMarkedPostByPostID(UserDto userDto,PostDto postDto) {
       List< BookMark > bookMarkList=bookMarkRepository.findAll().stream().
                filter(s->s.getPost().getId()==postDto.getId()).toList();
        bookMarkRepository.deleteById(bookMarkList.get(0).getId());

        return postDto;
    }

    @Override
    public void addBookMarkedPost(PostDto postDto,UserDto userDto) {

        BookMark bookMark=new BookMark();
        bookMark.setUser(UserConvertor.toUser(userDto));
        bookMark.setPost(PostConvertor.toPost(postDto));

        bookMarkRepository.save(bookMark);

    }

    @Override
    public boolean isBookMarked(UserDto userDto, long postId) {
        boolean isBookMarked = false;
        List<PostDto> bookMarkedPostsList = getAllBookMarkedPost(userDto);
        for (PostDto bookmarkpost : bookMarkedPostsList) {
            if (bookmarkpost.getId() == postId) {
                isBookMarked = true;
                break;
            }
        }
        return isBookMarked;
    }

    @Override
    public void changeBookMarkStatus(long postId, boolean isBookMarked, Principal principal) {
        UserDto userDto = userService.findUserByEmail(principal.getName());
        if(isBookMarked){
            this.deleteBookMarkedPostByPostID(userDto,postService.findPostById(postId));
        }else
            this.addBookMarkedPost(postService.findPostById(postId),userDto);

    }
}
