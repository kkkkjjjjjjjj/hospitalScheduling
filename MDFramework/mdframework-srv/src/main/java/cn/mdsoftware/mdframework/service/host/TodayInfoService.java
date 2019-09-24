package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;

import java.util.List;
import java.util.Map;

public interface TodayInfoService {
    List<TodayInfoDO> findAll(Map<String, Object> map);
    Integer count(Map<String, Object> map);

    TodayInfoDO findById(String id);

    int up(TodayInfoDO ht);
    int add(TodayInfoDO ht);
}
