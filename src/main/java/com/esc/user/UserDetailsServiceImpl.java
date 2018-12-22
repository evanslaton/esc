package com.esc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository ApplicationUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = this.ApplicationUserRepo.findByUsername(username);

        if (user == null) {
            System.out.println("User not found: " + username);
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }

        System.out.println("Found User: " + user);
        return user;
    }
}