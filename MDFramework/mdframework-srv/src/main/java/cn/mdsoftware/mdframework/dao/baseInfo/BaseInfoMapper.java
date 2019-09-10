package cn.mdsoftware.mdframework.dao.baseInfo;

import cn.mdsoftware.mdframework.bean.entity.baseInfo.BaseInfoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2018-02-08 17:57:16
 */
@Mapper
public interface BaseInfoMapper {

    public  final static String selectsql = "obj.* ";
    public final static String joinsql = "";


    public final static String wheresql = "<where> and obj.del_status=1 " +
                                                            "<if test=\"id != null and id != ''\">"+ "and obj.id = #{id} " + "</if>" +
                                                            "<if test=\"name != null and name != ''\">"+ "and obj.name = #{name} " + "</if>" +
                                                            "<if test=\"mainPic != null and mainPic != ''\">"+ "and obj.main_pic = #{mainPic} " + "</if>" +
                                                            "<if test=\"phone != null and phone != ''\">"+ "and obj.phone = #{phone} " + "</if>" +
                                                            "<if test=\"qqNumber != null and qqNumber != ''\">"+ "and obj.qq_number = #{qqNumber} " + "</if>" +
                                                            "<if test=\"aboutUs != null and aboutUs != ''\">"+ "and obj.about_us = #{aboutUs} " + "</if>" +
                                                            "<if test=\"delStatus != null and delStatus != ''\">"+ "and obj.del_status = #{delStatus} " + "</if>" +
                                                            "</where>";

	@Select("select "+selectsql+" from base_info obj "+joinsql+" where obj.id = #{id}")
	BaseInfoDO get(Integer id);
	
	@Select("<script>" +
	"select "+selectsql+" from base_info obj " + joinsql +
			wheresql +
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by obj.${sort} ${order}" +
	            "</when>" + 
				"<otherwise>" + 
	                "order by obj.id desc" +
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<BaseInfoDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from base_info obj " + joinsql +
			wheresql +
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into base_info (`name`, `main_pic`, `phone`, `qq_number`, `about_us`, `del_status`)"
	+ "values (#{name}, #{mainPic}, #{phone}, #{qqNumber}, #{aboutUs}, #{delStatus})")
	int save(BaseInfoDO baseInfo);
	
	@Update("<script>"+ 
			"update base_info " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" +
					"<if test=\"name != null\">`name` = #{name}, </if>" +
                    "<if test=\"mainPic != null\">`main_pic` = #{mainPic}, </if>" + 
                    "<if test=\"phone != null\">`phone` = #{phone}, </if>" +
                    "<if test=\"qqNumber != null\">`qq_number` = #{qqNumber}, </if>" + 
                    "<if test=\"aboutUs != null\">`about_us` = #{aboutUs}, </if>" + 
                    "<if test=\"commonPassword != null\">`common_password` = #{commonPassword}, </if>" +
          					"</set>" +
					"where id = #{id}"+
			"</script>")
	int update(BaseInfoDO baseInfo);
	
	@Delete("update base_info set del_status=0 where id =#{id}")
	int remove(Integer id);
	
	@Delete("<script>"+ 
			"update base_info set del_status=0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
