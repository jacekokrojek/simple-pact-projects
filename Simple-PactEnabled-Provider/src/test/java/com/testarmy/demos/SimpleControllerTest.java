package com.testarmy.demos;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

import org.junit.ClassRule;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)
@Provider("simple_provider")
@PactFolder("pacts")
public class SimpleControllerTest {

    @ClassRule
    public static final App embeddedService = new App(8332);


    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new HttpTarget(8332); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)
}