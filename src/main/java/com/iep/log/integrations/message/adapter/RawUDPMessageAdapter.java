package com.iep.log.integrations.message.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iep.log.integrations.domain.model.LogMessage;
import com.iep.log.integrations.message.model.qlog.QLogUDPMessage;
import com.iep.log.integrations.service.AdiService;
import lombok.Data;

@Data
public class RawUDPMessageAdapter {

    private final AdiService adiService;
    private final ObjectMapper objectMapper;

    public RawUDPMessageAdapter(AdiService adiService, ObjectMapper objectMapper) {
        this.adiService = adiService;
        this.objectMapper = objectMapper;
    }

    public LogMessage adaptRawMessage(String messageJson) {
        try {
            QLogUDPMessage incomingMessage = objectMapper.readValue(messageJson, QLogUDPMessage.class);

            switch (incomingMessage.getAppId()) {
                case "QLog":
                    return new QLogMessageAdapter(adiService).adapt(incomingMessage);
                default:
                    throw new IllegalArgumentException("Unknown appId: " + incomingMessage.getAppId());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to process message", e);
        }
    }
}
