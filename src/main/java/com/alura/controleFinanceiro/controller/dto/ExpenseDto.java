package com.alura.controleFinanceiro.controller.dto;

import com.alura.controleFinanceiro.model.Expenses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDto {

    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime date;


    public ExpenseDto(Expenses expenses) {
        this.id = expenses.getId();
        this.description = expenses.getDescription();
        this.value = expenses.getValue();
        this.date = expenses.getDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public static List<ExpenseDto> converter(List<Expenses> expenses){
        return expenses.stream().map(ExpenseDto::new).collect(Collectors.toList());
    }

}
