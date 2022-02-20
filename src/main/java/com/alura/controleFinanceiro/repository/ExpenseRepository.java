package com.alura.controleFinanceiro.repository;

import com.alura.controleFinanceiro.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
