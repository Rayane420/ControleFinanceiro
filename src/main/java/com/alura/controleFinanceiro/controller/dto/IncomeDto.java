package com.alura.controleFinanceiro.controller.dto;

import com.alura.controleFinanceiro.model.Income;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class IncomeDto {

    private String description;
    private BigDecimal value;
    private LocalDateTime date;

    public IncomeDto() {
    }

    public IncomeDto(Income income) {
        this.description = income.getDescription();
        this.value = income.getValue();
        this.date = income.getDate();
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

    public static List<IncomeDto> converter(List<Income> incomes){
        return incomes.stream().map(IncomeDto::new).collect(Collectors.toList());
    }

}
