import java.util.*;

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

class Book implements Comparable<Book>{
    String title;
    String year;
    String genre;

    public Book(String title, String year, String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    @Override
    public int compareTo(Book other) {
        int genreComparison = this.genre.compareTo(other.genre);
        if (genreComparison != 0) {return genreComparison;}

        int yearComparison = other.year.compareTo(this.year);
        if (yearComparison != 0) {return yearComparison;}

        return this.title.compareTo(other.title);
    }


    public printBook() {
        return title + " - " + year + " - " + genre;
    }


}



public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("The Great Gatsby", "1925", "Fiction"));
        books.add(new Book("To Kill a Mockingbird", "1960", "Fiction"));
        books.add(new Book("1984", "1949", "Dystopian"));
        books.add(new Book("Pride and Prejudice", "1813", "Romance"));
        books.add(new Book("The Catcher in the Rye", "1951", "Fiction"));
        books.add(new Book("Jane Eyre", "1847", "Romance"));
        books.add(new Book("Brave New World", "1932", "Dystopian"));
        books.add(new Book("Animal Farm", "1945", "Dystopian"));


        Collections.sort(books);

        for (Book ea : books) {
            System.out.println(ea.year);
        }
        Set<String> myStringSet = Set.of("apple", "banana", "cherry");

        System.out.println(maxLength(myStringSet));

        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(2,"apple");
        myMap.put(1,"banana");
        myMap.put(3,"orange");

        Map<String, Integer> newMap = reverse(myMap);
        System.out.println(myMap);
        System.out.println(newMap);






        // PaymentMethod[] instantiate = {
        //    new CreditCardPayment("1111222233334444", "Tim Ross"),
        //    new DebitCardPayment("5555666677778888", "BECU"),
        //    new PayPalPayment("tim.ross@gmail.com") 
        // };

        // for (PaymentMethod ea : instantiate) {
        //     ea.processPayment(500);
        //     ea.printReceipt();
        // }
    //     int[] loopOne = {2, 6, 1, 8};
    //     int[] loopTwo = {30, 20, 10, 60, 50, 40};
    //     int[] loopThree = {-4, 16, 9, 1, 64, 25, 36, 4, 49};

    //     ArrayList<Integer> one = new ArrayList<>();
    //     ArrayList<Integer> two = new ArrayList<>();
    //     ArrayList<Integer> three = new ArrayList<>();

    //     for (int ea : loopOne) {
    //         one.add(ea);
    //     }

    //     for (int ea : loopTwo) {
    //         two.add(ea);
    //     }

    //     for (int ea : loopThree) {
    //         three.add(ea);
    //     }

    //     mystery(one);
    //     mystery(two);
    //     mystery(three);
    // }

    // public static void mystery(ArrayList<Integer> list) {
    //     for (int i = list.size() - 1; i > 0; i--) {
    //         if (list.get(i) < list.get(i - 1)) {
    //             int element = list.get(i);
    //             list.remove(i);
    //             list.add(0, element);
    //         }
    //     }
    //     System.out.println(list);
    }

    private static void removeEvenLength(ArrayList<String> listoStrings) {
        for (int i = listoStrings.size() - 1;  i >= 0; i--) {
            if (listoStrings.get(i).length() % 2 == 0) {
                listoStrings.remove(i);
            }
        }
    }

    private static void mirror(ArrayList<String> listoStrings) {
            for (int i = listoStrings.size() - 1;  i >= 0; i--) {
                listoStrings.add(listoStrings.get(i));
        }
    }

    private static int maxLength(Set<String> stringSet) {
        if (stringSet.isEmpty()) {
            return 0;
        }
        int max = 0;

        for (String ea : stringSet) {
            max = Math.max(max, ea.length());
        }

        return max;
    }

    private static Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> reversal = new HashMap<>();

        for (int num: map.keySet()) {
            String name = map.get(num);

            reversal.put(name, num);
        }

        return reversal;
    }

}