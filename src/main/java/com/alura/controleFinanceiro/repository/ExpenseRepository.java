package com.alura.controleFinanceiro.repository;

import com.alura.controleFinanceiro.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
}
