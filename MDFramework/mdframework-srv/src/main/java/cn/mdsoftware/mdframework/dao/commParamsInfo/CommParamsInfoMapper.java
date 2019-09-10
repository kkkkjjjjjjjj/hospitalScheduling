package cn.mdsoftware.mdframework.dao.commParamsInfo;

import cn.mdsoftware.mdframework.bean.entity.commParamsInfo.CommParamsInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2018-01-24 11:20:01
 */
@Mapper
public interface CommParamsInfoMapper {

	@Select("select `id`, `type_name`, `unique_type`, `key_name`, `key_value`, `order_by`, `create_time`, `del_status` from comm_params_info where id = #{id}")
	CommParamsInfoDO get(Integer id);


	@Select({"select `key_name`as 'name', `key_value` as 'value' from comm_params_info where unique_type = #{uniqueType} order by order_by asc"})
	List<Map<String,Object>> listByUnique(Map<String, Object> map);

	@Select({"select `key_name`as 'value', `key_value` as 'key' from comm_params_info where unique_type = #{uniqueType} order by order_by asc"})
	List<Map<String,Object>> listByUniqueApi(Map<String, Object> map);

	@Select({"select `key_name`as 'name', `key_value` as 'value' from comm_params_info where unique_type in (#{uniqueType} order by order_by asc"})
	List<Map<String,Object>> listByUniqueIn(Map<String, Object> map);

	@Select("<script>" +
	"select * from comm_params_info " + 
			"<where> and del_status=1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"typeName != null and typeName != ''\">"+ "and type_name = #{typeName} " + "</if>" + 
		  		  "<if test=\"uniqueType != null and uniqueType != ''\">"+ "and unique_type = #{uniqueType} " + "</if>" + 
		  		  "<if test=\"keyName != null and keyName != ''\">"+ "and key_name = #{keyName} " + "</if>" + 
		  		  "<if test=\"keyValue != null and keyValue != ''\">"+ "and key_value = #{keyValue} " + "</if>" + 
		  		  "<if test=\"orderBy != null and orderBy != ''\">"+ "and order_by = #{orderBy} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"delStatus != null and delStatus != ''\">"+ "and del_status = #{delStatus} " + "</if>" + 
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
	List<CommParamsInfoDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from comm_params_info " + 
			"<where> and del_status=1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"typeName != null and typeName != ''\">"+ "and type_name = #{typeName} " + "</if>" + 
		  		  "<if test=\"uniqueType != null and uniqueType != ''\">"+ "and unique_type = #{uniqueType} " + "</if>" + 
		  		  "<if test=\"keyName != null and keyName != ''\">"+ "and key_name = #{keyName} " + "</if>" + 
		  		  "<if test=\"keyValue != null and keyValue != ''\">"+ "and key_value = #{keyValue} " + "</if>" + 
		  		  "<if test=\"orderBy != null and orderBy != ''\">"+ "and order_by = #{orderBy} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"delStatus != null and delStatus != ''\">"+ "and del_status = #{delStatus} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into comm_params_info (`type_name`, `unique_type`, `key_name`, `key_value`, `order_by`, `create_time`, `del_status`)"
	+ "values (#{typeName}, #{uniqueType}, #{keyName}, #{keyValue}, #{orderBy}, #{createTime}, #{delStatus})")
	int save(CommParamsInfoDO commParamsInfo);
	
	@Update("<script>"+ 
			"update comm_params_info " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"typeName != null\">`type_name` = #{typeName}, </if>" + 
                    "<if test=\"uniqueType != null\">`unique_type` = #{uniqueType}, </if>" + 
                    "<if test=\"keyName != null\">`key_name` = #{keyName}, </if>" + 
                    "<if test=\"keyValue != null\">`key_value` = #{keyValue}, </if>" + 
                    "<if test=\"orderBy != null\">`order_by` = #{orderBy}, </if>" + 
          					"</set>" +
					"where id = #{id}"+
			"</script>")
	int update(CommParamsInfoDO commParamsInfo);
	
	@Delete("update comm_params_info set del_status=0 where id =#{id}")
	int remove(Integer id);
	
	@Delete("<script>"+ 
			"update comm_params_info set del_status=0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
