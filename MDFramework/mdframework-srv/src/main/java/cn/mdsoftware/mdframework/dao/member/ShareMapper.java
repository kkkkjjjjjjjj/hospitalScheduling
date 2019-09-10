package cn.mdsoftware.mdframework.dao.member;

import java.util.List;
import java.util.Map;

import cn.mdsoftware.mdframework.bean.entity.member.ShareDO;
import cn.mdsoftware.mdframework.bean.entity.member.ShareDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mdsoftware.mdframework.bean.entity.member.ShareDO;
/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-10-19 00:35:55
 */
@Mapper
public interface ShareMapper {

	@Select("select `id`, `name`, `description`, `member_id`, `create_time`, `visit_url`, `product_id`, `news_id` from tb_share where id = #{id}")
    ShareDO get(Integer id);
	
	@Select("<script>" +
	"select * from tb_share " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"memberId != null and memberId != ''\">"+ "and member_id = #{memberId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"visitUrl != null and visitUrl != ''\">"+ "and visit_url = #{visitUrl} " + "</if>" + 
		  		  "<if test=\"productId != null and productId != ''\">"+ "and product_id = #{productId} " + "</if>" + 
		  		  "<if test=\"newsId != null and newsId != ''\">"+ "and news_id = #{newsId} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<ShareDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from tb_share " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"memberId != null and memberId != ''\">"+ "and member_id = #{memberId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"visitUrl != null and visitUrl != ''\">"+ "and visit_url = #{visitUrl} " + "</if>" + 
		  		  "<if test=\"productId != null and productId != ''\">"+ "and product_id = #{productId} " + "</if>" + 
		  		  "<if test=\"newsId != null and newsId != ''\">"+ "and news_id = #{newsId} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into tb_share (`name`, `description`, `member_id`, `create_time`, `visit_url`, `product_id`, `news_id`)"
	+ "values (#{name}, #{description}, #{memberId}, #{createTime}, #{visitUrl}, #{productId}, #{newsId})")
	int save(ShareDO share);
	
	@Update("<script>"+ 
			"update tb_share " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"description != null\">`description` = #{description}, </if>" + 
                    "<if test=\"memberId != null\">`member_id` = #{memberId}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"visitUrl != null\">`visit_url` = #{visitUrl}, </if>" + 
                    "<if test=\"productId != null\">`product_id` = #{productId}, </if>" + 
                    "<if test=\"newsId != null\">`news_id` = #{newsId}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(ShareDO share);
	
	@Delete("delete from tb_share where id =#{id}")
	int remove(Integer id);
	
	@Delete("<script>"+ 
			"delete from tb_share where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
