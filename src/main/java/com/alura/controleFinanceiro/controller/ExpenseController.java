package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.ExpenseDto;
import com.alura.controleFinanceiro.controller.form.ExpenseForm;
import com.alura.controleFinanceiro.model.Expense;
import com.alura.controleFinanceiro.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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
    public List<ExpenseDto> findAll(){
        List<Expense> expenses = expenseRepository.findAll();
        return ExpenseDto.converter(expenses);
    }

    //Detalhamento de despesa
   @GetMapping("/{id}")
    public ExpenseDto findById(@PathVariable Long id){
        Expense expense = expenseRepository.getById(id);
        return new ExpenseDto(expense);
    }

    //Cadastro de despesa
    //TODO tratar o cadastro de depesas duplicadas(contendo a mesma descrição, dentro do mesmo mês)
    @PostMapping
    public ResponseEntity<ExpenseDto> create(@RequestBody @Valid ExpenseForm expenseForm, UriComponentsBuilder uriComponentsBuilder){
        Expense expense = expenseForm.converter(expenseRepository);
        expenseRepository.save(expense);

        URI uri = uriComponentsBuilder.path("expenses/{id}").buildAndExpand(expense.getId()).toUri();

        return ResponseEntity.created(uri).body(new ExpenseDto(expense));

    }


    //Atualização de despesa
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ExpenseDto> update(@PathVariable Long id, @RequestBody @Valid ExpenseForm form){

        Expense expense = form.update(id, expenseRepository);

        return ResponseEntity.ok(new ExpenseDto(expense));
    }

    //Exclusão de despesa
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}