public class Suica extends Card {
    private double balance;

    public Suica(double balance) {
        super("Suica");
        this.balance = balance;
    }

    @Override
    public void pay() {
        System.out.println("Suica swiped! (Suica已刷卡)");
    }

    // Unique method for Suica
    // Suica特有的功能：显示余额
    public void showBalance() {
        System.out.println("Suica balance: " + balance + " JPY. (Suica余额: " + balance + "日元)");
    }
}