package com.iep.log.integrations.message.model.qlog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QLogUDPData {

    private String operation;

    @JsonProperty("rowid")
    private int rowId;

    private String type;

    private String value;

}
