package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulDO;
import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;

import java.util.List;
import java.util.Map;

public interface SchedulService {
    List<SchedulDO> list(Map<String, Object> map);
    int count(Map<String, Object> map);
}
