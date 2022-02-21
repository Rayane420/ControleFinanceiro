package com.alura.controleFinanceiro.controller.form;

import com.alura.controleFinanceiro.model.Expense;
import com.alura.controleFinanceiro.repository.ExpenseRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String description;
    @NotNull @NotEmpty @Length(min = 1)
    private BigDecimal value;
    @NotNull @NotEmpty @Length(min = 8)
    private LocalDateTime date;



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

    public Expense converter(ExpenseRepository expenseRepository) {
        return new Expense(description, value, date);
    }
}
