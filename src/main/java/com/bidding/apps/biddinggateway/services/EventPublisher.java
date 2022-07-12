package com.bidding.apps.biddinggateway.services;

import com.bidding.apps.biddinggateway.dto.Bid;

public interface EventPublisher {

    boolean publish(Bid payload);
}
