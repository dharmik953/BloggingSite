package com.training.bloggingsite.utils;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.Post;

public class PostConvertor {
    public static PostDto toPostDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.isVerified(),
                post.getCreateDateTime(),
                post.getUpdateDateTime(),
                UserConvertor.toUserDto(post.getUser()), CategoryConvertor.toCategoryDto(post.getCategory())
        );
    }

    public static Post toPost(PostDto postDto) {
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
