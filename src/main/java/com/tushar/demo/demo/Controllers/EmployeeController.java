package com.tushar.demo.demo.Controllers;

import com.tushar.demo.demo.DTO.employeeDTO;
import com.tushar.demo.demo.Entities.EmployeeEntity;
import com.tushar.demo.demo.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees/{id}")
    public employeeDTO getEmployees(@PathVariable("id") Long EmpId){
        return employeeService.getEmployeeById(EmpId);
    }


    @PostMapping(path = "/employees")
    public employeeDTO getData(@RequestBody employeeDTO employeeDTO){
        return employeeService.creatNewEmployee(employeeDTO);
    }

    @GetMapping(path="/employees")
    public List<employeeDTO> getAllEmployees(){
        return employeeService.getAllEmp();
    }

    @DeleteMapping(path = "/employees/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long EmpId){
        return employeeService.DelById(EmpId);
    }


}
