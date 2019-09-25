package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import org.apache.ibatis.annotations.*;

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

    @Update("update HR_PAIBAN_RENYUAN set xh= #{xh},name=#{name},user_name=#{userName} where user_name=#{userName}")
    int update(WardDO wardDO);


    @Select("select * from HR_PAIBAN_RENYUAN where user_name=#{userName}")
    WardDO findById(String userName);


    @Delete("delete from HR_PAIBAN_RENYUAN where user_name=#{userName} ")
    int del(String userName);

    @Insert("insert into HR_PAIBAN_RENYUAN (XH,USER_NAME,NAME,WARD_CODE,WARD_NAME,ZU) values (#{xh},#{userName},#{name},#{wardCode},#{wardName},#{zu})")
    int save(WardDO wardDO);


}
