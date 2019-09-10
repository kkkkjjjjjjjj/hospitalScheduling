package cn.mdsoftware.mdframework.service.member.impl;

import java.util.List;
import java.util.Map;

import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.dao.member.MemberMapper;
import cn.mdsoftware.mdframework.service.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDO get(Integer id){
		return memberMapper.get(id);
	}
	
	@Override
	public List<MemberDO> list(Map<String, Object> map){
		return memberMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return memberMapper.count(map);
	}
	
	@Override
	public int save(MemberDO member){
		return memberMapper.save(member);
	}
	
	@Override
	public int update(MemberDO member){
		return memberMapper.update(member);
	}
	
	@Override
	public int remove(Integer id){
		return memberMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return memberMapper.batchRemove(ids);
	}

	@Override
	public int resetPwd(MemberDO member) {
		int r = memberMapper.update(member);
		return r;
	}
	
}
