public class Card {
    private String cardType;

    public Card(String cardType) {
        this.cardType = cardType;
    }

    // Common pay method
    // 通用的支付动作
    public void pay() {
        System.out.println("Processing payment with " + cardType + "... (支付处理中...)");
    }

    public String getCardType() { return cardType; }
}