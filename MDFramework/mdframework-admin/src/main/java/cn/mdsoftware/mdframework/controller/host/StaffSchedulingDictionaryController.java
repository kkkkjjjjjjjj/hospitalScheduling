package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.service.host.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/Jump")
    public String a(){
        return "add";
    }

    @RequestMapping("/add")
    public String add(SchedulingDO schedulingDO){
        schedulingService.add(schedulingDO);
        return "redirect:host/dictionary/StaffSchedulingDictionary";
    }
    @RequestMapping("/del")
    public String de(SchedulingDO host){
        schedulingService.del(host.getXh());
        return "redirect:host/dictionary/StaffSchedulingDictionary";
    }


}
