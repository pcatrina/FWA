package edu.school21.cinema.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FormFieldsMapper{
    ObjectMapper objectMapper;

    public <T> T convertValue(Map<String, String[]> fromMap, Class<T> toValueType) throws IllegalArgumentException {
        Map<String, String> flatMap = fromMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()[0]));

        return objectMapper.convertValue(flatMap, toValueType);
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
