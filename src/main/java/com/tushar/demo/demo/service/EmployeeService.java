package com.tushar.demo.demo.service;

import com.tushar.demo.demo.DTO.employeeDTO;
import com.tushar.demo.demo.Entities.EmployeeEntity;
import com.tushar.demo.demo.Repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = new ModelMapper();
    }

    public employeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity=employeeRepository.getById(id);
        return new
          employeeDTO(employeeEntity.getId(),employeeEntity.getName(),
                      employeeEntity.getDateOfJoining(),employeeEntity.isActive()   );

    }
    public employeeDTO creatNewEmployee(employeeDTO employeeDTO) {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity),employeeDTO.class);
    }

    public List<employeeDTO> getAllEmp() {
        List<employeeDTO> ans=new ArrayList<employeeDTO>();
        for(EmployeeEntity employeeEntity:employeeRepository.findAll()){
            employeeDTO mp=modelMapper.map(employeeEntity,employeeDTO.class);
            ans.add(mp);
        }
        return ans;
    }

    public boolean DelById(Long empId) {
        boolean isPresent= employeeRepository.existsById(empId);
        if(isPresent){
            employeeRepository.deleteById(empId);
            return true;
        }
        return false;

    }
}
