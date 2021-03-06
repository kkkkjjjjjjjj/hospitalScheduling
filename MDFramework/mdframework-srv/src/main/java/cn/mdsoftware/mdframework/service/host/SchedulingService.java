package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.bean.entity.host.SchedulingInformationDO;

import java.util.List;
import java.util.Map;

public interface SchedulingService {
    List<SchedulingDO> list(Map<String,Object> param);

    boolean exit(Map<String, Object> params);

    SchedulingDO findById(Integer xh);

    int count(Map<String,Object> map);

    int save(SchedulingDO SchedulingDO);

    SchedulingDO findByJx(String jc);

    List<SchedulingInformationDO> listiInfo();

    List<SchedulingDO> listJc();

    int del(String jc);
}
