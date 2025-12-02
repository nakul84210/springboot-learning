package com.nakulxcode.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nakulxcode.springbootwebtutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Required Field ")
    @Size(min = 3, max = 10)
    private String name;

    @Email(message = "Please enter a valid email")
    private String email;

    @Max(value = 80, message = "Age of employee cannot be greater than 80")
    @Min(value = 20, message = "Age of employee cannot be les than 20")
    private Integer age;

    @NotBlank
    @EmployeeRoleValidation
    //@Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can be USER or ADMIN")
    private String role;

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Integer salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
