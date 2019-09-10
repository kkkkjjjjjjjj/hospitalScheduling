package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodayinfo;

import java.util.List;

public interface HrtodayinfoService {

    List<Hrtodayinfo> findAll();

    Hrtodayinfo findById(String id);

    int up(Hrtodayinfo ht);
}
