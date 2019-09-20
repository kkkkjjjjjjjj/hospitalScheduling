package cn.mdsoftware.mdframework.service.host.impl;

import cn.mdsoftware.mdframework.bean.entity.bannerInfo.BannerInfoDO;
import cn.mdsoftware.mdframework.bean.entity.host.DepartmentDO;
import cn.mdsoftware.mdframework.dao.bannerInfo.BannerInfoMapper;
import cn.mdsoftware.mdframework.dao.host.DepartmentMapper;
import cn.mdsoftware.mdframework.service.bannerInfo.BannerInfoService;
import cn.mdsoftware.mdframework.service.host.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<String> wardList(){
		return departmentMapper.wardList();
	}

	@Override
	public List<String> zhichengList(){
		return departmentMapper.zhichengList();
	}

	@Override
	public List<DepartmentDO> list(Map<String, Object> map){
		return departmentMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return departmentMapper.count(map);
	}

	@Override
	public List<Map> chart(Map<String, Object> map){
		return departmentMapper.chart(map);
	}



}
