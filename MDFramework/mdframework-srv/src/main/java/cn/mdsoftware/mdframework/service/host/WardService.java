package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WardService {

    List<WardDO> findAll();
    List<WardDO> findByXH();

    int up(WardDO paibanRenYuanDO);


    int del(Integer userName);
}
