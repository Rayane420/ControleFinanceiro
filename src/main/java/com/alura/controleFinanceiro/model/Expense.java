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
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime date;

    public Outcome(String description, BigDecimal value, LocalDateTime date) {
        this.description = description;
        this.value = value;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outcome outcome = (Outcome) o;
        return Objects.equals(id, outcome.id) && Objects.equals(description, outcome.description) && Objects.equals(value, outcome.value) && Objects.equals(date, outcome.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, value, date);
    }

    @Override
    public String toString() {
        return "Outcomes{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
