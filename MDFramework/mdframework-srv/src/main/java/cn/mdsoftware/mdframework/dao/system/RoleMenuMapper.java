package cn.mdsoftware.mdframework.dao.system;

import java.util.List;

import cn.mdsoftware.mdframework.bean.entity.system.RoleMenuDO;
import cn.mdsoftware.mdframework.bean.entity.system.RoleMenuDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.mdsoftware.mdframework.bean.entity.system.RoleMenuDO;

public interface RoleMenuMapper {
	@Insert("INSERT INTO sys_role_menu" + "(id, role_id, menu_id)" + "VALUES(#{id}, #{roleId}, #{menuId})")
	int save(RoleMenuDO rm);
	
	@Insert("<script>" + 
			"INSERT ALL " +
			" <foreach collection=\"list\" item=\"item\" index=\"index\" >  " +
			"INTO sys_role_menu(role_id, menu_id) values (#{item.roleId},#{item.menuId})"+
			" </foreach> " +
			"SELECT 1 FROM DUAL "+
			"</script>")
	int batchSave(List<RoleMenuDO> list);

	@Delete("DELETE FROM  sys_role_menu WHERE id=#{id}")
	int remove(Long id);
	
	@Delete("DELETE FROM  sys_role_menu WHERE role_id=#{roleId}")
	int removeByRoleId(Long roleId);


	@Select("select menu_id from sys_role_menu where role_id = #{roleId}")
	List<Long> listMenuIdByRoleId(Long roleId);
}
