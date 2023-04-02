package com.template.TemplateProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;
    private String cardNumber;
    private String pin;
    private Integer balance;
}
