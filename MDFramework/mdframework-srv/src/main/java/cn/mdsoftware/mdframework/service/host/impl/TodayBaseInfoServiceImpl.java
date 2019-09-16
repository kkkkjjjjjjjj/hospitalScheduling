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
    private TodayBaseInfoMapper hbm;

    @Override
    public List<TodayBaseInfoDO> findAll() {
        return hbm.findAll();
    }

    @Override
    public TodayBaseInfoDO findById(String gonghao) {
        return hbm.findById(gonghao);
    }

    @Override
    public int up(TodayBaseInfoDO hb) {
        return hbm.up(hb);
    }

    @Override
    public int add(TodayBaseInfoDO htb) {
        return hbm.add(htb);
    }
}
