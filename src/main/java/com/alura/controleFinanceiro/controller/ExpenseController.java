package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.ExpenseDto;
import com.alura.controleFinanceiro.model.Expenses;
import com.alura.controleFinanceiro.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gasto")
@RequiredArgsConstructor
public class ExpenseController {

    @Autowired
    private final ExpenseRepository expenseRepository;

    //Lista dos Gastos
    @GetMapping
    public List<ExpenseDto> lista(){
        List<Expenses> expenses = expenseRepository.findAll();
        return ExpenseDto.converter(expenses);
    }

    //TODO Cadastrar gastos

    //TODO alterar gasto

    //TODO Apagar Gasto


}