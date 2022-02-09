package com.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
	
	@RequestMapping("/data")
	public ModelAndView getdata(Model model) {
		ModelAndView model =new ModelAndView();
		model.setViewName("movieList");
		return model;
	}
	@Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/hi")
    public String information(){
        return "Welcome Home!!!";
    }

    @GetMapping("/datafromdb")
    public String informationfromDB(){

        String countryName = jdbcTemplate.queryForObject("Select name from countries where id =2",String.class);
        return countryName;

    }
    @GetMapping("/updateindb")
    public String updateInformation(){
         jdbcTemplate.update("Update countries set name = 'malaysia' where id = 1 ");

        return "updated";

    }

    @GetMapping("/datafromdb2")
    public String informationfromDB2(){
        String countryName = jdbcTemplate.queryForObject("Select name from countries where id = ? ",new Object[]{1} , String.class);
        return countryName;

    }

    @GetMapping("/datafromdb3")
    public String listInformation(){
        List<Map<String, Object>> countryName = jdbcTemplate.queryForList("Select name from countries");

        System.out.println(countryName.get(0).get("NAME"));

        return countryName.get(0).get("NAME").toString();

    }
}
