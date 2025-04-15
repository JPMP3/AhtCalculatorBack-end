package com.example.AhtCalculatorBackEnd.configuration;

import com.example.AhtCalculatorBackEnd.aht.CallHistoryResponseDTOOb;
import com.example.AhtCalculatorBackEnd.aht.CallResponseDTOOb;
import com.example.AhtCalculatorBackEnd.service.Call;
import com.example.AhtCalculatorBackEnd.service.CallList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CallConfiguration {

    @Bean
    public Call myCall(){
        return new Call(0);
    }

    @Bean
    public CallList myCallList(){
        return new CallList(myCall().getTime());
    }

    @Bean
    public CallResponseDTOOb ahtResultado(){
        return new CallResponseDTOOb();
    }

    @Bean
    public CallHistoryResponseDTOOb callHistory(){
        return new CallHistoryResponseDTOOb();
    }
}
