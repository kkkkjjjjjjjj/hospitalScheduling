package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.PaibanDicthlbDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PaibanDicthlbMapper {
    @Select("select * from HR_PAIBAN_DICT_HLB")
    List<PaibanDicthlbDO> findAll();

    @Select("select * from HR_PAIBAN_DICT_HLB where xh=#{xh}")
    PaibanDicthlbDO findById(String xh);


    @Insert("insert into HR_PAIBAN_DICT_HLB (xh,jc,xx,starttime,endtime,shijian,danwei)" +
            " values (#{xh},#{jc},#{xx},#{starttime},#{endtime},#{shijian},#{danwei})")
    int add(PaibanDicthlbDO paibanDicthlbDO);

    @Delete("delete from Hrpaibandicthlb where xh=#{xh} ")
    int del(Integer xh);
}
