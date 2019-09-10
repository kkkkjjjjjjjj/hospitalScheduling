package cn.mdsoftware.mdframework.service.baseInfo;

import cn.mdsoftware.mdframework.bean.entity.baseInfo.BaseInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2018-02-08 17:57:16
 */
public interface BaseInfoService {
	
	BaseInfoDO get(Integer id);
	
	List<BaseInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BaseInfoDO baseInfo);
	
	int update(BaseInfoDO baseInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
