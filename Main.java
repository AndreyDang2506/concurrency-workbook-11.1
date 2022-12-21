import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import models.Line;

public class Main {

    static final String SALES = "data/sales.csv"; // Use backslash Windows users

    public static void main(String[] args) {
        Path path = Paths.get(SALES);
        Stream<String> lines;

        try {
            Paths.get(Thread.currentThread().getContextClassLoader().getResource(SALES).toURI());
            // calculate average sales of "Furniture" here
            // calculate average sales of "Technology" here
            // calculate average sales of "Office Supplies" here
            // calculate total average of sales here

            double averageTech = getAverage("Technology1");
            System.out.println(averageTech);
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function name: average
     * 
     * @param path     (Path)
     * @param category (String)
     * @return Double
     * 
     *         Inside the function:
     *         1. Runs through every line from the CSV file as a stream.
     *         2. Maps every element in the stream to an array of three String
     *         values.
     *         3. Filters every value by the @param category
     *         4. Maps every element in the stream to a double (price * quantity).
     *         5. Applies the terminal operation average.
     *         6. Returns the average as double.
     * @throws FileNotFoundException
     * 
     */
    public static Double getAverage(String category) {
        Path path = Paths.get(SALES);
        Stream<String> lines;
        double totalQuantity = 0;
        try {
            lines = Files.lines(path)
                    .skip(1)
                    .filter((line) -> {
                        line = line.trim();
                        String[] items = line.split(",");
                        if (items[0].equals(category)) {
                            return true;
                        }
                        return false;
                    });
            Stream<Line> lineObjects = lines.map(line -> {
                line = line.trim();
                String[] items = line.split(",");
                String cat = items[0].trim();
                Double price = Double.parseDouble(items[1].trim());
                int quantity = Integer.parseInt(items[2].trim());

                if (cat.equals(category)) {
                    return new Line(cat, price, quantity);
                }
                return null;
            });

            totalQuantity = lineObjects.map(Line::getQuantity).reduce(0, Integer::sum);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return totalQuantity;
    }

    /**
     * Function name: totalAverage
     * 
     * @param path (Path)
     * @return Double
     * 
     *         Inside the function:
     *         1. Runs through every line from the CSV file as a stream.
     *         2. Maps every element in the stream to an array of three values.
     *         3. Maps every element in the stream to a double: (price * quantity).
     *         4. Applies the terminal operation average.
     *         5. Returns the average as double.
     */

}
