package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.ExpenseDto;
import com.alura.controleFinanceiro.controller.form.ExpenseForm;
import com.alura.controleFinanceiro.model.Expense;
import com.alura.controleFinanceiro.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    @Autowired
    private final ExpenseRepository expenseRepository;

    //Listagem de despesas
    @GetMapping
    public List<ExpenseDto> lista(){
        List<Expense> expenses = expenseRepository.findAll();
        return ExpenseDto.converter(expenses);
    }

    //TODO Detalhamento de despesa

    //Cadastro de despesa
    @PostMapping
    public ResponseEntity<ExpenseDto> cadastrar(@RequestBody ExpenseForm expenseForm, UriComponentsBuilder uriComponentsBuilder){
        Expense expense = expenseForm.converter(expenseRepository);
        expenseRepository.save(expense);

        URI uri = uriComponentsBuilder.path("expenses/{id}}").buildAndExpand(expense.getId()).toUri();

        return ResponseEntity.created(uri).body(new ExpenseDto(expense));

    }


    //TODO atualização de despesa

    //TODO exclusão de despesa


}