package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface TodayInfoMapper {
    @Select("select * from hr_today_info where rownum<=10")
    List<TodayInfoDO> findAll();

    @Select("select * from hr_today_info where gonghao=#{gonghao}")
    TodayInfoDO findById(String gonghao);


    @Update("update hr_today_info set name=#{name},by_date=#{by_date},zhuanye=#{zhuanye}," +
            "edu_type=#{edu_type},xuewei=#{xuewei},xueli=#{xueli},jsj_level=#{jsj_level}," +
            "wy_level =#{wy_level},ai_name=#{ai_name},ai_tel=#{ai_tel},ai_dw=#{ai_dw}," +
            "address=#{address},baby=#{baby},baby_type=#{baby_type},baby_date=#{baby_date}," +
            "tijiao=#{tijiao},tijiaodate=#{tijiaodate},ztijiao=#{ztijiao},zgonghao=#{zgonghao}," +
            "zitijiaodate=#{zitijiaodate},zgxl=#{zgxl},zgbydate=#{zgbydate},zgby_daxue=#{zgby_daxue}," +
            "zgzhuanye=#{zgzhuanye},zgedu_type=#{zgedu_type},zgxuewei=#{zgxuewei} where id='select t.id from HR_TODAY_INFO t'")
    int up(TodayInfoDO todayInfoDO);
    @Insert("insert into hr_today_info (student,score) values (#{student},#{score})")
    public int add(TodayInfoDO todayInfoDO);
}

