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
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime entryDate;

    public Credit(String description, BigDecimal value, LocalDateTime entryDate) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.entryDate = entryDate;
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

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) && Objects.equals(description, credit.description) && Objects.equals(value, credit.value) && Objects.equals(entryDate, credit.entryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, value, entryDate);
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", entryDate=" + entryDate +
                '}';
    }
}
