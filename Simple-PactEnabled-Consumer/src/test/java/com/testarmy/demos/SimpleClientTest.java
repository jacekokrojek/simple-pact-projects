package com.testarmy.demos;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SimpleClientTest {

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("simple_provider", "localhost", 8080, this);

    @Test
    @PactVerification("simple_provider")
    public void runTest() throws IOException {
        assertEquals(new SimpleClient(mockProvider.getUrl()).getSimple("23"), 0);
    }

    @Pact(provider="simple_provider", consumer="simple_consumer")
    public RequestResponsePact createPact(PactDslWithProvider pactDslWithProvider) {
        return pactDslWithProvider
                .uponReceiving("a request to say Hello")
                .path("/client/simple")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("{\"hello\": \"farry\"}")
                .toPact();
    }

}
