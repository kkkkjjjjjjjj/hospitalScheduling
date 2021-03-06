package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;
import cn.mdsoftware.mdframework.dao.host.TodayBaseInfoMapper;
import cn.mdsoftware.mdframework.service.host.TodayBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TodayBaseInfoServiceImpl implements TodayBaseInfoService {
    @Autowired
    private TodayBaseInfoMapper todayBaseInfoMapper;

    @Override
    public List<TodayBaseInfoDO> findAll(Map<String, Object> map) {
        return todayBaseInfoMapper.findAll(map);
    }

    @Override
    public TodayBaseInfoDO findById(String gonghao) {
        return todayBaseInfoMapper.findById(gonghao);
    }

    @Override
    public int up(TodayBaseInfoDO todayBaseInfoDO) {
        int r=todayBaseInfoMapper.up(todayBaseInfoDO);
        return r;
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = todayBaseInfoMapper.findAll(params).size() > 0;
        return exit;
    }

}
