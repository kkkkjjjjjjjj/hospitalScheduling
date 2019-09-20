package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.Schedul;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface SchedlMapper {
    @Select("select * from HR_PAIBAN_RENYUAN ORDER BY XH")
    List<Schedul> findAll();
}
