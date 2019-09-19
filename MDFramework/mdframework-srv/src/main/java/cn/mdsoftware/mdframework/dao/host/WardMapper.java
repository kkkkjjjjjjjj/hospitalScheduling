package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface WardMapper {
    @Select("select * from HR_PAIBAN_RENYUAN")
    List<WardDO> findAll();


    @Update("update Hrtodaybaseinfo set xh=#{xh},user_name=#{userName},where user_name=#{userName}")
    int up(WardDO paibanRenYuanDO);


    @Delete("delete from Hrpaibandicthlb where user_name=#{userName} ")
    int del(Integer userName);
}
