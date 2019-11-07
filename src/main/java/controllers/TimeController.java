package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("")
    public String getIndex(){
        return "index";
    }
    @GetMapping("/clock")
    public ModelAndView getTime(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("city",city);
        modelAndView.addObject("date",date);
        return modelAndView;

    }
}
