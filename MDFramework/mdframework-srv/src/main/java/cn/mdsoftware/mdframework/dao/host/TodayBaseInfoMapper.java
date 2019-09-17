package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface TodayBaseInfoMapper {
    @Select("select * from hr_today_baseinfo")
    List<TodayBaseInfoDO> findAll();

    @Select("select * from Hrtodaybaseinfo where gonghao=#{gonghao}")
    TodayBaseInfoDO findById(String gonghao);

    @Update("update Hrtodaybaseinfo set gonghao=#{gongHao},name=#{name},sex=#{sex}," +
            "height=#{height},natton=#{natton},class=#{claezez},birthday=#{birthday}," +
            "mianmao=#{mianMao},job=#{Job},job_date=#{jobDate},shenfen=#{shenFen}," +
            "js_type=#{jsDate},js_date=#{js_date},job_no=#{job_no},work_date=#{workDate}," +
            "in_date=#{inDate},out_date=#{outDate},hunyin=#{hunYin},yunqing=#{yunQing}," +
            "tel=#{tel},jiguan=#{jiguan},job_sx=#{job_sx},tijiao=#{tijiao}," +
            "tijiaodate=#{tiJiaoDate},ztijiao=#{zTiJiao},zgonghao=#{zGongHao}," +
            "ztijiaodate=#{zTiJiaoDate},lzyy=#{Lzyy},lzdate=#{lzDate}," +
            "zhaopian=#{zhaoPian},xuehui=#{xueHui},zhuanke=#{zhuanKe} where id=#{id}")
    int up(TodayBaseInfoDO todayBaseInfoDO);

    @Insert("insert into Hrtodaybaseinfo (student,score) values (#{student},#{score})")
    public int add(TodayBaseInfoDO todayBaseInfoDO);
}
