package com.alura.controleFinanceiro.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DebitDto {
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDateTime exitDate;
}
