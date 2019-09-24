package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface WardMapper {
    @Select("<script>" +
            "select * from HR_PAIBAN_RENYUAN ORDER BY XH" +
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "</script>")
    List<WardDO> list(Map<String,Object> param);

    @Select("select count(*) from HR_PAIBAN_RENYUAN ")
    int count(Map<String,Object> map);

    @Update("update HR_PAIBAN_RENYUAN set xh=#{xh},user_name=#{userName},where user_name=#{userName}")
    int update(WardDO wardDO);


    @Select("select * from HR_PAIBAN_RENYUAN where user_name=#{userName}")
    WardDO findById(String userName);


    @Delete("delete from Hrpaibandicthlb where user_name=#{userName} ")
    int del(Integer userName);


}
