package com.controlHub.fibonacci.infrastructure.controller;

import com.controlHub.fibonacci.application.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.Map;

@RestController
public class FibonacciController {
    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping("/fibonacci/{n}")
    public ResponseEntity<?> getFibonacciValue(@PathVariable int n) throws InterruptedException {
        if (n < 0 || n > 100) {
            throw new InvalidParameterException("n must be between 0 and 50");
        }
        String result = fibonacciService.calculateFibonacci(BigInteger.valueOf(n));
        return ResponseEntity.ok(Map.of("result", result));
    }

}