package com.training.bloggingsite.security;

import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.utils.CriteriaQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailServiceaImpl implements UserDetailsService {

    @Autowired
    CriteriaQueryBuilder cb;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = cb.getResultWhereColumnEqual("email",username,User.class);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Could not find the Email");
        }
        return new MyUserDetail(user.get(0));
    }
}
