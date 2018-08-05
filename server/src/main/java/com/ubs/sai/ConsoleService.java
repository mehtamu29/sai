package com.ubs.sai;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConsoleService implements Service {
    @Override
    @PostConstruct
    public void execute() {
        System.out.println("SHIRDI SAI BABA: ConsoleService.execute");
    }
}
