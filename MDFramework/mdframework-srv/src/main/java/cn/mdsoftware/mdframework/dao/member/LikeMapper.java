package cn.mdsoftware.mdframework.dao.member;

import java.util.List;
import java.util.Map;

import cn.mdsoftware.mdframework.bean.entity.member.LikeDO;
import cn.mdsoftware.mdframework.bean.entity.member.LikeDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mdsoftware.mdframework.bean.entity.member.LikeDO;
/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-10-19 00:35:55
 */
@Mapper
public interface LikeMapper {

	@Select("select `id`, `member_id`, `create_time`, `product_id`, `news_id` from tb_like where id = #{id}")
    LikeDO get(Integer id);
	
	@Select("<script>" +
	"select * from tb_like " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"memberId != null and memberId != ''\">"+ "and member_id = #{memberId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
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
	List<LikeDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from tb_like " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"memberId != null and memberId != ''\">"+ "and member_id = #{memberId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"productId != null and productId != ''\">"+ "and product_id = #{productId} " + "</if>" + 
		  		  "<if test=\"newsId != null and newsId != ''\">"+ "and news_id = #{newsId} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into tb_like (`id`, `member_id`, `create_time`, `product_id`, `news_id`)"
	+ "values (#{id}, #{memberId}, #{createTime}, #{productId}, #{newsId})")
	int save(LikeDO like);
	
	@Update("<script>"+ 
			"update tb_like " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"memberId != null\">`member_id` = #{memberId}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"productId != null\">`product_id` = #{productId}, </if>" + 
                    "<if test=\"newsId != null\">`news_id` = #{newsId}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(LikeDO like);
	
	@Delete("delete from tb_like where id =#{id}")
	int remove(Integer id);
	
	@Delete("<script>"+ 
			"delete from tb_like where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
