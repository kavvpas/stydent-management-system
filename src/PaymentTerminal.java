public class PaymentTerminal {
    public static void main(String[] args) {
        // Polymorphic Array storing different cards
        // 多态数组，存放不同的卡片
        Card[] cards = {new Suica(1500), new Card("PointCard")};

        for (int i = 0; i < cards.length; i++) {
            cards[i].pay(); // Polymorphic call (多态调用)

            // HARD PART: How to call showBalance() only for Suica?
            // 难点：如何只让Suica执行显示余额的动作？

            // Check if the card is actually a Suica object
            // 检查当前对象是否真的是 Suica 类型
            if (cards[i] instanceof Suica) {
                // Downcasting: Convert Card back to Suica
                // 向下转型：把Card转回Suica，这样才能调用特有方法
                Suica s = (Suica) cards[i];
                s.showBalance();
            }
            System.out.println("--------------------");
        }
    }
}