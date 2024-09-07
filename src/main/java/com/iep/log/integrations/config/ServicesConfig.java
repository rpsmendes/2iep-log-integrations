package com.iep.log.integrations.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iep.log.integrations.message.adapter.QLogMessageAdapter;
import com.iep.log.integrations.message.adapter.RawUDPMessageAdapter;
import com.iep.log.integrations.service.AdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;

@Configuration
public class ServicesConfig {


    @Bean
    public RawUDPMessageAdapter udpMessageAdapter(@Autowired ObjectMapper objectMapper){
        return new RawUDPMessageAdapter(adiService(), objectMapper);
    }

    @Bean
    public AdiService adiService() {
        return new AdiService();
    }

}
