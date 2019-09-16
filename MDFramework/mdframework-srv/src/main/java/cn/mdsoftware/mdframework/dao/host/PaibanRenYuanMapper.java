package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.PaibanRenYuanDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PaibanRenYuanMapper {
    @Select("select * from HR_PAIBAN_RENYUAN")
    List<PaibanRenYuanDO> findAll();


    @Update("update Hrtodaybaseinfo set xh=#{xh},name=#{name}," +
            "ward_code=#{wardCode},ward_name=#{wardName},zu=#{zu} where user_name=#{userName}")
    int up(PaibanRenYuanDO paibanRenYuanDO);


    @Delete("delete from Hrpaibandicthlb where user_name=#{userName} ")
    int del(Integer userName);



}
