package com.iep.log.integrations.message.model.qlog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.iep.log.integrations.domain.model.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QLogUDPMessage {

    @JsonProperty("appid")
    private String appId;

    private QLogUDPData data;

    @JsonProperty("logid")
    private String logId;

    @JsonProperty("msgtype")
    private String msgType;

//    @JsonDeserialize(using = InstantDeserializer.class)
    private Instant time;

}
