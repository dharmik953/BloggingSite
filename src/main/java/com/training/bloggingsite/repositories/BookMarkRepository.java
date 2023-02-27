package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {


}
