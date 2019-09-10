package cn.mdsoftware.mdframework.service.log.impl;

import java.util.List;

import cn.mdsoftware.mdframework.bean.PageDO;
import cn.mdsoftware.mdframework.bean.entity.log.SysLogDO;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.bean.PageDO;
import cn.mdsoftware.mdframework.bean.entity.log.SysLogDO;
import cn.mdsoftware.mdframework.common.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mdsoftware.mdframework.bean.PageDO;
import cn.mdsoftware.mdframework.bean.entity.log.SysLogDO;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.dao.log.LogMapper;
import cn.mdsoftware.mdframework.service.log.LogService;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogMapper logMapper;

	@Override
	public PageDO<SysLogDO> queryList(Query query) {
		List<SysLogDO> logs = logMapper.list(query);
		int total = logMapper.count();
		PageDO<SysLogDO> page = new PageDO<>();
		page.setTotal(total);
		page.setRows(logs);
		return page;
	}

	@Override
	public int remove(Long id) {
		int count = logMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(List<Long> ids) {
		int count = logMapper.batchRemove(ids);
		return count;
	}
}
