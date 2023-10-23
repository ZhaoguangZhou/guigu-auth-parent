package system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import model.system.SysPost;
import model.vo.SysPostQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import system.mapper.SysPostMapper;
import system.service.SysPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-09-04
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {

    @Autowired
    private SysPostMapper sysPostMapper;

    //条件分页查询
    @Override
    public IPage<SysPost> selectPage(long page, long limit, SysPostQueryVo sysPostQueryVo) {
        //创建page对象
        Page<SysPost> pageParam=new Page<>(page,limit);
        //获取条件值
        String name=sysPostQueryVo.getName();
        String postCode=sysPostQueryVo.getPostCode();
        //封装条件
        QueryWrapper<SysPost> wrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(postCode)) {
            wrapper.like("post_code",postCode);
        }
        return sysPostMapper.selectPage(pageParam,wrapper);
    }

    //更改岗位状态
    @Override
    public void updateStatus(String id, Integer status) {
        //根据用户id查询
        SysPost sysPost = baseMapper.selectById(id);
        //设置修改状态
        sysPost.setStatus(status);
        //调用方法修改
        baseMapper.updateById(sysPost);
    }
}
