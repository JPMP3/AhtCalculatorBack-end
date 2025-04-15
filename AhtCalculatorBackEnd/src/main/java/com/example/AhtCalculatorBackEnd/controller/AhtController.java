package com.example.AhtCalculatorBackEnd.controller;

import com.example.AhtCalculatorBackEnd.aht.CallHistoryResponseDTOOb;
import com.example.AhtCalculatorBackEnd.aht.CallResponseDTOOb;
import com.example.AhtCalculatorBackEnd.service.Call;
import com.example.AhtCalculatorBackEnd.service.CallList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("aht")

public class AhtController {

    private List<Duration> calls = new ArrayList<Duration>(Arrays.asList());
    private List<CallHistoryResponseDTOOb> callHistory = new ArrayList<CallHistoryResponseDTOOb>(Arrays.asList());

    @Autowired
    private CallList myCallList;

    @Autowired
    private Call myCall;

    @Autowired
    private CallResponseDTOOb ahtResultado;

    @Autowired
    private CallHistoryResponseDTOOb callHistoryObj;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public CallResponseDTOOb showAHT(){

        String chamadas = "", media = "";

        if(calls.isEmpty()){
            media = "0";
        }else {
            myCallList.calcularMediaChamadas(calls);
            media = String.format(" %02d:%02d ", myCallList.getMedia().toMinutesPart(), myCallList.getMedia().toSecondsPart());


        }

        chamadas = Integer.toString(myCallList.getQuantidadeDeChamadas());

        String aht ="Media: "+media+" | calls: "+myCallList.getQuantidadeDeChamadas();

        ahtResultado.setTime(media);
        ahtResultado.setQuantidadeDeChamadas(chamadas);

        return ahtResultado;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/history")

    public List<CallHistoryResponseDTOOb> getCallHistory(){

        Collections.reverse(callHistory);

        return callHistory;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public String adicionaCall(@RequestBody Call body){


        calls.add(myCallList.adicionarChamada(body.getTime()));
        myCallList.mostrarQuantidadeChamadas(calls);
        Duration tempo = myCallList.adicionarChamada(body.getTime());
        String tempoFormatado = String.format(" %02d:%02d ", tempo.toMinutesPart(), tempo.toSecondsPart());
        CallHistoryResponseDTOOb call = new CallHistoryResponseDTOOb(tempoFormatado);
        callHistory.add(call);


        return "Call adicionada, tempo: "+body.getTime();
    }




}
