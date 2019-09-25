package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import cn.mdsoftware.mdframework.common.annotation.Log;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.common.utils.R;
import cn.mdsoftware.mdframework.service.host.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ward")
//病区
public class WardController {

    @Autowired
    WardService wardService;

    @GetMapping("/ward")
    String find(Model model) {
        return "host/ward/ward";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<WardDO> wardDOList = wardService.list(query);
        int total = wardService.count(query);
        PageUtils pageUtil = new PageUtils(wardDOList, total);
        return pageUtil;
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{userName}")
    String edit(Model model, @PathVariable("userName") String userName) {
        WardDO userDO = wardService.findById(userName);
        model.addAttribute("menu",userDO);
        return "host/ward/edit";
    }

    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    R update(WardDO ward) {
        int i = wardService.update(ward);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }
    @Log("删除用户")
    @RequestMapping("/del")
    @ResponseBody
    R del(WardDO wardDO){
        int i = wardService.del(wardDO.getUserName());
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/add")
    String add(){
        return "host/ward/add";
    }


    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // Query query = new Query(params);
        return !wardService.exit(params);// 存在，不通过，false
    }

    @Log("保存用户")
    @PostMapping("/save")
    @ResponseBody
    R save(WardDO wardDO) {
        if (wardService.save(wardDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

}
