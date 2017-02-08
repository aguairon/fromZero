package factories;


import types.Card;

public class CardFactory {
    public Card build() {
        Card card = new Card();
        card.cardNumber = "411111";
        card.securityCode = "737";
        card.cardholderName = "Begona Fernandez";
        card.expiryDate = "07/18";
        return card;
    }
}
