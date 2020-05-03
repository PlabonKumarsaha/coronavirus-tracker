package com.pks.coronavirustracker.controllers;

//controller helps to show the URLS to have UI like use HTML
import com.pks.coronavirustracker.models.LocationStat;
import com.pks.coronavirustracker.service.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    //put things in the model and acess it here and show it in the home.html
    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStat>allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalcases()).sum();
        //mnow this model is accesable in home.html
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);


        return "home";
    }
}
