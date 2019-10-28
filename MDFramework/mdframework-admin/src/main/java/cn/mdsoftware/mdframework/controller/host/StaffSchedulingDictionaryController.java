package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.bean.entity.host.SchedulingInformationDO;
import cn.mdsoftware.mdframework.common.annotation.Log;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.common.utils.R;
import cn.mdsoftware.mdframework.service.host.SchedulingInformationService;
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
    @Autowired
    SchedulingInformationService schedulingInformationService;
    @GetMapping("/Dictionary")
    String find(Model model) {
        List<SchedulingInformationDO>schedulingInformationDos=schedulingService.listiInfo();
        model.addAttribute("schedulingInformationDos",schedulingInformationDos);
        return "host/dictionary/staffschedulingdictionary";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<SchedulingDO> schedulingDOList = schedulingService.list(query);
        int total = schedulingService.count(query);
        PageUtils pageUtil = new PageUtils(schedulingDOList, total);
        return pageUtil;
    }

    @GetMapping("/listInfo")
    @ResponseBody
    PageUtils listInfo(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<SchedulingInformationDO> schedulingInformationDOS = schedulingInformationService.list(query);
        int total = schedulingInformationService.count(query);
        PageUtils pageUtil = new PageUtils(schedulingInformationDOS, total);
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

    @GetMapping("/addInfo/{jc}")
    String addinfo(Model model, @PathVariable("jc") String jc){
        SchedulingDO schedulingDO=schedulingService.findByJx(jc);
        model.addAttribute("schedulingDO",schedulingDO);
        List<SchedulingInformationDO>schedulingInformationDos=schedulingInformationService.listName();
        model.addAttribute("schedulingInformationDos",schedulingInformationDos);
        return "host/dictionary/addinfo";
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
        Integer i = schedulingService.del(schedulingDO.getJc());
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }
    @Log("删除用户")
    @RequestMapping("/delInfo")
    @ResponseBody
    R delInfo(@RequestParam Map<String, Object> params){
        Integer i = schedulingInformationService.del(params);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }


    @Log("保存用户")
    @PostMapping("/saveinfo")
    @ResponseBody
    R saveInfo(SchedulingInformationDO schedulingInformationDO) {
        if (schedulingInformationService.save(schedulingInformationDO) > 0) {
            return R.ok();
        }
        return R.error();
    }



}
