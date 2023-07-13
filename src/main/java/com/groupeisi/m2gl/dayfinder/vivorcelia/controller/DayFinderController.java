package com.groupeisi.m2gl.dayfinder.vivorcelia.controller;


import com.groupeisi.m2gl.dayfinder.vivorcelia.model.DayResponse;
import com.groupeisi.m2gl.dayfinder.vivorcelia.model.SearchItem;
import com.groupeisi.m2gl.dayfinder.vivorcelia.service.DayFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dayfinder")
public class DayFinderController {

    @Autowired
    private DayFinderService dayFinderService;

    @PostMapping
    public DayResponse findDayOfWeek(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        DayResponse response = new DayResponse();
        response.setDate(formatDate(date));
        response.setDayOfWeek(dayFinderService.getDayOfWeek(date));
        dayFinderService.saveSearchItem(formatDate(date), response);
        return response;
    }

    @GetMapping("/historique")
    public List<SearchItem> getHistorique() {
        return dayFinderService.getHistorique();
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
