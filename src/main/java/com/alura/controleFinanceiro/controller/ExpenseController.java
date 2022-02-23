package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.ExpenseDto;
import com.alura.controleFinanceiro.controller.form.ExpenseForm;
import com.alura.controleFinanceiro.model.Expense;
import com.alura.controleFinanceiro.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    //Listagem de despesas
    @GetMapping
    public List<ExpenseDto> lista(){
        List<Expense> expenses = expenseRepository.findAll();
        return ExpenseDto.converter(expenses);
    }

    //Detalhamento de despesa
   @GetMapping("/{id}")
    public ExpenseDto detalhar(@PathVariable Long id){
        Expense expense = expenseRepository.getOne(id);
        return new ExpenseDto(expense);
    }

    //Cadastro de despesa
    //TODO tratar o cadastro de depesas duplicadas(contendo a mesma descrição, dentro do mesmo mês)
    @PostMapping
    public ResponseEntity<ExpenseDto> cadastrar(@RequestBody @Valid ExpenseForm expenseForm, UriComponentsBuilder uriComponentsBuilder){
        Expense expense = expenseForm.converter(expenseRepository);
        expenseRepository.save(expense);

        URI uri = uriComponentsBuilder.path("expenses/{id}").buildAndExpand(expense.getId()).toUri();

        return ResponseEntity.created(uri).body(new ExpenseDto(expense));

    }


    //TODO atualização de despesa

    //TODO exclusão de despesa


}