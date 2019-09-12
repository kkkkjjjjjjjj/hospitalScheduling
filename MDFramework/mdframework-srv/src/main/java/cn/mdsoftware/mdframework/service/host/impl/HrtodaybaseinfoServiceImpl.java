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
    public Hrtodaybaseinfo findById(String gonghao) {
        return hbm.findById(gonghao);
    }

    @Override
    public int up(Hrtodaybaseinfo hb) {
        return hbm.up(hb);
    }

    @Override
    public int add(Hrtodaybaseinfo htb) {
        return hbm.add(htb);
    }


}
