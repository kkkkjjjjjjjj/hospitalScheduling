package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingInformationDO;
import cn.mdsoftware.mdframework.dao.host.SchedulingInformationMapper;
import cn.mdsoftware.mdframework.service.host.SchedulingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchedulingInformationServiceImpl implements SchedulingInformationService {
    @Autowired
    private SchedulingInformationMapper schedulingInformationMapper;

    @Override
    public List<SchedulingInformationDO> list(Map<String, Object> param) {
        return schedulingInformationMapper.list(param);
    }

    @Override
    public List<SchedulingInformationDO> listName() {
        return schedulingInformationMapper.listName();
    }

    @Override
    public int count(Map<String, Object> map) {
        return schedulingInformationMapper.count(map);
    }

    @Override
    public int del(Map<String,Object> param) {
        return schedulingInformationMapper.del(param);
    }

    @Override
    public int save(SchedulingInformationDO schedulingInformationDO) {
        return schedulingInformationMapper.save(schedulingInformationDO);
    }

    @Override
    public List<SchedulingInformationDO> listF() {
        return schedulingInformationMapper.listF();
    }

    @Override
    public SchedulingInformationDO ById(String wardName) {
        return schedulingInformationMapper.ById(wardName);
    }


}
