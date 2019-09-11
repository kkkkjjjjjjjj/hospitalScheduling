package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodaybaseinfo;
import cn.mdsoftware.mdframework.bean.entity.host.Hrtodayinfo;
import cn.mdsoftware.mdframework.service.host.HrtodaybaseinfoService;
import cn.mdsoftware.mdframework.service.host.HrtodayinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class XinxiController {

    @Autowired
    HrtodayinfoService hti;
    @Autowired
    HrtodaybaseinfoService hdb;
    @RequestMapping("xinxi")
    public String all(Model m){
        List<Hrtodaybaseinfo> sc=hdb.findAll();
        List<Hrtodayinfo> sh=hti.findAll();
        m.addAttribute("sc",sc);
        m.addAttribute("sh",sh);
        return "xinxi";
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
    public String up(Hrtodaybaseinfo htdb, Hrtodayinfo htf){
        hdb.up(htdb);
        hti.up(htf);
        return "redirect:xinxi";
    }
    /**
     * 根据ID查询
     */

    @RequestMapping("/ed")
    public String find(String id,Model m){
        Hrtodaybaseinfo sh=hdb.findById(id);
        Hrtodayinfo sm=hti.findById(id);
        m.addAttribute("sh",sh);
        m.addAttribute("sm",sm);
        return "edit";
    }

}
