package cn.mdsoftware.mdframework.service.host;

import cn.mdsoftware.mdframework.bean.entity.bannerInfo.BannerInfoDO;
import cn.mdsoftware.mdframework.bean.entity.host.DepartmentDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2018-07-27 16:39:48
 */
public interface DepartmentService {

	List<String> wardList();

	List<String> zhichengList();

	List<DepartmentDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	List<Map> chart(Map<String, Object> map);
}
