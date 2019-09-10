package cn.mdsoftware.mdframework.service.member;


import java.util.List;
import java.util.Map;

import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;

/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-09-20 11:01:06
 */
public interface MemberService {
	
	MemberDO get(Integer id);
	
	List<MemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	int resetPwd(MemberDO member);
}
