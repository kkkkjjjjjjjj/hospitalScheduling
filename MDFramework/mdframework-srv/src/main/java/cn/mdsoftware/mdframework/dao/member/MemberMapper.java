package cn.mdsoftware.mdframework.dao.member;

import java.util.List;
import java.util.Map;

import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-09-20 11:01:06
 */
@Mapper
public interface MemberMapper {

	@Select("select `id`, `name`, `real_name`, `sex`, `address`, `age`, `constellation`, `emotion`, `profession`, `password`, `email`, `phone`, `create_time`, `status` from tb_member where id = #{id}")
    MemberDO get(Integer id);
	
	@Select("<script>" +
	"select * from tb_member " + 
			"<where>" + "status = 1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"realName != null and realName != ''\">"+ "and real_name = #{realName} " + "</if>" + 
		  		  "<if test=\"sex != null and sex != ''\">"+ "and sex = #{sex} " + "</if>" + 
		  		  "<if test=\"address != null and address != ''\">"+ "and address = #{address} " + "</if>" + 
		  		  "<if test=\"age != null and age != ''\">"+ "and age = #{age} " + "</if>" + 
		  		  "<if test=\"constellation != null and constellation != ''\">"+ "and constellation = #{constellation} " + "</if>" + 
		  		  "<if test=\"emotion != null and emotion != ''\">"+ "and emotion = #{emotion} " + "</if>" + 
		  		  "<if test=\"profession != null and profession != ''\">"+ "and profession = #{profession} " + "</if>" + 
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" + 
		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" + 
		  		  "<if test=\"phone != null and phone != ''\">"+ "and phone = #{phone} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by id asc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<MemberDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from tb_member " + 
			"<where>" + "status = 1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"realName != null and realName != ''\">"+ "and real_name = #{realName} " + "</if>" + 
		  		  "<if test=\"sex != null and sex != ''\">"+ "and sex = #{sex} " + "</if>" + 
		  		  "<if test=\"address != null and address != ''\">"+ "and address = #{address} " + "</if>" + 
		  		  "<if test=\"age != null and age != ''\">"+ "and age = #{age} " + "</if>" + 
		  		  "<if test=\"constellation != null and constellation != ''\">"+ "and constellation = #{constellation} " + "</if>" + 
		  		  "<if test=\"emotion != null and emotion != ''\">"+ "and emotion = #{emotion} " + "</if>" + 
		  		  "<if test=\"profession != null and profession != ''\">"+ "and profession = #{profession} " + "</if>" + 
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" + 
		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" + 
		  		  "<if test=\"phone != null and phone != ''\">"+ "and phone = #{phone} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into tb_member (`name`, `real_name`, `sex`, `address`, `age`, `constellation`, `emotion`, `profession`, `password`, `email`, `phone`, `create_time`, `status`)"
	+ "values (#{name}, #{realName}, #{sex}, #{address}, #{age}, #{constellation}, #{emotion}, #{profession}, #{password}, #{email}, #{phone}, #{createTime}, #{status})")
	int save(MemberDO member);
	
	@Update("<script>"+ 
			"update tb_member " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"realName != null\">`real_name` = #{realName}, </if>" + 
                    "<if test=\"sex != null\">`sex` = #{sex}, </if>" + 
                    "<if test=\"address != null\">`address` = #{address}, </if>" + 
                    "<if test=\"age != null\">`age` = #{age}, </if>" + 
                    "<if test=\"constellation != null\">`constellation` = #{constellation}, </if>" + 
                    "<if test=\"emotion != null\">`emotion` = #{emotion}, </if>" + 
                    "<if test=\"profession != null\">`profession` = #{profession}, </if>" + 
                    "<if test=\"password != null\">`password` = #{password}, </if>" + 
                    "<if test=\"email != null\">`email` = #{email}, </if>" + 
                    "<if test=\"phone != null\">`phone` = #{phone}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"status != null\">`status` = #{status}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(MemberDO member);
	
	@Delete("update tb_member t set t.status=0 where id=#{id}")
	int remove(Integer id);
	
	@Delete("<script>"+ 
			"update tb_member t set t.status=0 where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
