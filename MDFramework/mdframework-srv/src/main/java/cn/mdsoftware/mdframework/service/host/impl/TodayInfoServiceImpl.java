package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import cn.mdsoftware.mdframework.dao.host.TodayInfoMapper;
import cn.mdsoftware.mdframework.service.host.TodayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodayInfoServiceImpl implements TodayInfoService {
    @Autowired
    private TodayInfoMapper htm;

    @Override
    public List<TodayInfoDO> findAll() {
        return htm.findAll();
    }

    @Override
    public TodayInfoDO findById(String id) {
        return htm.findById(id);
    }

    @Override
    public int up(TodayInfoDO ht) {
        return htm.up(ht);
    }

    @Override
    public int add(TodayInfoDO ht) {
        return htm.add(ht);
    }
}
