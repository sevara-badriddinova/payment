package com.fintech.payments.service;

import com.stripe.Stripe;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService {
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    // run this class after Spring is done creating the variable
    @PostConstruct
    public void init(){
        Stripe.apiKey = stripeSecretKey;
    }

    public StripePaymentService(){
        Dotenv dotenv = Dotenv.load();
        Stripe.apiKey = dotenv.get("STRIPE_SECRET_KEY");
    }
}
