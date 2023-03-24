package com.training.bloggingsite.services.impl;

import com.training.bloggingsite.dtos.PostDto;
import com.training.bloggingsite.entities.Category;
import com.training.bloggingsite.entities.Post;
import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.CategoryRepository;
import com.training.bloggingsite.repositories.PostRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.services.interfaces.PostService;
import com.training.bloggingsite.utils.CriteriaQueryHelper;
import com.training.bloggingsite.utils.CriteriaQueryBuilder;
import com.training.bloggingsite.utils.DefaultValue;
import com.training.bloggingsite.utils.PostConvertor;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    EntityManager entityManager;
    @Autowired
    PostRepository postRepository;

    @Autowired
    CriteriaQueryBuilder criteriaQueryBuilder;
    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);
    CriteriaQueryHelper criteriaQueryHelper;

    @PostConstruct
    public void init() {
    criteriaQueryHelper =new CriteriaQueryHelper(entityManager, Post.class);

    }

    @Override
    public String savePost(PostDto post, String userEmail, String categoryName) {
        User user = this.userRepository.findByEmail(userEmail);
        Category category = this.categoryRepository.findByName(categoryName);
        Post postToBeInserted = PostConvertor.toPost(post);
        postToBeInserted.setCategory(category);
        postToBeInserted.setUser(user);
        List<Role> roles = user.getRoles().stream().toList();
        if (roles.get(0).getName().equals(DefaultValue.ADMIN)) {
            postToBeInserted.setVerified(true);
            // this.postRepository.save(postToBeInserted);
            entityManager.persist(postToBeInserted);
            logger.info("Post created as : " + postToBeInserted.getTitle() + " by " + user.getName());
            return "redirect:/admin/home";
        } else {
            postToBeInserted.setVerified(false);
            //   this.postRepository.save(postToBeInserted);
            entityManager.persist(postToBeInserted);
            logger.info("Post created as : " + postToBeInserted.getTitle() + " by " + user.getName());
            return "redirect:/user/home";
        }
    }

    @Override
    public PostDto findPostById(long id) {

//        return PostConvertor.toPostDto(
//                postRepository.getReferenceById(id)
//        );
        logger.info("find post by id");
      //  return PostConvertor.toPostDto(criteriaQueryHelper.getAllDataWhere("id",id).get(0));
     return    PostConvertor.toPostDto(
             criteriaQueryBuilder.getResultWhereColumnEqual("id",id,Post.class).get(0)
                );

    }

    @Override
    public List<PostDto> findAllPostByUser(User user) {

        List<PostDto> postDtos = new ArrayList<>();
        //logger.info("fetching ....");
  //      List<Post> postByUserId = postRepository.findPostByUser(user);
//        logger.info(user.getId()+"fetched with jpa");
        //List<Post> postByUserId = criteriaQueryHelper.getAllDataWhere("user",user);
//        System.out.println("this"+postByUserId3.toString());

        List<Post> postByUserId= criteriaQueryBuilder.getResultWhereColumnEqual("user",user,Post.class);
        for (Post post : postByUserId)
            postDtos.add(PostConvertor.toPostDto(post));


        return postDtos;
    }

    @Override//my-post//my-post
    public void deletePost(long id) {
        this.postRepository.deleteById(id);
        logger.info("Post Deleted with id  : " + id);
    }

    @Override
    public void updateVerification(long postId, boolean isVerified) {
        Post post = this.postRepository.findById(postId).get();
        this.postRepository.updateVerificationStatus(postId, !isVerified);
        logger.info("Post verified as : " + !isVerified + " for id " + post.getId());
    }

    @Override
    public List<PostDto> findPaginatedVerifiedPost(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public <T> List<PostDto> findPaginatedPosts(int offset, int limit,String columnName,T value) {
      //  Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by("title"));

        List<PostDto> postDtos = new ArrayList<>();

       // List<Post> post = postRepository.findAll(pageable).getContent();
        List<Post> post = criteriaQueryHelper.getPaginatedData(offset,limit,"isVerified",value);
       // System.out.println(criteriaQueryHelper.getPaginatedData(0,5,"is_verified",true));

        for (Post p : post) {

            postDtos.add(PostConvertor.toPostDto(p));
        }

       //----------------
      //  criteriaQueryHelper.getAllData("").forEach(System.out::println);

        return postDtos;
    }

    @Override
    public <T> int findTotalPages(String columnName,T value) {
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//        return postRepository.findAll(pageable).getTotalPages();
//
//

        return criteriaQueryHelper.getCount(columnName, value);
    }
}
