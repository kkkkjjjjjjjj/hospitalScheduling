package cn.mdsoftware.mdframework.controller.host;

import cn.mdsoftware.mdframework.bean.entity.host.*;
import cn.mdsoftware.mdframework.common.annotation.Log;
import cn.mdsoftware.mdframework.common.utils.PageUtils;
import cn.mdsoftware.mdframework.common.utils.Query;
import cn.mdsoftware.mdframework.common.utils.R;
import cn.mdsoftware.mdframework.service.host.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/schedul")
//排班
public class SchedulingController {
    @Autowired
    SchedulingInformationService schedulingInformationService;
    @Autowired
    ListenService listenService;
    @Autowired
    SchedulingService schedulingService;
    @Autowired
    WardService wardService;
    @Autowired
    SchedulService schedulService;
    //查询所有
    @GetMapping("/schedul")
    String find(Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if(dayWeek==1){
            dayWeek = 8;
        }
        System.out.println("要   计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        String monday = sdf.format(mondayDate);
        System.out.println("所在周星期一的日期：" + monday);
        model.addAttribute("monday","2018-03-28");
        List<WardDO> wardDOList=wardService.listWard();
        model.addAttribute("wardDOList",wardDOList);
        return "host/scheduling/scheduling";
    }


    @GetMapping("/list")
    @ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) throws Exception{
        // 查询列表数据
        Query query = new Query(params);
        List<WardDO> wardList = wardService.list(query);
        String monday = params.get("monday").toString();
        //循环查询出的数据
        for (WardDO ward : wardList){
            Map map = new HashMap(){{
                put("wardCode", ward.getWardCode());
                put("id", ward.getUserName());
                put("date", monday);//日期
               put("day", 0);//周几
            }};;
            List<SchedulDO> schedulMon = schedulService.list(map);
            ward.setSchedulMon(schedulMon);

            map.put("day", 1);
            List<SchedulDO> schedulTues = schedulService.list(map);
            ward.setSchedulTues(schedulTues);

            map.put("day", 2);
            List<SchedulDO> schedulWed = schedulService.list(map);
            ward.setSchedulWed(schedulWed);

            map.put("day", 3);
            List<SchedulDO> schedulThu = schedulService.list(map);
            ward.setSchedulThu(schedulThu);

            map.put("day", 4);
            List<SchedulDO> schedulFri = schedulService.list(map);
            ward.setSchedulFri(schedulFri);

            map.put("day", 5);
            List<SchedulDO> schedulSat = schedulService.list(map);
            ward.setSchedulSat(schedulSat);

            map.put("day", 6);
            List<SchedulDO> schedulSun = schedulService.list(map);
            ward.setSchedulSun(schedulSun);
        }

        int total = wardService.count(query);
        PageUtils pageUtil = new PageUtils(wardList, total);
        return pageUtil;
    }


    @GetMapping("/listF")
    @ResponseBody
    PageUtils listF(@RequestParam Map<String, Object> params) throws Exception{
        Query query = new Query(params);
        List<WardDO> wardList = wardService.list(query);
        int total = wardService.count(query);
        PageUtils pageUtil = new PageUtils(wardList, total);
        return pageUtil;
    }

    //添加
    @RequestMapping("/add")
    public String add(Model model){
        List<SchedulingDO> schedulingDOList=schedulingService.listJc();
        model.addAttribute("schedulingDOList",schedulingDOList);
        List<WardDO>wardDOList=wardService.listName();
        model.addAttribute("wardDOList",wardDOList);
        return "host/scheduling/add";
    }


    @GetMapping("/listListen")
    @ResponseBody
    PageUtils listListen(@RequestParam Map<String, Object> params) throws Exception{
        // 查询列表数据
        Query query = new Query(params);
        List<ListenDO> listenDOList = listenService.list(query);
        String monday = params.get("monday").toString();
        for (ListenDO listenDO : listenDOList){
            Map map = new HashMap(){{
                put("wardCode", listenDO.getWardCode());
                put("id", listenDO.getTing());
                put("date", monday);
                put("day", 0);
            }};;
            List<ListenDO> listenMon = listenService.list(map);
            listenDO.setListenMon(listenMon);

            map.put("day", 1);
            List<ListenDO> listenTues = listenService.list(map);
            listenDO.setListenTues(listenTues);

            map.put("day", 2);
            List<ListenDO> listenWed = listenService.list(map);
            listenDO.setListenWed(listenWed);

            map.put("day", 3);
            List<ListenDO> listenlThu = listenService.list(map);
            listenDO.setListenThu(listenlThu);

            map.put("day", 4);
            List<ListenDO> listenFri = listenService.list(map);
            listenDO.setListenFri(listenFri);

            map.put("day", 5);
            List<ListenDO> listenSat = listenService.list(map);
            listenDO.setListenSat(listenSat);

            map.put("day", 6);
            List<ListenDO> listenSun = listenService.list(map);
            listenDO.setListenSun(listenSun);
        }
        int total = listenService.count(query);
        PageUtils pageUtil = new PageUtils(listenDOList, total);
        return pageUtil;
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

    //获取排班
    @RequestMapping("/listJc")
    List<SchedulingDO>findjc(){
        List<SchedulingDO>find=schedulingService.listJc();
        return find;
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{name}")
    String edit(Model model, @PathVariable("name") String name) {
        SchedulDO schedulDO = schedulService.ByName(name);
        model.addAttribute("schedulDO",schedulDO);
        return "host/scheduling/edit";
    }



    @Log("更新用户")
    @PostMapping("/update")
    @ResponseBody
    R update(SchedulDO schedulDO) {
        int i = schedulService.update(schedulDO);
        if (i > 0) {
            return R.ok();
        }
        return R.error();
    }



}
