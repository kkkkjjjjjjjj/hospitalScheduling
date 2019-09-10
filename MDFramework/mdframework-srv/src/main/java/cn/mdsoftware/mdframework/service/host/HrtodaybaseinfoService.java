package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodaybaseinfo;

import java.util.List;

public interface HrtodaybaseinfoService {

    List<Hrtodaybaseinfo> findAll();

    Hrtodaybaseinfo findById(String id);

    int up(Hrtodaybaseinfo hb);
}
