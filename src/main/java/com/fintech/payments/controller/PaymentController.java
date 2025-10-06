package com.fintech.payments.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
    @PostMapping("/create")
    // response will be a text
    public ResponseEntity<String> createPayment(){
        try{
            // create a payment of $10
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(1000L)
                    .setCurrency("usd")
                    .build();
            // calls stripe's API using secret key
            // replied with secret id
            PaymentIntent intent = PaymentIntent.create(params);
            return ResponseEntity.ok("PaymentIntent created " + intent.getClientSecret());
        }catch (StripeException e){
            return ResponseEntity.status(500).body("Error " + e.getMessage());
        }
    }
}
