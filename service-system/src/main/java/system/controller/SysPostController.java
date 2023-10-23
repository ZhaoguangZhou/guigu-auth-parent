package system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.system.SysPost;
import model.vo.SysPostQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import system.annotation.Log;
import system.enums.BusinessType;
import system.service.SysPostService;

import java.util.List;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-09-04
 */
@Api(tags = "岗位管理接口")
@RestController
@RequestMapping("/admin/system/sysPost")
public class SysPostController {
    @Autowired
    private SysPostService sysPostService;

    //条件分页查询
    // page当前页  limit每页记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryPost(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysPostQueryVo sysPostQueryVo){
        IPage<SysPost> pageModel =  sysPostService.selectPage(page,limit,sysPostQueryVo);
        return Result.ok(pageModel);
    }

    //逻辑删除
    @Log(title = "岗位管理",businessType = BusinessType.DELETE)
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removePost(@PathVariable Long id){
        //调用方法删除
        boolean isSuccess = sysPostService.removeById(id);
        if(isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //修改-根据id查询
    @ApiOperation("根据id查询")
    @PostMapping("findPostById/{id}")
    public Result findPostById(@PathVariable Long id){
        SysPost sysPost = sysPostService.getById(id);
        return Result.ok(sysPost);
    }

    //修改-最终修改
    @Log(title = "岗位管理",businessType = BusinessType.UPDATE)
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result updatePost(@RequestBody SysPost sysPost){
        boolean isSuccess = sysPostService.updateById(sysPost);
        if(isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


    // 添加
    // @RequestBody 不能使用get提交方式
    // 传递json格式数据，把json格式数据封装到对象里面 {...}
    @Log(title = "岗位管理",businessType = BusinessType.INSERT)
    @ApiOperation("添加岗位")
    @PostMapping("save")
    public Result savePost(@RequestBody SysPost sysPost) {
        boolean isSuccess = sysPostService.save(sysPost);
        if(isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}

