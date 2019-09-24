package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.service.host.TodayBaseInfoService;
import cn.mdsoftware.mdframework.service.host.TodayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/edit")
    public String up(TodayInfoDO todayInfoDO){
        todayInfoService.up(todayInfoDO);
        return "redirect:host/nurseinfo/BasicInformation";
    }
    /**
     * 根据ID查询
     */

    @RequestMapping("/ed")
    public String find(String id,Model model){
       // TodayBaseInfoDO todayBaseInfoDO=todayBaseInfoService.findById(id);
        TodayInfoDO todayInfoDO=todayInfoService.findById(id);
        //m.addAttribute("todayBaseInfoDO",todayBaseInfoDO);
        model.addAttribute("todayInfoDO",todayInfoDO);
        return "host/nurseinfo/edit";
    }
}
