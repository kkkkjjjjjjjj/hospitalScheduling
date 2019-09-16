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
    private PaibanDicthlbMapper hp;


    @Override
    public List<PaibanDicthlbDO> findAll() {
        return hp.findAll();
    }

    @Override
    public PaibanDicthlbDO findById(String xh) {
        return hp.findById(xh);
    }

    @Override
    public int add(PaibanDicthlbDO hpb) {
        return hp.add(hpb);
    }

    @Override
    public int del(Integer xh) {

        return hp.del(xh);
    }
}
