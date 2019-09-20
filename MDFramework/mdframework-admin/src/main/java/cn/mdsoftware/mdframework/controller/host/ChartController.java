package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.DepartmentDO;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.service.host.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    private DepartmentService departmentService;

    //护理人员信息统计图表
    @RequestMapping("/personnelInformation")
    public String personnelInformation(Model model){
        List<String> wardList = departmentService.wardList();
        model.addAttribute("wardList",wardList);
        List<String> zhichengList = departmentService.zhichengList();
        model.addAttribute("zhichengList",zhichengList);
        return "/host/chart/personnelInformation";
    }

    //统计数据
    @RequestMapping("/statisticalData")
    @ResponseBody
    public PageUtils statisticalData(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Map> personnelInformationList = departmentService.chart(query);
        PageUtils pageUtils = new PageUtils(personnelInformationList, personnelInformationList.size());
        return pageUtils;
    }
}
