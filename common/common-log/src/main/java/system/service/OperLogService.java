package system.service;

import model.system.SysOperLog;
import model.vo.SysOperLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface OperLogService {

    public void saveSysLog(SysOperLog sysOperLog);

    //操作日志分页查询
    IPage<SysOperLog> selectPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);
}
