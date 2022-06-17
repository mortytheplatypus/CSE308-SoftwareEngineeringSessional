package mortytheplatypus.ProblemA;

import java.io.*;

public class Adapter extends Summer {

    private static final String newPathname = "" +
            "F:\\Education\\BUET\\Academic\\Level 3 Term 1" +
            "\\Sessional\\CSE308\\3. OfflineThree\\src" +
            "\\mortytheplatypus\\ProblemA\\IntegerInput.txt";

    public Adapter(String pathname) throws IOException {
        super(pathname);
        CreateNewFile();
    }

    private void CreateNewFile() throws IOException {
        File originalFile = new File(this.pathname);

        File newFile = new File(newPathname);
        newFile.createNewFile();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(originalFile));
        String numbers[] = bufferedReader.readLine().split("~");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newPathname));

        for (String number : numbers) {
            bufferedWriter.write(number);
            bufferedWriter.write(" ");
        }

        bufferedReader.close();
        bufferedWriter.close();

        this.pathname = newPathname;
    }
}
