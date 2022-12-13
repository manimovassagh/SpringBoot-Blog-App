package com.github.manimovassagh.blog.security;

import com.github.manimovassagh.blog.entity.Role;
import com.github.manimovassagh.blog.entity.User;
import com.github.manimovassagh.blog.exception.ResourceNotFoundException;
import com.github.manimovassagh.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with user name or email" + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getEmail()
                , user.getPassword(),mapRolesToAuthorities(user.getRoles()
        ));

    }

private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
   return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
}
}
