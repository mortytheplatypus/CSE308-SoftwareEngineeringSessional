package mortytheplatypus.ProblemA;

public class Main {
    private static final String decimalPathname = "" +
            "F:\\Education\\BUET\\Academic\\Level 3 Term 1" +
            "\\Sessional\\CSE308\\3. OfflineThree\\src" +
            "\\mortytheplatypus\\ProblemA\\DecimalInput.txt";

    public static void main(String[] args) throws Exception {
        System.out.println(new Adapter(decimalPathname).calculateSum());
    }
}
