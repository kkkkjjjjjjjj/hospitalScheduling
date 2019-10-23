package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface WardMapper {

    public  final static String selectsql = "obj.* ";
    public final static String joinsql = "";


    public final static String wheresql = "<where> " +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.XH = #{xh} " + "</if>" +
            "<if test=\"userName != null and userName != ''\">"+ "and obj.USER_NAME = #{userName} " + "</if>" +
            "<if test=\"name != null and name != ''\">"+ "and obj.NAME = #{name} " + "</if>" +
            "<if test=\" wardCode!= null and wardCode != ''\">"+ "and obj.WARD_CODE = #{wardCode} " + "</if>" +
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.WARD_NAME = #{wardName} " + "</if>" +
            "<if test=\"zu != null and zu != ''\">"+ "and obj.ZU = #{zu} " + "</if>" +
            "</where>";

    @Select("<script>" +
            "select * from HR_PAIBAN_RENYUAN obj " +
            "<where> " +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.XH = #{xh} " + "</if>" +
            "<if test=\"userName != null and userName != ''\">"+ "and obj.USER_NAME = #{userName} " + "</if>" +
            "<if test=\"name != null and name != ''\">"+ "and obj.NAME = #{name} " + "</if>" +
            "<if test=\" wardCode!= null and wardCode != ''\">"+ "and obj.WARD_CODE = #{wardCode} " + "</if>" +
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.WARD_NAME = #{wardName} " + "</if>" +
            "<if test=\"zu != null and zu != ''\">"+ "and obj.ZU = #{zu} " + "</if>" +
            "</where>"+
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "order by obj.XH"+
            "</script>")
    List<WardDO> list(Map<String,Object> param);


    @Select("select DISTINCT HR_PAIBAN_RENYUAN.ZU from HR_PAIBAN_RENYUAN")
    List<WardDO> listName();

    @Select("<script>" +
            "select count(*) from HR_PAIBAN_RENYUAN obj "+
            "<where> " +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.XH = #{xh} " + "</if>" +
            "<if test=\"userName != null and userName != ''\">"+ "and obj.USER_NAME = #{userName} " + "</if>" +
            "<if test=\"name != null and name != ''\">"+ "and obj.NAME = #{name} " + "</if>" +
            "<if test=\" wardCode!= null and wardCode != ''\">"+ "and obj.WARD_CODE = #{wardCode} " + "</if>" +
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.WARD_NAME = #{wardName} " + "</if>" +
            "<if test=\"zu != null and zu != ''\">"+ "and obj.ZU = #{zu} " + "</if>" +
            "</where>"+
            "</script>"
            )
    int count(Map<String,Object> map);

    @Update("update HR_PAIBAN_RENYUAN set xh= #{xh},name=#{name},user_name=#{userName},zu=#{zu} where user_name=#{userName}")
    int update(WardDO wardDO);


    @Select("select * from HR_PAIBAN_RENYUAN where user_name=#{userName}")
    WardDO findById(String userName);

    @Select("select * from HR_PAIBAN_RENYUAN where WARD_CODE=#{code}")
    WardDO findByWardCode(String code);


    @Delete("delete from HR_PAIBAN_RENYUAN where user_name=#{userName} ")
    int del(String userName);

    @Insert("insert into HR_PAIBAN_RENYUAN (XH,USER_NAME,NAME,WARD_CODE,WARD_NAME,ZU) values (#{xh},#{userName},#{name},#{wardCode},#{wardName},#{zu})")
    int save(WardDO wardDO);


}
