package com.alura.controleFinanceiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Debit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime exitDate;

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

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debit debit = (Debit) o;
        return Objects.equals(id, debit.id) && Objects.equals(description, debit.description) && Objects.equals(value, debit.value) && Objects.equals(exitDate, debit.exitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, value, exitDate);
    }

    @Override
    public String toString() {
        return "Debit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", exitDate=" + exitDate +
                '}';
    }
}
