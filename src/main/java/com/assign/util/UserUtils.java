package com.assign.util;

import com.assign.entity.dto.staff.StaffDTO;
import com.assign.entity.po.StaffPO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static StaffDTO getLoginStaff(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        StaffDTO res = new StaffDTO();
        if (authentication != null && authentication.isAuthenticated()) {
            // 获取当前登录用户名
            res.setCode(authentication.getName());
        }
        return res;
    }
}
