package com.study.enterprise.creational;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    interface OrderPrototype {
        OrderPrototype copy();

        void addItem(String item);

        List<String> items();
    }

    static class OrderTemplate implements OrderPrototype {
        private final List<String> items;

        OrderTemplate(List<String> items) {
            this.items = new ArrayList<>(items);
        }

        @Override
        public OrderPrototype copy() {
            return new OrderTemplate(items);
        }

        @Override
        public void addItem(String item) {
            items.add(item);
        }

        @Override
        public List<String> items() {
            return List.copyOf(items);
        }
    }

    public static String demo() {
        OrderPrototype template = new OrderTemplate(List.of("Кружка", "Открытка"));
        OrderPrototype customOrder = template.copy();
        customOrder.addItem("Подарочная упаковка");
        return "Шаблон: " + template.items() + "; копия: " + customOrder.items();
    }
}
