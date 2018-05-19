package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    @NotNull
    private String first;
    @NotNull
    private String second;

    @NotNull
    private String email;
}