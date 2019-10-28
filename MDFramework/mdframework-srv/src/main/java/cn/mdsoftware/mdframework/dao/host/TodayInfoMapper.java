package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TodayInfoMapper {
    //查询所有
    @Select("select * from hr_today_info")
    List<TodayInfoDO> findAll(Map<String, Object> map);
    //查询总数
    @Select("select count(1) from hr_today_info ")
    Integer count(Map<String, Object> map);
    //根据ID查询
    @Select("select * from hr_today_info where id=#{id}")
    TodayInfoDO findById(String id);

        //修改
    @Update("<script>"+
            "update hr_today_info" +
            "<set>" +
            "<if test=\"name != null\"> name  = #{name}, </if> " +
            "<if test=\"byDate != null\"> by_date  = #{byDate}, </if> " +
            "<if test=\"byDaXue != null\"> by_date  = #{byDaXue}, </if> " +
            "<if test=\"zhuanYe != null\"> zhuanye  = #{zhuanYe}, </if> " +
            "<if test=\"eduType != null\"> edu_type  = #{eduType}, </if> " +
            "<if test=\"xueWei != null\"> xuewei  = #{xueWei}, </if> " +
            "<if test=\"xueLi != null\"> xueli  = #{xueLi}, </if> " +
            "<if test=\"jsjLevel != null\"> jsj_level  = #{jsjLevel}, </if> " +
            "</set>" +
            "where id=#{id}"+
            "</script>")
    int up(TodayInfoDO todayInfoDO);
    //添加
    @Insert("insert into hr_today_info (student,score) values (#{student},#{score})")
    public int add(TodayInfoDO todayInfoDO);

}

