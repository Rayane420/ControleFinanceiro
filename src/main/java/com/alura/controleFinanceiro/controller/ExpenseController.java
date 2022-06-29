package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.OutcomeDto;
import com.alura.controleFinanceiro.controller.form.OutcomeForm;
import com.alura.controleFinanceiro.model.Outcome;
import com.alura.controleFinanceiro.repository.OutcomeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/outcomes")
public class OutcomeController {

    @Autowired
    private OutcomeRepository outcomeRepository;

    @GetMapping
    public List<OutcomeDto> findAll(){
        List<Outcome> outcomes = outcomeRepository.findAll();
        return OutcomeDto.converter(outcomes);
    }

   @GetMapping("/{id}")
    public OutcomeDto findById(@PathVariable Long id){
        Outcome outcome = outcomeRepository.getById(id);
        return new OutcomeDto(outcome);
    }

    //TODO concluir listar despesas por ano e mês
    @GetMapping("{year}/{month}")
    public OutcomeDto findByMonth(@PathVariable Integer month, @PathVariable Integer year){
        Outcome outcome = outcomeRepository.getByMonth(month);
        return new OutcomeDto(outcome);
    }

    //TODO tratar o cadastro de depesas duplicadas(contendo a mesma descrição, dentro do mesmo mês)
    @PostMapping
    public ResponseEntity<OutcomeDto> create(@RequestBody @Valid OutcomeForm outcomeForm, UriComponentsBuilder uriComponentsBuilder){
        Outcome outcome = outcomeForm.converter(outcomeRepository);
        outcomeRepository.save(outcome);

        URI uri = uriComponentsBuilder.path("outcomes/{id}").buildAndExpand(outcome.getId()).toUri();

        return ResponseEntity.created(uri).body(new OutcomeDto(outcome));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OutcomeDto> update(@PathVariable Long id, @RequestBody @Valid OutcomeForm form){

        Outcome expense = form.update(id, outcomeRepository);

        return ResponseEntity.ok(new OutcomeDto(expense));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id){
        outcomeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}