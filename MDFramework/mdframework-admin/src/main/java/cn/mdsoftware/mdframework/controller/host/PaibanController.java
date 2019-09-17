package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.Day;
import cn.mdsoftware.mdframework.bean.entity.host.Hrtodaybaseinfo;
import cn.mdsoftware.mdframework.service.host.HrtodaybaseinfoService;
import cn.mdsoftware.mdframework.service.host.HrtodayinfoService;
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
    HrtodayinfoService hti;
    @Autowired
    HrtodaybaseinfoService hdb;

    @RequestMapping("paiban")
    public String find(Model m) {
        List<Hrtodaybaseinfo> sm = hdb.findAll();
        m.addAttribute("sm", sm);
        return "paiban";
    }

    @RequestMapping("/add")
    public String add(Hrtodaybaseinfo htdb) {
        hdb.add(htdb);
        return "redirect:TestA";
    }

    @RequestMapping("/aaa")
    public void Date(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Calendar c = Calendar.getInstance();
        Day bbBean = new Day();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        int week = c.get(Calendar.WEEK_OF_MONTH) + 1;


        bbBean.setMonth(month);
        bbBean.setDay(date);
        bbBean.setWeek(week);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(bbBean);
        response.getWriter().print(jsonStr);

    }


}
