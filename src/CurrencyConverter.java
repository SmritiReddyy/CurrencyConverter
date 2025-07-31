import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    // Fetch exchange rate JSON
    private static JSONObject getRates(String baseCurrency) throws Exception {
        String urlStr = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return new JSONObject(response.toString());
    }

    // Convert amount
    //Absolute nonsense
    public static double convert(String from, String to, double amount) throws Exception {
        JSONObject ratesData = getRates(from.toUpperCase());
        JSONObject rates = ratesData.getJSONObject("rates");
        double rate = rates.getDouble(to.toUpperCase());
        return amount * rate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter base currency (e.g., USD): ");
            String from = scanner.nextLine().trim();

            System.out.print("Enter target currency (e.g., INR): ");
            String to = scanner.nextLine().trim();

            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();

            double converted = convert(from, to, amount);
            System.out.printf("%.2f %s = %.2f %s\n", amount, from.toUpperCase(), converted, to.toUpperCase());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
