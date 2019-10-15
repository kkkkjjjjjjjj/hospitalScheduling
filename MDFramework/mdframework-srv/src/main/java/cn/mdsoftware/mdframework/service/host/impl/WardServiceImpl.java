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
    public List<WardDO> listName() {
        return wardMapper.listName();
    }

    @Override
    public WardDO findByWardCode(String code) {
        return wardMapper.findByWardCode(code);
    }

    @Override
    public int count(Map<String, Object> map) {
        return wardMapper.count(map);
    }

    @Override
    public int update(WardDO wardDO) {
        int r=wardMapper.update(wardDO);
        return r;
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = wardMapper.list(params).size() > 0;
        return exit;
    }

    @Override
    public WardDO findById(String userName) {
        return wardMapper.findById(userName);
    }

    @Override
    public int save(WardDO wardDO) {
        return wardMapper.save(wardDO);
    }


    @Override
    public int del(String userName) {
        return wardMapper.del(userName);
    }
}
