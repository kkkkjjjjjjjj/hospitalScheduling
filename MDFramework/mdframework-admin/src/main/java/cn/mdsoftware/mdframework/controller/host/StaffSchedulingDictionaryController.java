package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.service.host.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("StaffSchedulingDictionary")
//人员排班字典
public class StaffSchedulingDictionaryController {
    @Autowired
    SchedulingService schedulingService;
    @RequestMapping("/Dictionary")
    public String All(Model m){
        List<SchedulingDO> schedulingDOS=schedulingService.findAll();
        m.addAttribute("schedulingDOS",schedulingDOS);
        return "StaffSchedulingDictionary";
    }

    @RequestMapping("/Jump")
    public String a(){
        return "add";
    }

    @RequestMapping("/add")
    public String add(SchedulingDO schedulingDO){
        schedulingService.add(schedulingDO);
        return "redirect:StaffSchedulingDictionary";
    }
    @RequestMapping("/del")
    public String de(SchedulingDO host){
        schedulingService.del(host.getXh());
        return "redirect:StaffSchedulingDictionary";
    }


}
