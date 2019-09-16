package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.Day;
import cn.mdsoftware.mdframework.bean.entity.host.TodayBaseInfoDO;
import cn.mdsoftware.mdframework.service.host.TodayBaseInfoService;
import cn.mdsoftware.mdframework.service.host.TodayInfoService;
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
public class PaibanController {
    @Autowired
    TodayInfoService todayInfoService;
    @Autowired
    TodayBaseInfoService todayBaseInfoService;
    @RequestMapping("/paiban")
    public String find(Model m){
        List<TodayBaseInfoDO> hrtodaybaseinfoList=todayBaseInfoService.findAll();
        m.addAttribute("hrtodaybaseinfoList",hrtodaybaseinfoList);
        return "paiban";
    }

    @RequestMapping("/add")
    public String add(TodayBaseInfoDO htdb){
        todayBaseInfoService.add(htdb);
        return "redirect:TestA";
    }

    //求一周的时间
    @RequestMapping("/weekTime")
    public void Date(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Calendar c = Calendar.getInstance();
        Day day=new Day();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int month = c.get(Calendar.MONTH)+1;
        int date = c.get(Calendar.DATE);
        int week=c.get(Calendar.WEEK_OF_MONTH)+1;


        day.setMonth(month);
        day.setDay(date);
        day.setWeek(week);
        ObjectMapper objectMapper =new ObjectMapper();
        String jsonStr=objectMapper.writeValueAsString(day);
        response.getWriter().print(jsonStr);

    }


}
