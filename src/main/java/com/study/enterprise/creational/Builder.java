package com.study.enterprise.creational;

public class Builder {
    static final class DeliveryRequest {
        private final String orderNumber;
        private final String address;
        private final boolean callBeforeArrival;
        private final String note;

        private DeliveryRequest(RequestBuilder builder) {
            orderNumber = builder.orderNumber;
            address = builder.address;
            callBeforeArrival = builder.callBeforeArrival;
            note = builder.note;
        }

        @Override
        public String toString() {
            return "Заказ " + orderNumber + ", адрес: " + address
                    + ", звонок перед доставкой: " + (callBeforeArrival ? "да" : "нет")
                    + ", комментарий: " + note;
        }

        static class RequestBuilder {
            private final String orderNumber;
            private String address;
            private boolean callBeforeArrival;
            private String note = "без комментария";

            RequestBuilder(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            RequestBuilder address(String address) {
                this.address = address;
                return this;
            }

            RequestBuilder callBeforeArrival() {
                callBeforeArrival = true;
                return this;
            }

            RequestBuilder note(String note) {
                this.note = note;
                return this;
            }

            DeliveryRequest build() {
                if (orderNumber == null || orderNumber.isBlank() || address == null || address.isBlank()) {
                    throw new IllegalStateException("Для доставки нужны номер заказа и адрес");
                }
                return new DeliveryRequest(this);
            }
        }
    }

    public static String demo() {
        DeliveryRequest request = new DeliveryRequest.RequestBuilder("103")
                .address("ул. Садовая, 10")
                .callBeforeArrival()
                .note("Вход со двора")
                .build();
        return request.toString();
    }
}
