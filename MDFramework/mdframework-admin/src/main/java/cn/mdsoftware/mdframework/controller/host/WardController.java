package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import cn.mdsoftware.mdframework.service.host.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ward")

//病区
public class WardController {

    @Autowired
    WardService wardService;

    @RequestMapping("/ward")
    public String find(Model model){
        return "host/ward/ward";
    }

    @GetMapping("/list")
    @ResponseBody
    List<WardDO> list() {
        List<WardDO> wardDOList=wardService.findAll();
        return wardDOList;
    }







}
