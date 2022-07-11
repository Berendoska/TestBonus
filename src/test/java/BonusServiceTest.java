import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    public void TestShouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long expected = 150;
        long amount = 5000;
        boolean registered = true;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void RegisteredBorderBefore() {
        BonusService service = new BonusService();

        long amount = 16_666;
        boolean registered = true;
        long expected = 499;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void RegisteredBorderAfter() {
        BonusService service = new BonusService();

        long amount = 16_700;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void Unregistered() {
        BonusService service = new BonusService();

        long amount = 500;
        boolean registered = false;
        long expected = 5;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Border() {
        BonusService service = new BonusService();

        long amount = 16_667;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }
}

