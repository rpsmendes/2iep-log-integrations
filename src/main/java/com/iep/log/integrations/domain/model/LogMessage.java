package com.iep.log.integrations.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.marsik.ham.adif.Adif3Record;

import java.time.Instant;

@Data
@Builder
@ToString
public class LogMessage {

    private MessageType messageType;
    private OperationType operationType;
    private String rawRecord;
    private Adif3Record record;
    private String logId;
    private Instant time;

}
