import java.util.Scanner;

interface PaymentGateway {
    public void pay();
}

class Paytm implements PaymentGateway {
    public void pay() {
        System.out.println("Current Payment Gateway is PayTM");
    }
}

class GPay implements PaymentGateway {
    public void pay() {
        System.out.println("Current Payment Gateway is GPay");
    }
}

class PaymentGatewayAdapter implements PaymentGateway {
    private Paytm paytm;

    public PaymentGatewayAdapter(Paytm paytm) {
        this.paytm = paytm;
    }

    @Override
    public void pay() {
        paytm.pay();
        System.out.println("Changing the Payment Gateway from PayTM to GPay...");
        // Additional logic to adapt Paytm to GPay could go here
    }
}

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Paytm paytm = new Paytm();
        System.out.println("Select A Payment Gateway: ");
        System.out.println("a) PayTM \nb) GPay");
        String choice = sc.nextLine();

        PaymentGateway paymentGateway;
        if (choice.equals("a")) {
            paymentGateway = paytm;
        } else if (choice.equals("b")) {
            paymentGateway = new PaymentGatewayAdapter(paytm);
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        paymentGateway.pay();
        sc.close();
    }
}
