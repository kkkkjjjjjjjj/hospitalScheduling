package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.PaibanDicthlbDO;

import java.util.List;

public interface PaiBanDicthlbService {
    List<PaibanDicthlbDO> findAll();


    PaibanDicthlbDO findById(String xh);



    int add(PaibanDicthlbDO hpb);


    int del(Integer xh);
}
