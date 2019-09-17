package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;
import cn.mdsoftware.mdframework.dao.host.TodayBaseInfoMapper;
import cn.mdsoftware.mdframework.service.host.TodayBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodayBaseInfoServiceImpl implements TodayBaseInfoService {
    @Autowired
    private TodayBaseInfoMapper todayBaseInfoMapper;

    @Override
    public List<TodayBaseInfoDO> findAll() {
        return todayBaseInfoMapper.findAll();
    }

    @Override
    public TodayBaseInfoDO findById(String gonghao) {
        return todayBaseInfoMapper.findById(gonghao);
    }

    @Override
    public int up(TodayBaseInfoDO todayBaseInfoDO) {
        return todayBaseInfoMapper.up(todayBaseInfoDO);
    }

    @Override
    public int add(TodayBaseInfoDO todayBaseInfoDO) {
        return todayBaseInfoMapper.add(todayBaseInfoDO);
    }
}
