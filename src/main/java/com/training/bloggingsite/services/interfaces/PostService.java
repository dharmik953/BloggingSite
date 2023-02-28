package com.training.bloggingsite.services.interfaces;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.dtos.UserDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.User;

import java.util.List;

public interface PostService {

    String savePost(PostDto post, UserDto userDto);

    List<PostDto> getAllPost();

    List<PostDto> getPostByCategory(Category category);

    PostDto getPostById(Long id);

    List<PostDto> getAllPostByUser(User user);

    void deletePost(long id);

    void updateVerification(long postId, boolean isVerified);

    default PostDto toPostDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.isVerified(),
                post.getCreateDateTime(),
                post.getUpdateDateTime(),
                UserService.toUserDto(post.getUser())
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
