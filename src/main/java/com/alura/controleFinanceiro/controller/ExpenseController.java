package com.alura.controleFinanceiro.controller;

import com.alura.controleFinanceiro.controller.dto.CreditDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditController {

@GetMapping("/receitas")
    public List<CreditDto> list(){
    //return creditRepository.findAll();
    return null;
}

}