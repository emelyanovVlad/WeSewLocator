package com.we.sew.locator.auth;

import com.we.sew.locator.admin.db.entity.SystemUser;
import com.we.sew.locator.admin.db.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Component
public class SqlAuthProvider implements AuthenticationProvider {

    @Autowired
    private SystemUserRepository repository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        SystemUser systemUser = repository.findOneByEmail(email);
        String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
        if (systemUser == null || !systemUser.getPassword().equals(md5Pass)) {
            throw new BadCredentialsException("User or password is incorrect.");
        }
        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(systemUser.getRole().getName());
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(userAuthority);
        UserDetails principal = new User(systemUser.getEmail(), systemUser.getPassword(), authorities);

        return new UsernamePasswordAuthenticationToken(principal, systemUser.getPassword(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
