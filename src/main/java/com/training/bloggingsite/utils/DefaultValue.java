package com.training.bloggingsite.utils;

import com.training.bloggingsite.entities.Category;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DefaultValue {

    public static final Category DEFAULT_CATEGORY =new Category(0,"");
    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String DEFAULT_ADMIN = "admin";
    public static final String DEFAULT_EMAIL = "admin@admin.com";
    public static final String DEFAULT_PASSWORD_VALUE = "Mind@123";
    public static final String DEFAULT_PASSWORD = encoder.encode(DEFAULT_PASSWORD_VALUE);
}
