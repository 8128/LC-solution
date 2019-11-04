import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Decide if a certain note/coin is needed for change.
 */

/**
 * all the coins and notes
 */
enum Money {
    Fifty_Pound(50, "Fifty Pounds"), Twenty_Pound(20, "Twenty Pounds"), Ten_Pound(10,"Ten Pounds"),
    Five_Pound(5, "Five Pounds"), Two_Pound(2,"Two Pounds"), One_Pound(1, "One Pound"),
    Fifty_Pence(0.5, "Fifty Pence"), Twenty_Pence(0.2, "Twenty Pence"), Ten_Pence(0.1, "Ten Pence"),
    Five_Pence(0.05, "Five Pence"), Two_Pence(0.02, "Two Pence"), One_Pence( 0.01, "One Pence");

    private double value;
    private String code;

    private Money(double value, String code) {
        this.value = value;
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

}


public class Problem2 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        try {
            double purchasePrice = Double.parseDouble(in.readLine());
            double cash = Double.parseDouble(in.readLine());
            Problem2.calculateChange(purchasePrice, cash);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void calculateChange(double purchasePrice, double cash) {
        // Access your code here. Feel free to create other classes as required

        if (cash == purchasePrice) { // no change needed
            System.out.println("ZERO");
            return;
        }
        // not enough cash or negative number
        if (cash < purchasePrice || cash < 0 || purchasePrice < 0) {
            System.out.println("ERROR");
            return;
        }
        double change = cash - purchasePrice; // amount that should be given back to customers
        String output = ""; // output on the screen
        Money[] values = Money.values();
        for (Money money : values) {
            int amount = (int) (change / money.getValue());
            change -= amount * money.getValue();
            // solve accuracy problem of java compiler
            change = (double) (Math.round(change * 100)) / 100;
            if (amount != 0) {
                for (int i = 0; i < amount; i++) {
                    output += money.getCode() + ", ";
                }
            }
            if (change == 0) { // no need to search smaller denominations
                break;
            }
        }
        if (output != "" || output != ", ") {
            output = output.substring(0, output.length() - 2); // get rid of last ", "
        }
        System.out.println(output);
    }
}
