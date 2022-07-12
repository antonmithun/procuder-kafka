package com.bidding.apps.biddinggateway.controller;

import com.bidding.apps.biddinggateway.dto.Bid;
import com.bidding.apps.biddinggateway.services.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BillingController {

    private final EventPublisher eventPublisher;

    @Autowired
    public BillingController(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("publish")
    public boolean publish(@RequestBody Bid bid) {
        return eventPublisher.publish(bid);
    }
}
