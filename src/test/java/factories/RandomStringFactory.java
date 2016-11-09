package factories;


import java.util.Random;

public class RandomStringFactory {
    private Random random = new Random();

    public String build() {
        return build(9);
    }

    public String build(int length) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(25) + 97;
            buffer.append((char) number);
        }

        return buffer.toString();
    }

}
