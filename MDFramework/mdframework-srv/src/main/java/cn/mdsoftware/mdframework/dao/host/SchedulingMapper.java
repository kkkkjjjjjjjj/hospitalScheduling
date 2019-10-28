package cn.mdsoftware.mdframework.dao.host;
import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.bean.entity.host.SchedulingInformationDO;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;


@Mapper
public interface SchedulingMapper {
    @Select("<script>" +
            "select * from HR_PAIBAN_DICT_HLB obj " +
            "<where> " +
            "<if test=\"xh != null and xh != ''\">"+ "and obj.XH = #{xh} " + "</if>" +
            "<if test=\"jc != null and jc != ''\">"+ "and obj.JC = #{jc} " + "</if>" +
            "<if test=\"xx != null and xx != ''\">"+ "and obj.XX = #{xx} " + "</if>" +
            "<if test=\" startTime!= null and startTime != ''\">"+ "and obj.STARTTIME = #{startTime} " + "</if>" +
            "<if test=\"endtime != null and endtime != ''\">"+ "and obj.ENDTIME = #{endtime} " + "</if>" +
            "<if test=\"shijian != null and shijian != ''\">"+ "and obj.SHIJIAN = #{shijian} " + "</if>" +
            "</where>"+
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "order by obj.XH"+
            "</script>")
    List<SchedulingDO> list(Map<String,Object> param);

    @Select("select DISTINCT HR_PAIBAN_DICT_HLB.ZU from HR_PAIBAN_DICT_HLB")
    List<SchedulingDO> listName();

    @Select("select count(*) from HR_PAIBAN_DICT_HLB ")
    int count(Map<String,Object> map);

    @Select("select * from HR_PAIBAN_DICT_HLB where xh=#{xh}")
    SchedulingDO findById(Integer xh);

    @Delete("delete from HR_PAIBAN_DICT_HLB where jc=#{jc} ")
    int del(String jc);

    @Insert("insert into HR_PAIBAN_DICT_HLB (xh,jc,xx,starttime,endtime,shijian)" +
            " values (#{xh},#{jc},#{xx},#{startTime},#{endtime},#{shijian})")
    int save(SchedulingDO paibanDicthlbDO);

    @Select("select DISTINCT HR_PAIBAN_RENYUAN.WARD_NAME from HR_PAIBAN_RENYUAN")
    List<SchedulingInformationDO> listiInfo();


    @Select("select * from HR_PAIBAN_DICT_HLB where jc=#{jc}")
    SchedulingDO findByJx(String jc);

    @Select("select DISTINCT HR_PAIBAN_DICT_HLB.jc from HR_PAIBAN_DICT_HLB")
    List<SchedulingDO> listJc();



}
