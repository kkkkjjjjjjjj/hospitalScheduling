package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulDO;
import cn.mdsoftware.mdframework.dao.host.SchedulMapper;
import cn.mdsoftware.mdframework.service.host.SchedulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchedulServiceImpl implements SchedulService {
    @Autowired
    SchedulMapper schedulMapper;

    @Override
    public List<SchedulDO> list(Map<String, Object> map){
        return schedulMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return schedulMapper.count(map);
    }
}
