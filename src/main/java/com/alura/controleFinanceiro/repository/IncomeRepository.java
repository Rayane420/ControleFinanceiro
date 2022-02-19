package com.alura.controleFinanceiro.repository;

import com.alura.controleFinanceiro.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
