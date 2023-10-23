package system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import model.system.SysPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.vo.SysPostQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 岗位信息表 Mapper 接口
 * </p>
 *
 * @author atguigu
 * @since 2023-09-04
 */
@Repository
public interface SysPostMapper extends BaseMapper<SysPost> {
    //条件分页查询
    IPage<SysPost> selectPage(Page<SysPost> pageParam, @Param("vo") SysPostQueryVo sysPostQueryVo);
}
