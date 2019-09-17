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
public class XinxiController {

    @Autowired
    TodayInfoService todayInfoService;
    @Autowired
    TodayBaseInfoService todayBaseInfoService;
    @RequestMapping("information")
    public String all(Model model){
        List<TodayBaseInfoDO> sc=todayBaseInfoService.findAll();
        List<TodayInfoDO> sh=todayInfoService.findAll();
        model.addAttribute("sc",sc);
        model.addAttribute("sh",sh);
        return "information";
    }

    /**
     * 跳转
     */
    @RequestMapping("/tiao")
    public String tiao(){
        return "edit";
    }
    /**
     * 修改
     */
    @RequestMapping("/up")
    public String up(TodayBaseInfoDO htdb, TodayInfoDO htf){
        todayBaseInfoService.up(htdb);
        todayInfoService.up(htf);
        return "redirect:xinxi";
    }
    /**
     * 根据ID查询
     */

    @RequestMapping("/ed")
    public String find(String id,Model m){
        TodayBaseInfoDO hrtodaybaseinfoServiceById=todayBaseInfoService.findById(id);
        TodayInfoDO hrtodayinfoServiceById=todayInfoService.findById(id);
        m.addAttribute("hrtodaybaseinfoServiceById",hrtodaybaseinfoServiceById);
        m.addAttribute("hrtodayinfoServiceById",hrtodayinfoServiceById);
        return "edit";
    }

}
