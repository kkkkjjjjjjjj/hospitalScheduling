package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.dao.host.SchedulingMapper;
import cn.mdsoftware.mdframework.service.host.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchedulingServiceImpl implements SchedulingService {
    @Autowired
    private SchedulingMapper schedulingMapper;


    @Override
    public List<SchedulingDO> findAll() {
        return schedulingMapper.findAll();
    }

    @Override
    public SchedulingDO findById(String xh) {
        return schedulingMapper.findById(xh);
    }

    @Override
    public int add(SchedulingDO paibanDicthlbDO) {
        return schedulingMapper.add(paibanDicthlbDO);
    }

    @Override
    public int del(Integer xh) {

        return schedulingMapper.del(xh);
    }
}
