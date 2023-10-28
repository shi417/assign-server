package com.assign.controller;


import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.assign.AssignRequestDTO;
import com.assign.entity.dto.staff.StaffDTO;
import com.assign.entity.po.AssignPO;
import com.assign.entity.po.StaffPO;
import com.assign.service.StaffService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {


    private final StaffService staffService;

    @ApiOperation(value = "查询人员列表", notes = "查询人员列表", httpMethod = "POST")
    @PostMapping("/list")
    public ResponseResult<List<StaffPO>> getList(@RequestBody StaffDTO params){
        return staffService.selectPage(params);
    }
}
