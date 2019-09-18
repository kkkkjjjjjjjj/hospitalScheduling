package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import cn.mdsoftware.mdframework.service.host.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ward")
public class WardController {

    @Autowired
    WardService wardService;

    @RequestMapping("/ward")
    public String find(Model model){
        List<WardDO> wardDOList=wardService.findAll();
        List<WardDO> wardDOS=wardService.findByXH();
        model.addAttribute("wardDOList",wardDOList);
        model.addAttribute("wardDOS",wardDOS);
        return "Ward";
    }



}
