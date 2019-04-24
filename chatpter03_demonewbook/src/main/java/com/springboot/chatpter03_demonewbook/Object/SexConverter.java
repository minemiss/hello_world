package com.springboot.chatpter03_demonewbook.Object;


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
