package com.alura.controleFinanceiro.controller.dto;

import com.alura.controleFinanceiro.model.Expense;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDto {


    private String description;
    private BigDecimal value;
    private LocalDateTime date;


    public ExpenseDto(Expense outcomes) {

        this.description = outcomes.getDescription();
        this.value = outcomes.getValue();
        this.date = outcomes.getDate();
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

    public static List<ExpenseDto> converter(List<Expense> outcomes){
        return outcomes.stream().map(ExpenseDto::new).collect(Collectors.toList());
    }

}
