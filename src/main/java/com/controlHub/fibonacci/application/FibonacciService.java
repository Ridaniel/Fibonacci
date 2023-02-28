package com.controlHub.fibonacci.application;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.InvalidParameterException;

@Service
public class FibonacciService {

    @Cacheable(value = "fibonacciCache", key = "#n")
    public String calculateFibonacci(BigInteger n) throws InterruptedException {
        if (n.intValue() < 0 || n.intValue() > 100) {
            throw new InvalidParameterException("n must be between 0 and 50");
        }
        if (n.intValue() < 2) {
            return n.toString();
        }
        BigInteger[] fibonacci = new BigInteger[n.add(BigInteger.ONE).intValue()];
        fibonacci[0] = BigInteger.valueOf(0);
        fibonacci[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= n.intValue(); i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }
        //Turn this on to test cache
        //Thread.sleep(1000);
        return fibonacci[n.intValue()].toString();
    }
}