package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodaybaseinfo;
import cn.mdsoftware.mdframework.controller.BaseController;
import cn.mdsoftware.mdframework.service.host.HrtodaybaseinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/host/hushi")
@Controller
public class Xinxi  extends BaseController {
    String prefix = "host/hushi";
    //@Autowired
    //HrtodayinfoService hti;
    @Autowired
    HrtodaybaseinfoService hdb;
    @RequestMapping("xinxi")
    public String all(Model m){
        List<Hrtodaybaseinfo>sc=hdb.findAll();
        m.addAttribute("sc",sc);
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
    public String up(Hrtodaybaseinfo school){
        hdb.up(school);
        return "redirect:xinxi";
    }
    /**
     * 根据ID查询
     */
    @RequestMapping("/ed")
    public String find(String id,Model m){
        Hrtodaybaseinfo sh=hdb.findById(id);
        m.addAttribute("sh",sh);
        return "edit";
    }



}
