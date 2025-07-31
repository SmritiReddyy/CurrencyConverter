# 💱 Currency Converter

A simple Java application that fetches real-time currency exchange rates using the [ExchangeRate-API](https://www.exchangerate-api.com/) and converts between currencies based on user input.

## 🚀 Features

- Fetches live exchange rates from ExchangeRate-API
- Converts currency from one to another
- Supports user input via terminal
- Built using Java’s built-in `HttpURLConnection` and `org.json` for parsing

## 🧾 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/SmritiReddyy/CurrencyConverter.git
   cd CurrencyConverter

2. Compile and run:
```
javac src/CurrencyConverter.java src/Main.java
java src.Main
``` 
Or run via IntelliJ by right-clicking Main.java and selecting Run.

3. Sample Input:
Enter base currency (e.g., USD): USD
Enter target currency (e.g., INR): INR
Enter amount to convert: 100

Output:
100.00 USD = 8310.50 INR

