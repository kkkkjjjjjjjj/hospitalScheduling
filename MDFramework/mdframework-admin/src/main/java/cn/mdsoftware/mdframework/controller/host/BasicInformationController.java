package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;
import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import cn.mdsoftware.mdframework.service.host.TodayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/BasicInformation")
//人员基本信息
public class BasicInformationController {

    @Autowired
    TodayInfoService todayInfoService;
    @RequestMapping("/information")
    public String all(Model model){
        List<TodayInfoDO> todayInfoDOList=todayInfoService.findAll();
        model.addAttribute("todayInfoDOList",todayInfoDOList);
        return "host/nurseinfo/basicinformation";
    }

    /**
     * 修改
     */
    @RequestMapping("/edit")
    public String up(TodayBaseInfoDO todayBaseInfoDO, TodayInfoDO todayInfoDO){
        todayInfoService.up(todayInfoDO);
        return "redirect:host/nurseinfo/BasicInformation";
    }
    /**
     * 根据ID查询
     */

    @RequestMapping("/ed")
    public String find(String id,Model m){
        TodayInfoDO todayInfoDO=todayInfoService.findById(id);
        m.addAttribute("todayInfoDO",todayInfoDO);
        return "host/nurseinfo/edit";
    }
}
