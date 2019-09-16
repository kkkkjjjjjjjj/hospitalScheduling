package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;

import java.util.List;

public interface TodayInfoService {
    List<TodayInfoDO> findAll();

    TodayInfoDO findById(String id);

    int up(TodayInfoDO ht);
    int add(TodayInfoDO ht);
}
