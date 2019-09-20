package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.host.Schedul;
import cn.mdsoftware.mdframework.dao.host.SchedlMapper;
import cn.mdsoftware.mdframework.service.host.SchedlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchedlServiceImpl implements SchedlService {
    @Autowired
    SchedlMapper schedlMapper;
    @Override
    public List<Schedul> findAll() {
        return schedlMapper.findAll();
    }
}
