package com.training.bloggingsite.repositories;

import com.training.bloggingsite.entities.PostEditor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostEditorRepository extends JpaRepository<PostEditor, Long> {

    PostEditor getPostById(Long id);


}
