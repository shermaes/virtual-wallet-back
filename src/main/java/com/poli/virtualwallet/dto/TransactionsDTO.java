package com.poli.virtualwallet.dto;

import lombok.Data;

@Data
public class TransactionsDTO {
    private String id;
    private String source;
    private String receiver;
    private Double amount;
    private String date;
}
