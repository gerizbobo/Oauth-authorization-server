package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class OauthAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthAuthorizationServerApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

           userService.saveUser(new User(null,"Leviss Ima" ,"ima","1234",new ArrayList<>() ));
           userService.saveUser(new User(null,"Will Smith" ,"will","1111",new ArrayList<>() ));
           userService.saveUser(new User(null,"Jim" ,"carry","2222",new ArrayList<>() ));
           userService.saveUser(new User(null,"Astron" ,"maya","123123",new ArrayList<>() ));

           userService.addRoleToUser("ima","ROLE_USER");
           userService.addRoleToUser("ima","ROLE_SUPER_ADMIN");
           userService.addRoleToUser("will","ROLE_MANAGER");
           userService.addRoleToUser("carry","ROLE_ADMIN");
           userService.addRoleToUser("maya","ROLE_SUPER_ADMIN");
        };
    }

}
