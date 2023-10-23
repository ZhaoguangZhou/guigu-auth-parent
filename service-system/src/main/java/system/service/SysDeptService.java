package system.service;

import model.system.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 组织机构 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-09-05
 */
public interface SysDeptService extends IService<SysDept> {
    //部门列表（树形）
    List<SysDept> findNodes();

    //删除部门
    void removeDeptById(String id);
}
