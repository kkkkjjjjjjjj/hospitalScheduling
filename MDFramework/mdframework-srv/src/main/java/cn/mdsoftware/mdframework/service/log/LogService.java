package cn.mdsoftware.mdframework.service.log;

import java.util.List;

import cn.mdsoftware.mdframework.bean.PageDO;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.bean.PageDO;
import cn.mdsoftware.mdframework.common.utils.Query;
import org.springframework.stereotype.Service;

import cn.mdsoftware.mdframework.bean.PageDO;
import cn.mdsoftware.mdframework.bean.entity.log.SysLogDO;
import cn.mdsoftware.mdframework.common.utils.Query;
@Service
public interface LogService {
	PageDO<SysLogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(List<Long> ids);
}
