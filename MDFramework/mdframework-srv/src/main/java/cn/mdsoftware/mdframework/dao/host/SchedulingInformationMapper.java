package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingInformationDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchedulingInformationMapper {
    @Select("<script>" +
            "select * from HR_PAIBAN_DICT obj " +
            "<where> " +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.XH = #{xh} " + "</if>" +
            "<if test=\"jc != null and jc != ''\">"+ "and obj.JC = #{jc} " + "</if>" +
            "<if test=\"xx != null and xx != ''\">"+ "and obj.XX = #{xx} " + "</if>" +
            "<if test=\" wardCode!= null and wardCode != ''\">"+ "and obj.WARD_CODE = #{wardCode} " + "</if>" +
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.WARD_NAME = #{wardName} " + "</if>" +
            "</where>"+
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "order by obj.XH"+
            "</script>")
    List<SchedulingInformationDO> list(Map<String,Object> param);


    @Select("select DISTINCT HR_PAIBAN_DICT.WARD_NAME from HR_PAIBAN_DICT")
    List<SchedulingInformationDO> listName();

    @Select("<script>" +
            "select count(*) from HR_PAIBAN_DICT obj "+
            "<where> " +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.XH = #{xh} " + "</if>" +
            "<if test=\"jc != null and jc != ''\">"+ "and obj.JC = #{jc} " + "</if>" +
            "<if test=\"xx != null and xx != ''\">"+ "and obj.XX = #{xx} " + "</if>" +
            "<if test=\" wardCode!= null and wardCode != ''\">"+ "and obj.WARD_CODE = #{wardCode} " + "</if>" +
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.WARD_NAME = #{wardName} " + "</if>" +
            "</where>"+
            "</script>")
    int count(Map<String,Object> map);

    @Select("select ward_code from HR_PAIBAN_DICT where ward_name=#{wardName}")
    SchedulingInformationDO ById(String wardName);


    @Delete("<script>"+
            "delete from HR_PAIBAN_DICT obj "+
            "<where> " +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.XH = #{xh}" +"</if>"+
            "<if test=\"jc != null and jc != ''\">"+ "and obj.JC = #{jc}" +"</if>"+
            "<if test=\"xx != null and xx != ''\">"+ "and obj.XX = #{xx}" +"</if>"+
            "<if test=\" wardCode!= null and wardCode != ''\">"+ "and obj.WARD_CODE = #{wardCode}" + "</if>"+
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.WARD_NAME = #{wardName}" + "</if>"+
            "</where>"+
            "</script>")
    int del(Map<String,Object> param);


    @Insert("INSERT INTO HR_PAIBAN_DICT(XH,JC,XX,WARD_CODE,WARD_NAME)" +
            " VALUES(#{xh}," +
            "#{jc}," +
            "#{xx}," +
            "(select DISTINCT HR_PAIBAN_DICT.WARD_CODE from HR_PAIBAN_DICT where WARD_NAME=#{wardName}),#{wardName})")
    int save(SchedulingInformationDO schedulingInformationDO);

    @Insert("<script>"+
            "INSERT INTO \n" +
            "HR_PAIBAN_DICT ( XH, JC, XX, WARD_CODE, WARD_NAME )VALUES\n" +
            "<foreach collection='testLists' item='item' index='index' separator=','>"+
            "(#{item.xh}, #{item.jc}, #{item.xx},#{item.wardName}, #{item.wardCode})"+
            "</foreach>"+
            "</script>")
    int saveB(List<String> list);


    @Select("select DISTINCT obj.jc from HR_PAIBAN_DICT obj")
    List<SchedulingInformationDO> listF();





}
