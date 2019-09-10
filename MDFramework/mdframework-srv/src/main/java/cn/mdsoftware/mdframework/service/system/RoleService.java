package cn.mdsoftware.mdframework.service.system;

import java.util.List;

import cn.mdsoftware.mdframework.bean.entity.system.RoleDO;
import cn.mdsoftware.mdframework.bean.entity.system.RoleDO;
import org.springframework.stereotype.Service;

import cn.mdsoftware.mdframework.bean.entity.system.RoleDO;
@Service
public interface RoleService {
	RoleDO get(Long id);
	List<RoleDO> list();
	int save(RoleDO role);
	int update(RoleDO role);
	int remove(Long id);
	List<RoleDO> list(Long userId);
}
