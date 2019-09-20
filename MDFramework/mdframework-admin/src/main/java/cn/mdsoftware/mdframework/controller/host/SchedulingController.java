package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.Day;
import cn.mdsoftware.mdframework.bean.entity.host.SchedulingDO;
import cn.mdsoftware.mdframework.service.host.SchedulingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
@Controller
@RequestMapping("/schedul")
//排班
public class SchedulingController {
    @Autowired
    SchedulingService schedulingService;

    //查询所有
    @RequestMapping("/schedul")
    public String find(Model m){
        List<SchedulingDO> schedulingDOS=schedulingService.findAll();
        m.addAttribute("schedulingDOS",schedulingDOS);
        return "host/scheduling/scheduling";
    }
    //添加
    @RequestMapping("/add")
    public String add(SchedulingDO schedulingDO){
        schedulingService.add(schedulingDO);
        return "redirect:host/scheduling/Scheduling";
    }

    //计算周时间
    @RequestMapping("/weekTime")
    public void Date(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Day day=new Day();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        int week = c.get(Calendar.WEEK_OF_MONTH) + 1;


        day.setMonth(month);
        day.setDay(date);
        day.setWeek(week);
        ObjectMapper objectMapper =new ObjectMapper();
        String jsonStr=objectMapper.writeValueAsString(day);
        response.getWriter().print(jsonStr);

    }


}
