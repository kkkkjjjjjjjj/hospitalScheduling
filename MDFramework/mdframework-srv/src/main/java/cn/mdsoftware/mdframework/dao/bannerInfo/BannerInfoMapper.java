package cn.mdsoftware.mdframework.dao.bannerInfo;

import cn.mdsoftware.mdframework.bean.entity.bannerInfo.BannerInfoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;
/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2018-07-27 16:39:48
 */
@Mapper
public interface BannerInfoMapper {

    public  final static String selectsql = "obj.* ";
    public final static String joinsql = "";


    public final static String wheresql = "<where> and obj.del_status=1 " +
                                                            "<if test=\"id != null and id != ''\">"+ "and obj.id = #{id} " + "</if>" +
                                                            "<if test=\"userId != null and userId != ''\">"+ "and obj.user_id = #{userId} " + "</if>" +
                                                            "<if test=\"title != null and title != ''\">"+ "and obj.title = #{title} " + "</if>" +
                                                            "<if test=\"mainPic != null and mainPic != ''\">"+ "and obj.main_pic = #{mainPic} " + "</if>" +
                                                            "<if test=\"linkUrl != null and linkUrl != ''\">"+ "and obj.link_url = #{linkUrl} " + "</if>" +
                                                            "<if test=\"orderBy != null and orderBy != ''\">"+ "and obj.order_by = #{orderBy} " + "</if>" +
                                                            "<if test=\"startTime != null and startTime != ''\">"+ "and obj.start_time = #{startTime} " + "</if>" +
                                                            "<if test=\"endTime != null and endTime != ''\">"+ "and obj.end_time = #{endTime} " + "</if>" +
                                                            "<if test=\"status != null and status != ''\">"+ "and obj.status = #{status} " + "</if>" +
                                                            "<if test=\"createTime != null and createTime != ''\">"+ "and obj.create_time = #{createTime} " + "</if>" +
                                                            "<if test=\"delStatus != null and delStatus != ''\">"+ "and obj.del_status = #{delStatus} " + "</if>" +
                                                            "</where>";

	@Select("select "+selectsql+" from banner_info obj "+joinsql+" where obj.id = #{id}")
	BannerInfoDO get(Integer id);
	
	@Select("<script>" +
	"select "+selectsql+" from banner_info obj " + joinsql +
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
	List<BannerInfoDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from banner_info obj " + joinsql +
			wheresql +
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into banner_info ( user_id ,  title ,  main_pic ,  link_url ,  order_by ,  start_time ,  end_time ,  status ,  create_time ,  del_status )"
	+ "values (#{userId,jdbcType=NUMERIC}, #{title}, #{mainPic}, #{linkUrl}, #{orderBy}, to_date(#{startTime},'yyyy-mm-dd'), to_date(#{endTime},'yyyy-mm-dd'), #{status}, to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss'), #{delStatus})")
	int save(BannerInfoDO bannerInfo);
	
	@Update("<script>"+ 
			"update banner_info " + 
					"<set>" + 
		            "<if test=\"id != null\"> id  = #{id}, </if>" + 
                    "<if test=\"userId != null\"> user_id  = #{userId}, </if>" + 
                    "<if test=\"title != null\"> title  = #{title}, </if>" + 
                    "<if test=\"mainPic != null\"> main_pic  = #{mainPic}, </if>" + 
                    "<if test=\"linkUrl != null\"> link_url  = #{linkUrl}, </if>" + 
                    "<if test=\"orderBy != null\"> order_by  = #{orderBy}, </if>" + 
                    "<if test=\"startTime != null\"> start_time  = #{startTime}, </if>" + 
                    "<if test=\"endTime != null\"> end_time  = #{endTime}, </if>" + 
                    "<if test=\"status != null\"> status  = #{status}, </if>" + 
                    "<if test=\"createTime != null\"> create_time  = #{createTime}, </if>" + 
                    "<if test=\"delStatus != null\"> del_status  = #{delStatus}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(BannerInfoDO bannerInfo);
	
	@Delete("update banner_info set del_status=0 where id =#{id}")
	int remove(Integer id);
	
	@Delete("<script>"+ 
			"update banner_info set del_status=0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
