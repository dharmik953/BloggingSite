package com.training.bloggingsite;

import com.training.bloggingsite.entities.Role;
import com.training.bloggingsite.entities.User;
import com.training.bloggingsite.repositories.RoleRepository;
import com.training.bloggingsite.repositories.UserRepository;
import com.training.bloggingsite.utils.CriteriaQueryBuilder;
import com.training.bloggingsite.utils.DefaultValue;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class BloggingSiteApplication implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CriteriaQueryBuilder cb;

    Logger logger = LoggerFactory.getLogger(BloggingSiteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BloggingSiteApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<User> users=cb.getAll(User.class);
        List<Role>roles = cb.getAll(Role.class);

        if(users.isEmpty() && roles.isEmpty()){

            Role roleAdmin = new Role(1, DefaultValue.ADMIN);
            Role roleUser = new Role(2,DefaultValue.USER);

            roleUser.setCreateDateTime(LocalDateTime.now());
            roleUser.setUpdateDateTime(LocalDateTime.now());

            // Saved Using JPA
            this.roleRepository.save(roleAdmin);
            this.roleRepository.save(roleUser);

            logger.info("Default Roles Added.");

            Set<Role> roleSet = new HashSet<>();
            roleSet.add(roleAdmin);
            User defaultUser = new User(1
                    ,DefaultValue.DEFAULT_ADMIN
                    ,DefaultValue.DEFAULT_EMAIL,
                    DefaultValue.DEFAULT_PASSWORD,roleSet
                    ,LocalDateTime.now()
                    ,LocalDateTime.now());

            // Saved Using JPA
            this.userRepository.save(defaultUser);

            logger.info("Default Admin added, email= "+DefaultValue.DEFAULT_EMAIL+" and password= "+DefaultValue.DEFAULT_PASSWORD_VALUE);
        }
    }
}
