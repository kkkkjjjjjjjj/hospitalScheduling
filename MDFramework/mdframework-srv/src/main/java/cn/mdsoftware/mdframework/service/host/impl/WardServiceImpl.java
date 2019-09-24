package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import cn.mdsoftware.mdframework.dao.host.WardMapper;
import cn.mdsoftware.mdframework.service.host.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WardServiceImpl implements WardService {
    @Autowired
    WardMapper wardMapper;


    @Override
    public List<WardDO> list(Map<String, Object> map) {
        return wardMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return wardMapper.count(map);
    }

    @Override
    public int update(WardDO wardDO) {
        int r = wardMapper.update(wardDO);
        return r;
    }

    @Override
    public WardDO findById(String userName) {
        return wardMapper.findById(userName);
    }


    @Override
    public int del(Integer userName) {
        return wardMapper.del(userName);
    }
}
