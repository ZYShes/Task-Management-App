package com.itlaoqi.thymeleaf.controller;

import com.itlaoqi.thymeleaf.entity.Dept;
import com.itlaoqi.thymeleaf.entity.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {
    Logger logger = LoggerFactory.getLogger(ThymeleafController.class);
    private List<Emp> emps = new ArrayList<Emp>();
    private List<Dept> depts = new ArrayList<Dept>();

    public ThymeleafController() {
        emps.add(new Emp(7782, "CLARK", "MANAGER", 7839, "1981-06-09", 2450.00, null, 10, "ACCOUNTING"));
        emps.add(new Emp(7839, "KING", "PRESIDENT", null, "1981-11-17", 5000.00, null, 10, "ACCOUNTING"));
        emps.add(new Emp(7934, "MILLER", "CLERK", 7782, "1982-01-23", 1300.00, null, 10, "ACCOUNTING"));
        emps.add(new Emp(7369, "SMITH", "CLERK", 7902, "1980-12-17", 800.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7566, "JONES", "MANAGER", 7839, "1981-04-02", 2975.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7788, "SCOTT", "ANALYST", 7566, "1987-07-13", 3000.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7876, "ADAMS", "CLERK", 7788, "1987-07-13", 1100.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7902, "FORD", "ANALYST", 7566, "1981-12-03", 3000.00, null, 20, "RESEARCH"));
        emps.add(new Emp(7499, "ALLEN", "SALESMAN", 7698, "1981-02-20", 1600.00, 300.00f, 30, "SALES"));
        emps.add(new Emp(7521, "WARD", "SALESMAN", 7698, "1981-02-22", 1250.00, 500.00f, 30, "SALES"));
        emps.add(new Emp(7654, "MARTIN", "SALESMAN", 7698, "1981-09-28", 1250.00, 1400.00f, 30, "SALES"));
        emps.add(new Emp(7698, "BLAKE", "MANAGER", 7839, "1981-05-01", 2850.00, null, 30, "SALES"));
        emps.add(new Emp(7844, "TURNER", "SALESMAN", 7698, "1981-09-08", 1500.00, 0.00f, 30, "SALES"));
        emps.add(new Emp(7900, "JAMES", "CLERK", 7698, "1981-12-03", 950.00, null, 30, "SALES"));
        depts.add(new Dept(10,"ACCOUNTING" , "NEW YORK"));
        depts.add(new Dept(20,"RESEARCH" , "DALLAS"));
        depts.add(new Dept(30,"SALES" , "CHICAGO"));
        depts.add(new Dept(40,"OPERATIONS" , "BOSTON"));

    }
    @RequestMapping("/")
    public ModelAndView index(String keyword) {
        ModelAndView mav = new ModelAndView("index");
        List filter = new ArrayList();
        //没有keyword关键字时，查询全部
        if(keyword == null || keyword.trim().equals("")){
            filter = emps;
        }else{
            for(Emp emp : emps){
                if(emp.getEname().toLowerCase().indexOf(keyword.toLowerCase()) != -1){
                    filter.add(emp);
                }
            }
        }
        mav.addObject("emps" , filter);
        return mav;
    }
}
