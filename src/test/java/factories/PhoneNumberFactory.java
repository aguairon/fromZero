package factories;


import java.util.Random;

public class PhoneNumberFactory {
    private static final Random random = new Random();

    public String build() {
        StringBuilder buffer = new StringBuilder("+44 1702 ");

        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(10);
            buffer.append(number);
        }

        return buffer.toString();
    }
}
