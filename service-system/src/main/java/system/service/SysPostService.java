package system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import model.system.SysPost;
import com.baomidou.mybatisplus.extension.service.IService;
import model.vo.SysPostQueryVo;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-09-04
 */
public interface SysPostService extends IService<SysPost> {
    //条件分页查询
    IPage<SysPost> selectPage(long page, long limit, SysPostQueryVo sysPostQueryVo);
    //更改岗位状态
    void updateStatus(String id, Integer status);
}
