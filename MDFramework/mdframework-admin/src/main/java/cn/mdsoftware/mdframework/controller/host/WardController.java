package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.WardDO;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.service.host.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ward")
//病区
public class WardController {

    @Autowired
    WardService wardService;

    @GetMapping("/ward")
    String find(Model model) {
        return "host/ward/ward";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        Query query = new Query(params);
        List<WardDO> wardDOList = wardService.list(query);
        int total = wardService.count(query);
        PageUtils pageUtil = new PageUtils(wardDOList, total);
        return pageUtil;
    }

}
