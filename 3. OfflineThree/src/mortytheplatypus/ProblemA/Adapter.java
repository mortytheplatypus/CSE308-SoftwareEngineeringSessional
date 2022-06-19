package mortytheplatypus.ProblemA;

import java.io.*;

public class Adapter implements IAdapter {
    public static final String PATHNAME = "" +
            "F:\\Education\\BUET\\Academic\\Level 3 Term 1" +
            "\\Sessional\\CSE308\\3. OfflineThree\\src" +
            "\\mortytheplatypus\\ProblemA\\IntermediateInput.txt";
    private String regex;

    public Adapter(String pathname, String regex) throws IOException {
        this.regex = regex;
        this.CreateNewFile(pathname);
    }

    @Override
    public double calculateSum() throws IOException {
        return new Summer(PATHNAME).calculateSum();
    }

    private void CreateNewFile(String pathname) throws IOException {
        File originalFile = new File(pathname);

        File newFile = new File(PATHNAME);
        newFile.createNewFile();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(originalFile));
        String numbers[] = bufferedReader.readLine().split(regex);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATHNAME));

        for (String number : numbers) {
            bufferedWriter.write(number);
            bufferedWriter.write(" ");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
