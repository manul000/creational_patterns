package com.study.enterprise.creational;

public class FactoryMethod {
    interface Delivery {
        String prepare(String orderNumber);
    }

    static class Courier implements Delivery {
        @Override
        public String prepare(String orderNumber) {
            return "Заказ " + orderNumber + " передан курьеру";
        }
    }

    static class Pickup implements Delivery {
        @Override
        public String prepare(String orderNumber) {
            return "Заказ " + orderNumber + " ждёт в пункте выдачи";
        }
    }

    abstract static class DeliveryWorkflow {
        protected abstract Delivery createDelivery();

        final String dispatch(String orderNumber) {
            Delivery delivery = createDelivery();
            return delivery.prepare(orderNumber);
        }
    }

    static class CourierWorkflow extends DeliveryWorkflow {
        @Override
        protected Delivery createDelivery() {
            return new Courier();
        }
    }

    static class PickupWorkflow extends DeliveryWorkflow {
        @Override
        protected Delivery createDelivery() {
            return new Pickup();
        }
    }

    public static String demo() {
        DeliveryWorkflow courier = new CourierWorkflow();
        DeliveryWorkflow pickup = new PickupWorkflow();
        return courier.dispatch("101") + "; " + pickup.dispatch("102");
    }
}
