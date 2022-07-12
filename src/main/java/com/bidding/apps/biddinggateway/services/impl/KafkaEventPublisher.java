package com.bidding.apps.biddinggateway.services.impl;

import com.bidding.apps.biddinggateway.dto.Bid;
import com.bidding.apps.biddinggateway.services.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventPublisher implements EventPublisher {

    private static final String CHANNEL_NAME = "send-out-0";
    private final StreamBridge streamBridge;

    @Autowired
    public KafkaEventPublisher(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public boolean publish(Bid bid) {
        return streamBridge.send(CHANNEL_NAME, bid);
    }
}
