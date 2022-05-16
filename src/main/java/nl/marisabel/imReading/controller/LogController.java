package nl.marisabel.imReading.controller;

import nl.marisabel.imReading.dto.LogDto;
import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.entities.LogEntity;
import nl.marisabel.imReading.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/imreading")
public class LogController {

    @Autowired
    LogsService logsService;

    @ModelAttribute("logEntity")
    public LogEntity logForm() {
        return new LogEntity();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

    @RequestMapping("/index")
    String index(Model model) {
        return "index";
    }

    @PostMapping("/new-log")
    String post(Model model,  @ModelAttribute("log") LogEntity log) {
        List<LogEntity> list = logsService.getLogs();
        model.addAttribute("logs", list);
        return "temp";
    }

    @GetMapping("/log")
    String log(Model model, @ModelAttribute("log") LogEntity log) {
        List<String> books = Arrays.asList("Harry Potter", "Touch", "My life");
        model.addAttribute("booksList", books);
        System.out.println("TEST:" + log);
        logsService.saveOrUpdate(log);
        return "new-log";
    }



}
