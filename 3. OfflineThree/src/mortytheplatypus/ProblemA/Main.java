package mortytheplatypus.ProblemA;

public class Main {
    private static final String decimalPathname = "" +
            "F:\\Education\\BUET\\Academic\\Level 3 Term 1" +
            "\\Sessional\\CSE308\\3. OfflineThree\\src" +
            "\\mortytheplatypus\\ProblemA\\DecimalInput.txt";

    private static final String integerPathname = "" +
            "F:\\Education\\BUET\\Academic\\Level 3 Term 1" +
            "\\Sessional\\CSE308\\3. OfflineThree\\src" +
            "\\mortytheplatypus\\ProblemA\\IntegerInput.txt";

    public static void main(String[] args) throws Exception {
        System.out.print("\nSum of integers from the integer file separated by ' ': ");
        System.out.println(new Summer(integerPathname).calculateSum());

        System.out.print("\nSum of decimals from the decimal file separated by '~': ");
        System.out.println(new Adapter(decimalPathname, "~").calculateSum());
    }
}
