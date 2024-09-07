package com.iep.log.integrations.message.adapter;

import com.iep.log.integrations.domain.model.LogMessage;
import com.iep.log.integrations.domain.model.MessageType;
import com.iep.log.integrations.domain.model.OperationType;
import com.iep.log.integrations.message.model.qlog.QLogUDPMessage;
import com.iep.log.integrations.service.AdiService;
import org.marsik.ham.adif.Adif3Record;

public class QLogMessageAdapter implements MessageInputAdapter<QLogUDPMessage, LogMessage> {

    private final AdiService adiService;

    public QLogMessageAdapter(AdiService adiService) {
        this.adiService = adiService;
    }

    @Override
    public LogMessage adapt(QLogUDPMessage message) {

        return LogMessage.builder()
                .messageType(messageType(message.getMsgType()))
                .operationType(operationType(message.getData().getOperation()))
                .record(getSingleAdiffRecord(message.getData().getValue()))
                .rawRecord(message.getData().getValue())
                .logId(message.getLogId())
                .time(message.getTime())
                .build();

    }

    private Adif3Record getSingleAdiffRecord(String value)  {
        return adiService.readRecord(value)
                .map(rec -> rec.getRecords().getFirst())
                .orElse(null);
    }

    private MessageType messageType(String msgType) {
        return MessageType.fromString(msgType);
    }

    private OperationType operationType(String operation) {
        return OperationType.fromString(operation);
    }

}
