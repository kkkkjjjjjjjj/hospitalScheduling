package cn.mdsoftware.mdframework.dao.host;

import cn.mdsoftware.mdframework.bean.entity.host.DepartmentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepartmentMapper {
    public  final static String selectsql = "obj.* ";
    public final static String joinsql = "";


    public final static String wheresql = "<where> " +
            "<if test=\"wardCode != null and wardCode != ''\">"+ "and obj.ward_code = #{wardCode} " + "</if>" +
            "<if test=\"wardName != null and wardName != ''\">"+ "and obj.ward_name = #{wardName} " + "</if>" +
            "<if test=\"userName != null and userName != ''\">"+ "and obj.user_name = #{userName} " + "</if>" +
            "<if test=\"name != null and name != ''\">"+ "and obj.name = #{name} " + "</if>" +
            "<if test=\"zhicheng != null and zhicheng != ''\">"+ "and obj.zhicheng = #{zhicheng} " + "</if>" +
            "<if test=\"xueli != null and xueli != ''\">"+ "and obj.xueli = #{xueli} " + "</if>" +
            "<if test=\"gongzuosj != null and gongzuosj != ''\">"+ "and obj.gongzuosj = #{gongzuosj} " + "</if>" +
            "<if test=\"gongzuonl != null and gongzuonl != ''\">"+ "and obj.gongzuonl = #{gongzuonl} " + "</if>" +
            "<if test=\"huojiangqk != null and huojiangqk != ''\">"+ "and obj.huojiangqk = #{huojiangqk} " + "</if>" +
            "<if test=\"inputTime != null and inputTime != ''\">"+ "and obj.input_time = #{inputTime} " + "</if>" +
            "<if test=\"recordnurse != null and recordnurse != ''\">"+ "and obj.recordnurse = #{recordnurse} " + "</if>" +
            "</where>";

    @Select("select "+selectsql+" from HR_KESHI_DJRYJBQK obj "+joinsql+" where obj.user_name = #{userName}")
    DepartmentDO getByUserName(Integer userName);

    @Select("select distinct ward_name from HR_KESHI_DJRYJBQK ")
    List<String> wardList();

    @Select("select distinct zhicheng from HR_KESHI_DJRYJBQK ")
    List<String> zhichengList();

    @Select("<script>" +
            "select "+selectsql+" from HR_KESHI_DJRYJBQK obj " + joinsql +
            wheresql +
            " <choose>" +
            "<when test=\"sort != null and sort.trim() != ''\">" +
            "order by obj.${sort} ${order}" +
            "</when>" +
            "<otherwise>" +
            "order by obj.id desc" +
            "</otherwise>" +
            "</choose>"+
            "</script>")
    List<DepartmentDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from HR_KESHI_DJRYJBQK obj " + joinsql +
            wheresql +
            "</script>")
    int count(Map<String, Object> map);

    @Select("<script>" +
            "SELECT " +
            " <choose>" +
            "<when test=\"condition != null\">" +
            "${condition} as \"condition\",COUNT(${condition}) as \"sum\",ratio_to_report(COUNT(1)) OVER() as \"proportion\"" +
            "</when>" +
            "<otherwise>" +
            "*" +
            "</otherwise>" +
            "</choose>"+
            "FROM HR_KESHI_DJRYJBQK obj " +
            wheresql +
            "<when test=\"condition != null\">" +
            "group by ${condition} " +
            "</when>" +
            "</script>")
    List<Map> chart(Map<String, Object> map);

}
