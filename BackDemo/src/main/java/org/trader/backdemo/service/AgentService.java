package org.trader.backdemo.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.trader.backdemo.dto.response.FeatureResponse;


import java.io.InputStream;
import java.io.IOException;
@RequiredArgsConstructor
@Service
public class AgentService {

    public FeatureResponse getFeatures() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                "static/FeatureConst.json")) {
            if (inputStream == null) {
                throw new IOException("File not found");
            }
            return objectMapper.readValue(inputStream, FeatureResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
