package system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import model.system.SysDept;
import system.exception.GuiguException;
import system.mapper.SysDeptMapper;
import system.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import system.utils.DeptHelper;

import java.util.List;

/**
 * <p>
 * 组织机构 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-09-05
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
    //菜单列表（树形）
    @Override
    public List<SysDept> findNodes() {
        //获取所有菜单
        List<SysDept> sysDeptList = baseMapper.selectList(null);
        //所有菜单数据转换要求数据格式
        return DeptHelper.bulidTree(sysDeptList);
    }

    //删除菜单
    @Override
    public void removeDeptById(String id) {
        //查询当前删除菜单下面是否子菜单
        QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        if(count > 0) {//有子菜单
            throw new GuiguException(201,"请先删除子菜单");
        }
        //调用删除
        baseMapper.deleteById(id);
    }
}
