package com.training.bloggingsite.repositories;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookMarkRepository extends JpaRepository<BookMark, Long> {
    List<BookMark> findBookMarkByUserContainsAndId(long id);
    BookMark findBookMarkByPostContainingAndId(PostDto postDto);
}
