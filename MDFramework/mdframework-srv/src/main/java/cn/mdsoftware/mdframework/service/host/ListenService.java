package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.host.ListenDO;

import java.util.List;
import java.util.Map;

public interface ListenService {

    List<ListenDO> list(Map<String, Object> map);
    int count(Map<String, Object> map);
}
