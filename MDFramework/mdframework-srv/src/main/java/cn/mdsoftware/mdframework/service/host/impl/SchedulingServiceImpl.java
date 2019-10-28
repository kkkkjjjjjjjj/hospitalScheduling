package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.bean.entity.host.SchedulingInformationDO;
import cn.mdsoftware.mdframework.dao.host.SchedulingMapper;
import cn.mdsoftware.mdframework.service.host.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchedulingServiceImpl implements SchedulingService {
    @Autowired
    private SchedulingMapper schedulingMapper;


    @Override
    public List<SchedulingDO> list(Map<String, Object> param) {
        return schedulingMapper.list(param);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = schedulingMapper.list(params).size() > 0;
        return exit;
    }

    @Override
    public SchedulingDO findById(Integer xh) {
        return schedulingMapper.findById(xh);
    }

    @Override
    public int count(Map<String, Object> map) {
        return schedulingMapper.count(map);
    }

    @Override
    public int save(SchedulingDO SchedulingDO) {
        return schedulingMapper.save(SchedulingDO);
    }

    @Override
    public SchedulingDO findByJx(String jc) {
        return schedulingMapper.findByJx(jc);
    }

    @Override
    public List<SchedulingInformationDO> listiInfo() {
        return schedulingMapper.listiInfo();
    }

    @Override
    public List<SchedulingDO> listJc() {
        return schedulingMapper.listJc();
    }


    @Override
    public int del(String jc) {
        return schedulingMapper.del(jc);
    }
}
