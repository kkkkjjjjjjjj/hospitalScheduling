package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;

import java.util.List;
import java.util.Map;

public interface WardService {
    List<WardDO> list(Map<String, Object> map);


    List<WardDO> listName();

    WardDO findByWardCode(String code);

    int count(Map<String,Object> map);

    int update(WardDO wardDO);

    boolean exit(Map<String, Object> params);

    WardDO findById(String userName);


    int save(WardDO wardDO);

    int del(String userName);

    List<WardDO> listWard();
    List<WardDO> listZu();


}
