package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import cn.mdsoftware.mdframework.dao.host.TodayInfoMapper;
import cn.mdsoftware.mdframework.service.host.TodayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TodayInfoServiceImpl implements TodayInfoService {
    @Autowired
    private TodayInfoMapper todayInfoMapper;

    @Override
    public List<TodayInfoDO> findAll(Map<String, Object> map) {
        return todayInfoMapper.findAll(map);
    }
    @Override
    public Integer count(Map<String, Object> map) {
        return todayInfoMapper.count(map);
    }

    @Override
    public TodayInfoDO findById(String id) {
        return todayInfoMapper.findById(id);
    }



    @Override
    public int up(TodayInfoDO todayInfoDO) {
        return todayInfoMapper.up(todayInfoDO);
    }

    @Override
    public int add(TodayInfoDO todayInfoDO) {
        return todayInfoMapper.add(todayInfoDO);
    }
}
