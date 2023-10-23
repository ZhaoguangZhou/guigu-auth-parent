package system.controller;


import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.system.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.annotation.Log;
import system.enums.BusinessType;
import system.service.SysDeptService;

import java.util.List;

/**
 * <p>
 * 组织机构 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-09-05
 */
@Api(tags = "部门管理接口")
@RestController
@RequestMapping("/admin/system/sysDept")
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;
    
    //部门列表（树形）
    @ApiOperation("菜单列表")
    @GetMapping("findNodes")
    public Result findNodes() {
        List<SysDept> list = sysDeptService.findNodes();
        return Result.ok(list);
    }

    //添加部门
    @Log(title = "部门管理",businessType = BusinessType.INSERT)
    @ApiOperation("添加菜单")
    @PostMapping("save")
    public Result save(@RequestBody SysDept sysDept) {
        sysDeptService.save(sysDept);
        return Result.ok();
    }

    //删除部门
    @Log(title = "部门管理",businessType = BusinessType.DELETE)
    @ApiOperation("删除菜单")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        sysDeptService.removeDeptById(id);
        return Result.ok();
    }

    //修改
    @Log(title = "部门管理",businessType = BusinessType.UPDATE)
    @ApiOperation("修改菜单")
    @PostMapping("update")
    public Result update(@RequestBody SysDept sysDept) {
        sysDeptService.updateById(sysDept);
        return Result.ok();
    }

    //根据id查询
    @ApiOperation("根据id查询菜单")
    @GetMapping("findNode/{id}")
    public Result findNode(@PathVariable String id) {
        SysDept sysDept = sysDeptService.getById(id);
        return  Result.ok(sysDept);
    }
}

