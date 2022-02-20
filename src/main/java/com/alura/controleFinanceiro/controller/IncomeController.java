package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.IncomeDto;
import com.alura.controleFinanceiro.controller.form.IncomeForm;
import com.alura.controleFinanceiro.model.Income;
import com.alura.controleFinanceiro.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/incomes")
@RequiredArgsConstructor
public class IncomeController {

    @Autowired
    private final IncomeRepository incomeRepository;

    //Listagem de receitas
    @GetMapping
    public List<IncomeDto> lista(){
        List<Income> incomes = incomeRepository.findAll();
        return IncomeDto.converter(incomes);
    }

    //TODO detalhamento da receita

    //Cadastro de receita
    @PostMapping
    public ResponseEntity<IncomeDto> cadastrar(@RequestBody IncomeForm incomeForm, UriComponentsBuilder uriComponentsBuilder){
        Income income = incomeForm.converter(incomeRepository);
        incomeRepository.save(income);

        URI uri = uriComponentsBuilder.path("incomes/{id}").buildAndExpand(income.getId()).toUri();

        return ResponseEntity.created(uri).body(new IncomeDto(income));
    }

    //TODO alterar receita

    //TODO Apagar receita



}
