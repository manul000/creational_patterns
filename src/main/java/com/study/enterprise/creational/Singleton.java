package com.study.enterprise.creational;

public class Singleton {
    static final class StoreSettings {
        private static final StoreSettings INSTANCE = new StoreSettings();
        private final String currency = "RUB";

        private StoreSettings() {
        }

        static StoreSettings getInstance() {
            return INSTANCE;
        }

        String currency() {
            return currency;
        }
    }

    public static String demo() {
        StoreSettings catalogSettings = StoreSettings.getInstance();
        StoreSettings checkoutSettings = StoreSettings.getInstance();
        return "Общий экземпляр настроек: " + (catalogSettings == checkoutSettings)
                + ", валюта магазина: " + checkoutSettings.currency();
    }
}
