package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.PaibanDicthlbDO;
import cn.mdsoftware.mdframework.service.host.PaiBanDicthlbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/zidian")
public class zidianController {
    @Autowired
    PaiBanDicthlbService paiBanDicthlbService;
    @RequestMapping("zidian")
    public String All(Model m){
        List<PaibanDicthlbDO> sm=paiBanDicthlbService.findAll();
        m.addAttribute("sm",sm);
        return "zidian";
    }

    @RequestMapping("/a")
    public String a(){
        return "add";
    }

    @RequestMapping("/add")
    public String add(PaibanDicthlbDO htdb){
        paiBanDicthlbService.add(htdb);
        return "redirect:zidian";
    }
    @RequestMapping("/del")
    public String de(PaibanDicthlbDO host){
        paiBanDicthlbService.del(host.getXh());
        return "redirect:zidian";
    }

}

