package com.training.bloggingsite.entities;




public class PostEditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String Content;



    private String title;





}
