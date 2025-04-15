package com.example.AhtCalculatorBackEnd.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service

public class Call {
    private String time;

    public Call(int callTimeInit){
        this.time = Integer.toString(callTimeInit);
    }
}
