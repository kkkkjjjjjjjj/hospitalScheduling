package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodayinfo;
import cn.mdsoftware.mdframework.dao.host.HrtodayinfoMapper;
import cn.mdsoftware.mdframework.service.host.HrtodayinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrtodayinfoServiceImpl implements HrtodayinfoService {

    @Autowired
    private HrtodayinfoMapper htm;

    @Override
    public List<Hrtodayinfo> findAll() {
        return htm.findAll();
    }

    @Override
    public Hrtodayinfo findById(String id) {
        return htm.findById(id);
    }

    @Override
    public int up(Hrtodayinfo ht) {
        return htm.up(ht);
    }

    @Override
    public int add(Hrtodayinfo ht) {
        return htm.add(ht);
    }
}
