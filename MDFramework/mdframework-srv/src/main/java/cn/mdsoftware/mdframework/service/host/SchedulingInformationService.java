package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingInformationDO;

import java.util.List;
import java.util.Map;

public interface SchedulingInformationService {

    List<SchedulingInformationDO> list(Map<String,Object> param);

    List<SchedulingInformationDO> listName();

    int count(Map<String,Object> map);
    int del(Map<String,Object> param);

    int save(SchedulingInformationDO schedulingInformationDO);

    List<SchedulingInformationDO> listF();

    SchedulingInformationDO ById(String wardName);

}
