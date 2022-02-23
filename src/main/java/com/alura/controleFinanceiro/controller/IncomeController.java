package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.ExpenseDto;
import com.alura.controleFinanceiro.controller.dto.IncomeDto;
import com.alura.controleFinanceiro.controller.form.IncomeForm;
import com.alura.controleFinanceiro.model.Income;
import com.alura.controleFinanceiro.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    //Listagem de receitas
    @GetMapping
    public List<IncomeDto> lista(){
        List<Income> incomes = incomeRepository.findAll();
        return IncomeDto.converter(incomes);
    }

    //TODO detalhamento da receita
    @GetMapping("/{id}")
    public IncomeDto detalhar(@PathVariable Long id){
        Income income = incomeRepository.getById(id);
        return new IncomeDto(income);
    }

    //Cadastro de receita
    //TODO tratar o cadastro de receitas duplicadas
    @PostMapping
    public ResponseEntity<IncomeDto> cadastrar(@RequestBody @Valid IncomeForm incomeForm, UriComponentsBuilder uriComponentsBuilder){
        Income income = incomeForm.converter(incomeRepository);
        incomeRepository.save(income);

        URI uri = uriComponentsBuilder.path("incomes/{id}").buildAndExpand(income.getId()).toUri();

        return ResponseEntity.created(uri).body(new IncomeDto(income));
    }

    //TODO alterar receita

    //TODO exclusão da receita



}
