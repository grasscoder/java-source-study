package com.test;

import java.util.ServiceLoader;

public class TestSpi {
    public static void main(String[] args) {
        ServiceLoader<String> serviceLoader = ServiceLoader.load(String.class);
    }
}
