package com.alura.controleFinanceiro.repository;

import com.alura.controleFinanceiro.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface OutcomeRepository extends JpaRepository<Expense, Long> {

    //TODO desenvolver lógica para recuperar o mês da despesa
    Expense getByMonth(Date month);
}
