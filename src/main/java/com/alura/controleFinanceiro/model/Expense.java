package com.alura.controleFinanceiro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime date;

    public Expense(String description, BigDecimal value, LocalDateTime date) {
        this.description = description;
        this.value = value;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) && Objects.equals(description, expense.description) && Objects.equals(value, expense.value) && Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, value, date);
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
