interface PaymentMethod {
    boolean processPayment(double amount);
    void printReceipt();
}

class CreditCardPayment implements PaymentMethod {
    public String cardNumber;
    public String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment...");
        return true;
    }

    @Override
    public void printReceipt() {
        String masked = "****-****-****" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Receipt: " + masked);
        System.out.println("Cardholder: " + cardHolderName);
    }
}

class DebitCardPayment implements PaymentMethod {
    public String cardNumber;
    public String bankName;

    public DebitCardPayment(String cardNumber, String bankName) {
        this.cardNumber = cardNumber;
        this.bankName = bankName;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing debit card payment...");
        return true;
    }

    @Override
    public void printReceipt() {
        String masked = "****-****-****" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Receipt: " + masked);
        System.out.println("Bank: " + bankName);
    }
}

class PayPalPayment implements PaymentMethod {
    public String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment for " + email + "...");
        return true;
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt: PayPal Account: " + email);
    }

}


public class App {
    public static void main(String[] args) throws Exception {
        PaymentMethod[] instantiate = {
           new CreditCardPayment("1111222233334444", "Tim Ross"),
           new DebitCardPayment("5555666677778888", "BECU"),
           new PayPalPayment("tim.ross@gmail.com") 
        };

        for (PaymentMethod ea : instantiate) {
            ea.processPayment(500);
            ea.printReceipt();
        }
    }
}