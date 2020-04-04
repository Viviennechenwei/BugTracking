package com.vivi.bugTracking.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.FactoryBean;

public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper> {
    @Override
    public ObjectMapper getObject() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Override
    public Class<?> getObjectType() {
        return ObjectMapper.class;
    }
}
