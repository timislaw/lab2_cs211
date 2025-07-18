import java.util.ArrayList;

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
        // PaymentMethod[] instantiate = {
        //    new CreditCardPayment("1111222233334444", "Tim Ross"),
        //    new DebitCardPayment("5555666677778888", "BECU"),
        //    new PayPalPayment("tim.ross@gmail.com") 
        // };

        // for (PaymentMethod ea : instantiate) {
        //     ea.processPayment(500);
        //     ea.printReceipt();
        // }
        int[] loopOne = {2, 6, 1, 8};
        int[] loopTwo = {30, 20, 10, 60, 50, 40};
        int[] loopThree = {-4, 16, 9, 1, 64, 25, 36, 4, 49};

        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();

        for (int ea : loopOne) {
            one.add(ea);
        }

        for (int ea : loopTwo) {
            two.add(ea);
        }

        for (int ea : loopThree) {
            three.add(ea);
        }

        mystery(one);
        mystery(two);
        mystery(three);
    }

    public static void mystery(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                int element = list.get(i);
                list.remove(i);
                list.add(0, element);
            }
        }
        System.out.println(list);
    }
}