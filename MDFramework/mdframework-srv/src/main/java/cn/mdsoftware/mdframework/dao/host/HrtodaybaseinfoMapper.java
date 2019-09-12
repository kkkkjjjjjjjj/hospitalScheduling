package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodaybaseinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HrtodaybaseinfoMapper {

    @Select("select * from hr_today_baseinfo")
    List<Hrtodaybaseinfo>findAll();

    @Select("select * from Hrtodaybaseinfo where gonghao=#{gonghao}")
    Hrtodaybaseinfo findById(String gonghao);

    @Update("update Hrtodaybaseinfo set gonghao=#{gonghao},name=#{name},sex=#{sex}," +
            "height=#{height},natton=#{natton},class=#{Classa},birthday=#{birthday}," +
            "mianmao=#{mianmao},job=#{job},job_date=#{job_date},shenfen=#{shenfen}," +
            "js_type=#{js_type},js_date=#{js_date},job_no=#{job_no},work_date=#{work_date}," +
            "in_date=#{in_date},out_date=#{out_date},hunyin=#{hunyin},yunqing=#{yunqing}," +
            "tel=#{tel},jiguan=#{jiguan},job_sx=#{job_sx},tijiao=#{tijiao}," +
            "tijiaodate=#{tijiaodate},ztijiao=#{ztijiao},zgonghao=#{zgonghao}," +
            "ztijiaodate=#{ztijiaodate},lzyy=#{lzyy},lzdate=#{lzdate}," +
            "zhaopian=#{zhaopian},xuehui=#{xuehui},zhuanke=#{zhuanke} where id=#{id}")
    int up(Hrtodaybaseinfo hb);

    @Insert("insert into Hrtodaybaseinfo (student,score) values (#{student},#{score})")
    public int add(Hrtodaybaseinfo htb);
}
