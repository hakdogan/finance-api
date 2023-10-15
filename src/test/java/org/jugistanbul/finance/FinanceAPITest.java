package org.jugistanbul.finance;

import io.quarkus.test.junit.main.Launch;
import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 15.10.2023
 ***/
@QuarkusMainTest
public class FinanceAPITest
{
    @Test
    @Launch(value = "USD")
    public void usdCurrencyTest(LaunchResult result) {
        Assertions.assertTrue(result.getOutput().contains("USD"));
    }

    @Test
    @Launch(value = "EUR")
    public void euroCurrencyTest(LaunchResult result) {
        Assertions.assertTrue(result.getOutput().contains("EUR"));
    }
}
