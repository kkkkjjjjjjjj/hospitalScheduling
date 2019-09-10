package cn.mdsoftware.mdframework.dao.member;

import java.util.List;
import java.util.Map;

import cn.mdsoftware.mdframework.bean.entity.member.PhotoDO;
import cn.mdsoftware.mdframework.bean.entity.member.PhotoDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mdsoftware.mdframework.bean.entity.member.PhotoDO;
/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-10-15 22:58:22
 */
@Mapper
public interface PhotoMapper {

	@Select("select `id`, `member_id`, `photo_url`, `is_head`, `is_show`, `create_time` from tb_photo where id = #{id}")
    PhotoDO get(Integer id);
	
	@Select("<script>" +
	"select * from tb_photo " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"memberId != null and memberId != ''\">"+ "and member_id = #{memberId} " + "</if>" + 
		  		  "<if test=\"photoUrl != null and photoUrl != ''\">"+ "and photo_url = #{photoUrl} " + "</if>" + 
		  		  "<if test=\"isHead != null and isHead != ''\">"+ "and is_head = #{isHead} " + "</if>" + 
		  		  "<if test=\"isShow != null and isShow != ''\">"+ "and is_show = #{isShow} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
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
	List<PhotoDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from tb_photo " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"memberId != null and memberId != ''\">"+ "and member_id = #{memberId} " + "</if>" + 
		  		  "<if test=\"photoUrl != null and photoUrl != ''\">"+ "and photo_url = #{photoUrl} " + "</if>" + 
		  		  "<if test=\"isHead != null and isHead != ''\">"+ "and is_head = #{isHead} " + "</if>" + 
		  		  "<if test=\"isShow != null and isShow != ''\">"+ "and is_show = #{isShow} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into tb_photo (`member_id`, `photo_url`, `is_head`, `is_show`, `create_time`)"
	+ "values (#{memberId}, #{photoUrl}, #{isHead}, #{isShow}, #{createTime})")
	int save(PhotoDO photo);
	
	@Update("<script>"+ 
			"update tb_photo " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"memberId != null\">`member_id` = #{memberId}, </if>" + 
                    "<if test=\"photoUrl != null\">`photo_url` = #{photoUrl}, </if>" + 
                    "<if test=\"isHead != null\">`is_head` = #{isHead}, </if>" + 
                    "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(PhotoDO photo);
	
	@Delete("delete from tb_photo where id =#{id}")
	int remove(Integer id);
	
	@Delete("<script>"+ 
			"delete from tb_photo where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
