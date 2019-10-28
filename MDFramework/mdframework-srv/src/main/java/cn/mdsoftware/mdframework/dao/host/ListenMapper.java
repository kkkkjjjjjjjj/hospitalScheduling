package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.ListenDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface ListenMapper {

    public  final static String selectsql = "obj.* ";
    public final static String joinsql = "";

    public final static String wheresql = "<where> " +
            "<if test=\"wardCode != null and wardCode != ''\">"+ "and obj.ward_code = #{wardCode} " + "</if>" +
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.ward_name = #{wardName} " + "</if>" +
            "<if test=\"ting != null and ting != ''\">"+ "and obj.ting = #{ting} " + "</if>" +
            "<if test=\"riqi != null and riqi != ''\">"+ "and obj.riqi = to_date(#{riqi},'yyyy-mm-dd') " + "</if>" +
            "<if test=\"date != null and date != ''\">"+ "and obj.riqi = (to_date(#{date},'yyyy-mm-dd') + #{day}) " + "</if>" +
            "<if test=\"jc != null and jc != ''\">"+ "and obj.jc = #{jc} " + "</if>" +
            "</where>";

    @Select("<script>" +
            "select "+selectsql+" from HR_TINGBAN obj " + joinsql +
            wheresql +
            "</script>")
    List<ListenDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from HR_TINGBAN obj " + joinsql +
            wheresql +
            "</script>")
    int count(Map<String, Object> map);
}
