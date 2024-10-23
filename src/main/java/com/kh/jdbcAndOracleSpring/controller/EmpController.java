package com.kh.jdbcAndOracleSpring.controller;

import com.kh.jdbcAndOracleSpring.dao.EmpDAO;
import com.kh.jdbcAndOracleSpring.vo.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp") // http://localhost:8112/emp
public class EmpController {
    private  final EmpDAO empDAO;

    public EmpController( EmpDAO empDAO){
        this.empDAO = empDAO;
    }
    @GetMapping("/select") // http://localhost:8112/emp/select
    public String selectViewEmp(Model model){
        List<EmpVO> emps = empDAO.empSelect();
        model.addAttribute("employees", emps);
        return "thymeleaf/empSelect";
    }

}
