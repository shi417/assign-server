package com.assign.controller;

import com.assign.entity.common.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/logout")
    public ResponseResult logout(HttpServletRequest request, HttpServletResponse response) {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }
        return ResponseResult.success();
    }
}
