package mortytheplatypus.ProblemA;

import java.io.*;
import java.util.Scanner;

public class Summer {
    protected String pathname;
    private double sum;

    public Summer(String pathname) {
        this.pathname = pathname;
        this.sum = 0.0;
    }

    public double calculateSum() throws IOException {
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String numbers[] = bufferedReader.readLine().split(" ");

        for (String number : numbers) {
            sum += Double.parseDouble(number);
        }

        bufferedReader.close();
        return sum;
    }
}
