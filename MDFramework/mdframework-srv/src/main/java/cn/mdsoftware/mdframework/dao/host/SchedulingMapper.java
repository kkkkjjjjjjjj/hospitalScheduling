package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchedulingMapper {
    @Select("<script>" +
            "select * from HR_PAIBAN_DICT_HLB ORDER BY XH" +
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "</script>")
    List<SchedulingDO> list(Map<String,Object> param);

    @Select("select count(*) from HR_PAIBAN_DICT_HLB ")
    int count(Map<String,Object> map);

    @Select("select * from HR_PAIBAN_DICT_HLB where xh=#{xh}")
    SchedulingDO findById(Integer xh);


    @Insert("insert into HR_PAIBAN_DICT_HLB (xh,jc,xx,starttime,endtime,shijian,danwei)" +
            " values (#{xh},#{jc},#{xx},#{starttime},#{endtime},#{shijian},#{danwei})")
    int add(SchedulingDO paibanDicthlbDO);

    @Delete("delete from Hrpaibandicthlb where xh=#{xh} ")
    int del(Integer xh);
}
