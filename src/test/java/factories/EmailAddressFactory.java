package factories;


public class EmailAddressFactory {

    public String build() {
        RandomStringFactory randomStringFactory = new RandomStringFactory();
        return "automated.test+" + randomStringFactory.build() + "@wahanda.co.uk";
    }
}
