package com.controlHub.fibonacci;

import com.controlHub.fibonacci.application.FibonacciService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.security.InvalidParameterException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class FibonacciServiceTest {

    @Autowired
    private FibonacciService fibonacciService;

    @Test
    public void testCalculateFibonacciWithSmallNumber() throws InterruptedException {
        BigInteger input = BigInteger.valueOf(5);
        String expectedOutput = "5";

        String actualOutput = fibonacciService.calculateFibonacci(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCalculateFibonacciWithLargeNumber() throws InterruptedException {
        BigInteger input = BigInteger.valueOf(60);
        String expectedOutput = "1548008755920";

        String actualOutput = fibonacciService.calculateFibonacci(input);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCalculateFibonacciWithInvalidInput() {
        BigInteger input = BigInteger.valueOf(-1);

        Assertions.assertThrows(InvalidParameterException.class, () -> fibonacciService.calculateFibonacci(input));
    }

}