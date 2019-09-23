package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import cn.mdsoftware.mdframework.dao.host.WardMapper;
import cn.mdsoftware.mdframework.service.host.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {
    @Autowired
    WardMapper wardMapper;

    @Override
    public List<WardDO> findAll() {
        return wardMapper.findAll();
    }



    @Override
    public int up(WardDO wardDO) {
        return wardMapper.up(wardDO);
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
