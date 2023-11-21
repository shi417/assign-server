package com.assign.controller;

import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.assign.AssignRequestDTO;
import com.assign.entity.po.AssignPO;
import com.assign.service.assign.AssignService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assign")
@RequiredArgsConstructor
public class AssignController {


    private final AssignService assignService;
    @ApiOperation(value = "查询认领列表", notes = "查询认领列表", httpMethod = "POST")
    @PostMapping("/list")
    public ResponseResult<Page<AssignPO>> getList(@RequestBody AssignRequestDTO params){
        return assignService.selectPage(params);
    }

    @ApiOperation(value = "新增/更新认领记录", notes = "新增/更新认领记录", httpMethod = "POST")
    @PostMapping("/saveOrUpdate")
    public ResponseResult<Object> saveOrUpdate(@RequestBody AssignRequestDTO params){
        return assignService.saveOrUpdate(params);
    }

}
