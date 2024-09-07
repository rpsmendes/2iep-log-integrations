package com.iep.log.integrations.message.adapter;

public interface MessageInputAdapter<I, O> {

    O adapt(I message);

}
