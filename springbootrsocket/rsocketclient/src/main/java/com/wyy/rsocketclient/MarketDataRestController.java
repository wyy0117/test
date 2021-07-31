package com.wyy.rsocketclient;

import com.wyy.MarketData;
import com.wyy.MarketDataRequest;
import org.reactivestreams.Publisher;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

/**
 * @Date: 2021/7/17
 * @Author: wyy
 */
@RestController
public class MarketDataRestController {

    private final Random random = new Random();
    private final RSocketRequester rSocketRequester;

    public MarketDataRestController(RSocketRequester rSocketRequester) {
        this.rSocketRequester = rSocketRequester;
    }

    @GetMapping("/current/{stock}")
    public Publisher<MarketData> current(@PathVariable("stock") String stock) {
        return rSocketRequester
                .route("currentMarketData")
                .data(new MarketDataRequest(stock))
                .retrieveMono(MarketData.class);
    }

    @GetMapping("/collect")
    public Publisher<Void> collect() {
        return rSocketRequester
                .route("collectMarketData")
                .data(getMarketData())
                .send();
    }

    @GetMapping(value = "/feed/{stock}", produces = TEXT_EVENT_STREAM_VALUE)
    public Publisher<MarketData> feed(@PathVariable("stock") String stock) {
        return rSocketRequester
                .route("feedMarketData")
                .data(new MarketDataRequest(stock))
                .retrieveFlux(MarketData.class);
    }

    private MarketData getMarketData() {
        return new MarketData("X", random.nextInt(10));
    }

}
