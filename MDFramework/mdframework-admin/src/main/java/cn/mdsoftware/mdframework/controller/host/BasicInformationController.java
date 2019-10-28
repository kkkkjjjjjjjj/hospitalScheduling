package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import cn.mdsoftware.mdframework.common.annotation.Log;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.common.utils.R;
import cn.mdsoftware.mdframework.service.host.TodayBaseInfoService;
import cn.mdsoftware.mdframework.service.host.TodayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/BasicInformation")
//人员基本信息
public class BasicInformationController {
    @Autowired
    TodayBaseInfoService todayBaseInfoService;

    @Autowired
    TodayInfoService todayInfoService;
    @RequestMapping("/information")
    public String all(Model model){
//        List<TodayInfoDO> todayInfoDOList=todayInfoService.findAll(null);
//        model.addAttribute("todayInfoDOList",todayInfoDOList);
        return "host/nurseinfo/basicinformation";
    }

    @RequestMapping("/todayInfoList")
    @ResponseBody
    public PageUtils todayInfoList(@RequestParam Map<String, Object> params){
        //查询列表数据
        Query query = new Query(params);
        List<TodayInfoDO> todayInfoDOList= todayInfoService.findAll(query);
        int total = todayInfoService.count(query);
        PageUtils pageUtils = new PageUtils(todayInfoDOList, total);
        return pageUtils;
    }

    /**
     * 修改
     */
    @GetMapping("/edit")
    String edit(Model model, String id) {
        TodayInfoDO todayInfoDO = todayInfoService.findById(id);
//        TodayBaseInfoDO todayBaseInfoDO=todayBaseInfoService.findById(id);
        model.addAttribute("todayInfoDO",todayInfoDO);
//        model.addAttribute("todayBaseInfoDO",todayBaseInfoDO);
        return "host/nurseinfo/edit";
    }

    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    R update(TodayInfoDO todayInfoDO) {
        int i = todayInfoService.up(todayInfoDO);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }
}
