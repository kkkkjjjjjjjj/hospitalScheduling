package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodaybaseinfo;
import cn.mdsoftware.mdframework.dao.host.HrtodaybaseinfoMapper;
import cn.mdsoftware.mdframework.service.host.HrtodaybaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrtodaybaseinfoServiceImpl  implements HrtodaybaseinfoService {

    @Autowired
    private HrtodaybaseinfoMapper hbm;

    @Override
    public List<Hrtodaybaseinfo> findAll() {
        return hbm.findAll();
    }

    @Override
    public Hrtodaybaseinfo findById(String id) {
        return hbm.findById(id);
    }

    @Override
    public int up(Hrtodaybaseinfo hb) {
        return hbm.up(hb);
    }
}
