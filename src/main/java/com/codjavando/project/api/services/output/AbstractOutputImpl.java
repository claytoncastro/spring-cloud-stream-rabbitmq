package com.codjavando.project.api.services.output;

import com.codjavando.project.api.model.AbstractEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@EnableBinding(Source.class)
public class AbstractOutputImpl implements AbstractOutput {

    @Autowired
    private MessageChannel output;

    @Override
    public AbstractEntity publishEvent(AbstractEntity abstractEntity) {
        log.info("Sending message!!");
        output.send(MessageBuilder.withPayload(abstractEntity).build());
        return abstractEntity;
    }
}
