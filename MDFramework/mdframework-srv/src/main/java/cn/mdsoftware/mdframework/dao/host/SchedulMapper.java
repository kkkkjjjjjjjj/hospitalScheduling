package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchedulMapper {
    public final static String selectsql = "obj.* ";
    public final static String joinsql = "";

    public final static String wheresql = "<where> " +
            "<if test=\"name != null and name != ''\">"+ "and obj.name = #{name} " + "</if>" +
            "<if test=\"id != null and id != ''\">"+ "and obj.id = #{id} " + "</if>" +
            "<if test=\"riqi != null and riqi != ''\">"+ "and obj.riqi = to_date(#{riqi},'yyyy-mm-dd') " + "</if>" +
            "<if test=\"date != null and date != ''\">"+ "and obj.riqi = (to_date(#{date},'yyyy-mm-dd') + #{day}) " + "</if>" +
            "<if test=\"jc != null and jc != ''\">"+ "and obj.jc = #{jc} " + "</if>" +
            "<if test=\"bz != null and bz != ''\">"+ "and obj.bz = #{bz} " + "</if>" +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.xh = #{xh} " + "</if>" +
            "<if test=\"zu != null and zu != ''\">"+ "and obj.zu = #{zu} " + "</if>" +
            "</where>";

    @Select("<script>" +
            "select "+selectsql+" from HR_PAIBAN obj " + joinsql +
            wheresql +
            "and ROWNUM=1 ORDER BY RIQI" +
            "</script>")
    List<SchedulDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from HR_PAIBAN obj " + joinsql +
            wheresql +
            "</script>")
    int count(Map<String, Object> map);


    @Update("<script>"+
            "update HR_PAIBAN " +
            "<set>" +
            "<if test=\"name != null\"> name  = #{name}, </if>" +
            "<if test=\"mainPic != null\"> main_pic  = #{mainPic}, </if>" +
            "<if test=\"riqi != null\"> riqi  = #{riqi}, </if>" +
            "<if test=\"jc != null\"> jc  = #{jc}, </if>" +
            "</set>" +
            "<where> " +
            "<if test=\"id != null and id != ''\">"+ "and obj.id = #{id} " + "</if>" +
            "<if test=\"riqi != null and riqi != ''\">"+ "and obj.riqi = to_date(#{riqi},'yyyy-mm-dd') " + "</if>" +
            "</where>"+
            "</script>")
    int update(SchedulDO schedulDO);

    @Select("select * from HR_PAIBAN where name=#{name} and ROWNUM=1 ORDER BY RIQI ")
    SchedulDO ByName(String name);



}
