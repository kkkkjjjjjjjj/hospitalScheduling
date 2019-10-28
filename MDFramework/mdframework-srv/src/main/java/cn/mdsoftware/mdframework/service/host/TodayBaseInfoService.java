package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;

import java.util.List;
import java.util.Map;

public interface TodayBaseInfoService {
    List<TodayBaseInfoDO> findAll(Map<String, Object> map);

    TodayBaseInfoDO findById(String gonghao);

    int up(TodayBaseInfoDO hb);
    boolean exit(Map<String, Object> params);

//    int add(TodayBaseInfoDO htb);
}
