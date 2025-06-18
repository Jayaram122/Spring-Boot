package com.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.mvc.model.CoronaVirusModel;
import com.demo.mvc.service.CoronaVirusService;

@Controller
public class CoronaVirusController 
{
	@Autowired
	CoronaVirusService crnService;
	@GetMapping("/")
	public String home(Model model)
	{
		List<CoronaVirusModel> allstates=crnService.getAllstates();
		int totalDeathsReported=allstates.stream().mapToInt(stat->stat.getLatestTotalDeaths()).sum();
		model.addAttribute("LocationStates",allstates);
		model.addAttribute("totalDeathsReported",totalDeathsReported);
		return "index";
	}

}
