package com.tushar.demo.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class employeeDTO {
    private Long id;
    private String name;
    private LocalDate DateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;

}
