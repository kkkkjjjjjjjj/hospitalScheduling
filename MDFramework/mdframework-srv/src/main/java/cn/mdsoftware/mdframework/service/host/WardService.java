package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;

import java.util.List;

public interface WardService {

    List<WardDO> findAll();


    int up(WardDO wardDO);

    WardDO findById(String userName);


    int del(Integer userName);
}
