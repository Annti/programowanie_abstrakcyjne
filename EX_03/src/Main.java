public class Main {

    public static void main(String[] args) {
        System.out.println("Start!");

        Tests tests = new Tests();

        tests.TestEmptyListCreation();
        String a = "3";
        String b = "3";
        System.out.println(b.equals(a));
        System.out.println("End!");
    }
}
