package com.example.AhtCalculatorBackEnd.aht;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CallResponseDTOOb {
    private String time;
    private String quantidadeDeChamadas;

}
