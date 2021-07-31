package com.wyy.rsocketserver;

import com.wyy.MarketData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Date: 2021/7/17
 * @Author: wyy
 */
@Slf4j
@Component
public class MarketDataRepository {

    private static final int BOUND = 100;
    private Random random = new Random();

    public Flux<MarketData> getAll(String stock) {
        log.info("GET ALL: {}", stock);
        return Flux.fromStream(Stream.generate(() -> getMarketDataResponse(stock)))
                .log()
                .delayElements(Duration.ofSeconds(1));
    }

    public Mono<MarketData> getOne(String stock) {
        log.info("GET ONE: {}", stock);
        return Mono.just(getMarketDataResponse(stock));
    }

    public void add(MarketData marketData) {
        log.info("New market data: {}", marketData);
    }

    private MarketData getMarketDataResponse(String stock) {
        return new MarketData(stock, random.nextInt(BOUND));
    }

}
