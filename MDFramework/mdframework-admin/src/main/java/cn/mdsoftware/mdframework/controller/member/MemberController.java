package cn.mdsoftware.mdframework.controller.member;

import cn.mdsoftware.mdframework.bean.entity.member.MemberDO;
import cn.mdsoftware.mdframework.common.annotation.Log;
import cn.mdsoftware.mdframework.common.utils.*;
import cn.mdsoftware.mdframework.service.member.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;




/**
 * 
 * 
 * @author 110
 * @email 110@163.com
 * @date 2017-09-20 11:01:06
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FastDFSClientWrapper dfsClient;
	
	@GetMapping()
	@RequiresPermissions("member:member")
	String Member(){
	    return "member/member";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MemberDO> memberList = memberService.list(query);
		int total = memberService.count(query);
		PageUtils pageUtils = new PageUtils(memberList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("member:add")
	String add(){
	    return "member/add";
	}
	@RequiresPermissions("member:edit")	
	@GetMapping("/edit/{id}")
	//@RequiresPermissions("blog:bComments")
	String edit(Model model, @PathVariable("id") Integer id){
		MemberDO member = memberService.get(id);
		model.addAttribute("member", member);
	    return "member/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("member:info")
	public R info(@PathVariable("id") Integer id){
		MemberDO member = memberService.get(id);
		return R.ok().put("member", member);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	//@RequiresPermissions("member:save")
	//MemberDO member
	public R save(@RequestParam("file") MultipartFile file){
		/*String password = MD5Utils.encrypt(member.getName(), member.getPassword());
		member.setPassword(password);
		if(memberService.save(member)>0){
			return R.ok();
		}*/
		try {
			String filePath = dfsClient.uploadFile(file);
			System.out.println("path--->" + filePath + "----fileName--->" + file.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	@RequiresPermissions("member:edit")
	public R update(MemberDO member){
		if (memberService.update(member) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("member:remove")
	public R remove( Integer id){
		if(memberService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("member:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		memberService.batchRemove(ids);
		
		return R.ok();
	}

	@RequiresPermissions("member:resetPwd")
	@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Integer id, Model model) {
		MemberDO mem = new MemberDO();
		mem.setId(id);
		model.addAttribute("member", mem);
		return "member/reset_pwd";
	}

	@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
	R resetPwd(MemberDO mem) {
		mem.setPassword(MD5Utils.encrypt(memberService.get(mem.getId()).getName(), mem.getPassword()));
		if (memberService.resetPwd(mem) > 0) {
			return R.ok();
		}
		return R.error();
	}
}
