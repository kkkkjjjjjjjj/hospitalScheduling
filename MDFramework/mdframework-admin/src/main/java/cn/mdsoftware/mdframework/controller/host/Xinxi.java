package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.Hrtodaybaseinfo;
import cn.mdsoftware.mdframework.bean.entity.host.Hrtodayinfo;
import cn.mdsoftware.mdframework.service.host.HrtodaybaseinfoService;
import cn.mdsoftware.mdframework.service.host.HrtodayinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/host/hushi")
@Controller
public class Xinxi {

    @Autowired
    private HrtodayinfoService hti;
    @Autowired
    private HrtodaybaseinfoService hdb;
    @RequiresPermissions("host:hushi:xinxi")
    @GetMapping("")
    String xinxi(Model model){
        return "host/hushi/xinxi";
    }

    @RequiresPermissions("sys:menu:menu")
    @RequestMapping("/list")
    @ResponseBody
   public String all(Model m){
        List<Hrtodayinfo> hrt = hti.findAll();
        List<Hrtodaybaseinfo> htb = hdb.findAll();
        m.addAttribute("hrt",hrt);
        m.addAttribute("htb",htb);
        return "menus";
    }




}
