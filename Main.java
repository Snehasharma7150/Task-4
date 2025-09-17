import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
  public static void main(String[] args) {
    String inputFile = "products.csv";
    String outputFile = "expensive_products.csv";
    try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
         FileWriter fw = new FileWriter(outputFile)) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        if (data.length == 2) {
          String name = data[0];
          double price = Double.parseDouble(data[1]);
          if (price > 1000) {
            fw.write(name + "," + price + "
");
          }
        }
      }
      System.out.println("Expensive products written to " + outputFile);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
