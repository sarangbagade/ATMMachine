package com.template.TemplateProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Integer userId;
    private TransactionType transactionType;
    private String transactionInfo;
    private Long timestamp;
}
