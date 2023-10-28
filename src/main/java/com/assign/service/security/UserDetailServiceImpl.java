package com.assign.service.security;

import com.assign.entity.po.StaffPO;
import com.assign.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final StaffService staffService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 这里我默认填写了一个用户，实际中你可以使用参数 username 查询数据库，获取真实用户信息来返回
        StaffPO user = staffService.selectByUserCode(username);
        return User.builder().username(user.getCode()).password(passwordEncoder.encode(user.getPassword())).disabled(false)
                .accountExpired(false).credentialsExpired(false).accountLocked(false).authorities(user.getCode()).build();
    }
}