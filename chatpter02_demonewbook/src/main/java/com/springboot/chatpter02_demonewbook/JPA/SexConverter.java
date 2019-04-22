package com.springboot.chatpter02_demonewbook.JPA;

import com.springboot.chatpter02_demonewbook.jdbctemp.SexEnum;

import javax.persistence.AttributeConverter;

public class SexConverter implements AttributeConverter<SexEnum , Integer> {
    @Override
    public Integer convertToDatabaseColumn(SexEnum sex) {
        return sex.getId();
    }

    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getEnumByID(id);
    }
}
