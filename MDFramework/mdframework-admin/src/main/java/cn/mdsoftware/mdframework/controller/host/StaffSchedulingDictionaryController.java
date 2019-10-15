package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.common.annotation.Log;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.common.utils.R;
import cn.mdsoftware.mdframework.service.host.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/StaffSchedulingDictionary")
//人员排班字典
public class StaffSchedulingDictionaryController {
    @Autowired
    SchedulingService schedulingService;
    @GetMapping("/Dictionary")
    String find(Model model) {
        return "host/dictionary/staffschedulingdictionary";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<SchedulingDO> wardDOList = schedulingService.list(query);
        int total = schedulingService.count(query);
        PageUtils pageUtil = new PageUtils(wardDOList, total);
        return pageUtil;
    }



    @PostMapping("/exit")
    @ResponseBody
    boolean exit(@RequestParam Map<String, Object> params) {
        // Query query = new Query(params);
        return !schedulingService.exit(params);// 存在，不通过，false
    }

    @GetMapping("/add")
    String add(){
        return "host/dictionary/add";
    }


    @Log("保存用户")
    @PostMapping("/save")
    @ResponseBody
    R save(SchedulingDO schedulingDO) {
        if (schedulingService.save(schedulingDO) > 0) {
            return R.ok();
        }
        return R.error();
    }
    @Log("删除用户")
    @RequestMapping("/del")
    @ResponseBody
    R del(SchedulingDO schedulingDO){
        Integer i = schedulingService.del(schedulingDO.getXh());
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }


}
