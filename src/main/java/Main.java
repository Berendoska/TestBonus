public class Main {

    public static void main(String[] arg) {
        BonusService service = new BonusService();

        long expected = 150;
        long actual = service.calculate(5_000, true);

        System.out.println(actual);

    }
}
