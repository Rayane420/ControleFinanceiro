package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.IncomeDto;
import com.alura.controleFinanceiro.controller.form.IncomeForm;
import com.alura.controleFinanceiro.model.Income;
import com.alura.controleFinanceiro.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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
    public List<IncomeDto> findAll(){
        List<Income> incomes = incomeRepository.findAll();
        return IncomeDto.converter(incomes);
    }

    //TODO detalhamento da receita
    @GetMapping("/{id}")
    public IncomeDto findById(@PathVariable Long id){
        Income income = incomeRepository.getById(id);
        return new IncomeDto(income);
    }

    //Cadastro de receita
    //TODO tratar o cadastro de receitas duplicadas
    @PostMapping
    public ResponseEntity<IncomeDto> create(@RequestBody @Valid IncomeForm incomeForm, UriComponentsBuilder uriComponentsBuilder){
        Income income = incomeForm.converter(incomeRepository);
        incomeRepository.save(income);

        URI uri = uriComponentsBuilder.path("incomes/{id}").buildAndExpand(income.getId()).toUri();

        return ResponseEntity.created(uri).body(new IncomeDto(income));
    }

    //alterar receita
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<IncomeDto> update(@PathVariable Long id, @RequestBody @Valid IncomeForm form){
        Income income = form.update(id, incomeRepository);

        return ResponseEntity.ok(new IncomeDto(income));

    }

    //TODO exclusão da receita



}
