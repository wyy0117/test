package com.wyy.rsocketclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.codec.ByteArrayDecoder;
import org.springframework.core.codec.ByteArrayEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.util.MimeTypeUtils;

/**
 * @Date: 2021/7/17
 * @Author: wyy
 */
@Configuration
public class ClientConfiguration {


    @Bean
    public RSocketStrategies rSocketStrategies() {
        return RSocketStrategies.builder()
                .decoder(new ByteArrayDecoder())
                .encoder(new ByteArrayEncoder())
                .build();
    }

    @Bean
    RSocketRequester rSocketRequester(RSocketStrategies rSocketStrategies) {
        return RSocketRequester.builder()
                .dataMimeType(MimeTypeUtils.APPLICATION_JSON)
                .metadataMimeType(MimeTypeUtils.APPLICATION_JSON)
                .rsocketStrategies(rSocketStrategies)
                .tcp("localhost", 7000);

    }
}
