package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;

import java.util.List;

public interface SchedulingService {
    List<SchedulingDO> findAll();


    SchedulingDO findById(String xh);



    int add(SchedulingDO hpb);


    int del(Integer xh);
}
