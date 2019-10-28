package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.ListenDO;
import cn.mdsoftware.mdframework.dao.host.ListenMapper;
import cn.mdsoftware.mdframework.service.host.ListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ListenServiceImpl implements ListenService {
    @Autowired
    ListenMapper listenMapper;

    @Override
    public List<ListenDO> list(Map<String, Object> map){
        return listenMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return listenMapper.count(map);
    }
}
