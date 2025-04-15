package com.example.AhtCalculatorBackEnd.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service

public class CallList {
    private Duration media;
    private int quantidadeDeChamadas;

    public CallList(String callTime) {
        this.media = Duration.ofMinutes(Integer.parseInt(callTime));
    }


    public Duration adicionarChamada(String callTime){
        int mins = 0, sec = 0;
        Duration totalCall;
        if( callTime.length() > 0 && callTime.length() < 3){
            mins = 0;
            sec =  Integer.parseInt(callTime.substring((callTime.length()-2), callTime.length()));
        }else if(callTime.length() > 1 && callTime.length() < 5) {
            mins = Integer.parseInt(callTime.substring(0, callTime.length()-2));
            sec =  Integer.parseInt(callTime.substring((callTime.length()-2), callTime.length()));
        }


        //adding in list
        totalCall = Duration.ofMinutes(mins).plus(Duration.ofSeconds(sec));

        return totalCall;
    }

    public void mostrarQuantidadeChamadas(List<Duration> callList){
        int quantidade = 0;
        if(!callList.isEmpty()){
            for(Duration call : callList){
                quantidade++;
            }
        }

        setQuantidadeDeChamadas(quantidade);
    }

    public Duration calcularMediaChamadas(List<Duration> callList) {
        Duration totalCalls = Duration.ZERO;

        for(Duration call : callList) {
            totalCalls = totalCalls.plus(call);
        }

        return media = totalCalls.dividedBy(callList.size());
    }

}
