package com.mrb.coding.service.impl;//package com.mrb.coding.service.impl;

import com.google.common.collect.Lists;
import com.mrb.coding.mapper.AccountRepository;
import com.mrb.coding.mapper.UserRepository;
import com.mrb.coding.model.domain.Account;
import com.mrb.coding.model.domain.Role;
import com.mrb.coding.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nydiarra on 06/05/17.
 */

public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            UserDetails newUserDetails = createUser(username);
            return newUserDetails;
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

    private UserDetails createUser(String username){

        User newUser = new User();
        newUser.setFirstName("Marta");
        newUser.setLastName("Rey");
        newUser.setPassword("234");
        Role newRole = new Role(); newRole.setRoleName("USER");
        newUser.setRoles(Lists.newArrayList(newRole));
        User user = userRepository.save(newUser);
        Account newAccount = new Account();
        newAccount.setFirstName("Marta");
        newAccount.setLastName("Rey");
        newAccount.setUserId(user.getId());
        accountRepository.save(newAccount);

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("USER"));
        });
        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(newUser.getUsername(),newUser.getPassword(),authorities);
        return userDetails;
    }

}
