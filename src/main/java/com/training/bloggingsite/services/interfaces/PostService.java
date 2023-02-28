package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;

import java.util.List;

public interface PostService {

    PostDto savePost(PostDto post);//save or update post//done


    List<PostDto> getAllPost();     //done

    List<PostDto> getPostByCategory(Category category);

    PostDto getPostById(Long id);

    List<PostDto> getAllPostByUser(User user);


    default PostDto toPostDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.isVerified(),
                post.getCreateDateTime(),
                post.getUpdateDateTime()
        );
    }

    default Post toPost(PostDto postDto) {
        return new Post(
                postDto.getId(),
                postDto.getTitle(),
                postDto.getContent(),
                postDto.isVerified(),
                postDto.getCreateDateTime(),
                postDto.getUpdateDateTime()
        );
    }
}
