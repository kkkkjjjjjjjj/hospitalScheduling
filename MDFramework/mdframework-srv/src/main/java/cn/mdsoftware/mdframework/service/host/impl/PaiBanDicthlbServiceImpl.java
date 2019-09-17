package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.PaibanDicthlbDO;
import cn.mdsoftware.mdframework.dao.host.PaibanDicthlbMapper;
import cn.mdsoftware.mdframework.service.host.PaiBanDicthlbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaiBanDicthlbServiceImpl implements PaiBanDicthlbService {
    @Autowired
    private PaibanDicthlbMapper paibanDicthlbMapper;


    @Override
    public List<PaibanDicthlbDO> findAll() {
        return paibanDicthlbMapper.findAll();
    }

    @Override
    public PaibanDicthlbDO findById(String xh) {
        return paibanDicthlbMapper.findById(xh);
    }

    @Override
    public int add(PaibanDicthlbDO paibanDicthlbDO) {
        return paibanDicthlbMapper.add(paibanDicthlbDO);
    }

    @Override
    public int del(Integer xh) {

        return paibanDicthlbMapper.del(xh);
    }
}
