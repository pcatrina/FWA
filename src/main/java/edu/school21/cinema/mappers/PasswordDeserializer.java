package edu.school21.cinema.mappers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class PasswordDeserializer extends JsonDeserializer<List<String>> {

    private static PasswordEncoder passwordEncoder;

    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return List.of(passwordEncoder.encode(jsonParser.getText()),jsonParser.getText()) ;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        PasswordDeserializer.passwordEncoder = passwordEncoder;
    }
}
