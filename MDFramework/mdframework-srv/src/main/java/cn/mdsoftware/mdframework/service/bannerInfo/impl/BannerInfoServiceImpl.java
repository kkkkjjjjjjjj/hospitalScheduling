package cn.mdsoftware.mdframework.service.bannerInfo.impl;

import cn.mdsoftware.mdframework.bean.entity.bannerInfo.BannerInfoDO;
import cn.mdsoftware.mdframework.dao.bannerInfo.BannerInfoMapper;
import cn.mdsoftware.mdframework.service.bannerInfo.BannerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class BannerInfoServiceImpl implements BannerInfoService {
	@Autowired
	private BannerInfoMapper bannerInfoMapper;
	
	@Override
	public BannerInfoDO get(Integer id){
		return bannerInfoMapper.get(id);
	}
	
	@Override
	public List<BannerInfoDO> list(Map<String, Object> map){
		return bannerInfoMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bannerInfoMapper.count(map);
	}
	
	@Override
	public int save(BannerInfoDO bannerInfo){
		return bannerInfoMapper.save(bannerInfo);
	}
	
	@Override
	public int update(BannerInfoDO bannerInfo){
		return bannerInfoMapper.update(bannerInfo);
	}
	
	@Override
	public int remove(Integer id){
		return bannerInfoMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return bannerInfoMapper.batchRemove(ids);
	}
	
}
