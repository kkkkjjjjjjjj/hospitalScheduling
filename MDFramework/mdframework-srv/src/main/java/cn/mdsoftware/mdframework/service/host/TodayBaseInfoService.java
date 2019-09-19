package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodayBaseInfoService {
    List<TodayBaseInfoDO> findAll();

    TodayBaseInfoDO findById(String gonghao);

    int up(TodayBaseInfoDO hb);

    int add(TodayBaseInfoDO htb);
}
