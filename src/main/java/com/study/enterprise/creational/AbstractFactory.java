package com.study.enterprise.creational;

public class AbstractFactory {
    interface Receipt {
        String type();
    }

    interface ShippingLabel {
        String type();
    }

    interface OrderDocumentFactory {
        Receipt createReceipt();

        ShippingLabel createLabel();
    }

    static class RetailReceipt implements Receipt {
        @Override
        public String type() {
            return "розничный чек";
        }
    }

    static class ParcelLabel implements ShippingLabel {
        @Override
        public String type() {
            return "этикетка посылки";
        }
    }

    static class WholesaleInvoice implements Receipt {
        @Override
        public String type() {
            return "оптовый счёт";
        }
    }

    static class PalletLabel implements ShippingLabel {
        @Override
        public String type() {
            return "этикетка палеты";
        }
    }

    static class RetailDocumentFactory implements OrderDocumentFactory {
        @Override
        public Receipt createReceipt() {
            return new RetailReceipt();
        }

        @Override
        public ShippingLabel createLabel() {
            return new ParcelLabel();
        }
    }

    static class WholesaleDocumentFactory implements OrderDocumentFactory {
        @Override
        public Receipt createReceipt() {
            return new WholesaleInvoice();
        }

        @Override
        public ShippingLabel createLabel() {
            return new PalletLabel();
        }
    }

    static String createDocumentSet(OrderDocumentFactory factory) {
        Receipt receipt = factory.createReceipt();
        ShippingLabel label = factory.createLabel();
        return receipt.type() + " + " + label.type();
    }

    public static String demo() {
        return "Розница: " + createDocumentSet(new RetailDocumentFactory())
                + "; опт: " + createDocumentSet(new WholesaleDocumentFactory());
    }
}
