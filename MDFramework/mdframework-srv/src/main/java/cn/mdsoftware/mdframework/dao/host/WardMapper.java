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
            "select * from HR_PAIBAN_RENYUAN " +
            "<where>" +
            "<if test=\"xh != null and xh != ''\">"+ "and user_id = #{userId} " + "</if>" +
            "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
            "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" +
            "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" +
            "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" +
            "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
            "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" +
            "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" +
            "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" +
            "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
            "</where>"+
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "</script>")
    List<WardDO> list(Map<String,Object> param);
    @Select("<script>" +
            "select count(*) from sys_user " +
            "<where>" +
            "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
            "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
            "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" +
            "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" +
            "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" +
            "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
            "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" +
            "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" +
            "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" +
            "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
            "</where>"+
            "</script>")
    int count(Map<String,Object> map);

    @Update("update HR_PAIBAN_RENYUAN set xh=#{xh},user_name=#{userName},where user_name=#{userName}")
    int up(WardDO wardDO);

    @Select("select * from HR_PAIBAN_RENYUAN where user_name=#{userName}")
    WardDO findById(String userName);


    @Delete("delete from Hrpaibandicthlb where user_name=#{userName} ")
    int del(Integer userName);


}
