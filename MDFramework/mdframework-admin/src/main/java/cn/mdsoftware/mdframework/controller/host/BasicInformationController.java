package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;
import cn.mdsoftware.mdframework.bean.entity.host.TodayInfoDO;
import cn.mdsoftware.mdframework.service.host.TodayBaseInfoService;
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
    @Autowired
    TodayBaseInfoService todayBaseInfoService;
    @RequestMapping("/information")
    public String all(Model model){
        List<TodayBaseInfoDO> todayBaseInfoDOList=todayBaseInfoService.findAll();
        List<TodayInfoDO> todayInfoDOList=todayInfoService.findAll();
        model.addAttribute("todayBaseInfoDOList",todayBaseInfoDOList);
        model.addAttribute("todayInfoDOList",todayInfoDOList);
        return "BasicInformation";
    }

    /**
     * 跳转
     */
    @RequestMapping("/Jump")
    public String tiao(){
        return "edit";
    }
    /**
     * 修改
     */
    @RequestMapping("/edit")
    public String up(TodayBaseInfoDO todayBaseInfoDO, TodayInfoDO todayInfoDO){
        todayBaseInfoService.up(todayBaseInfoDO);
        todayInfoService.up(todayInfoDO);
        return "redirect:BasicInformation";
    }
    /**
     * 根据ID查询
     */

    @RequestMapping("/ed")
    public String find(String id,Model m){
        TodayBaseInfoDO todayBaseInfoDO=todayBaseInfoService.findById(id);
        TodayInfoDO todayInfoDO=todayInfoService.findById(id);
        m.addAttribute("hrtodaybaseinfoServiceById",todayBaseInfoDO);
        m.addAttribute("hrtodayinfoServiceById",todayBaseInfoDO);
        return "edit";
    }
}
