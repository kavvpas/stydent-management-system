import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class trump {
    public static void main(String[] args) {
        ArrayList<String> trump = new ArrayList<>();
        Collections.addAll(trump, "1", "1", "2", "2", "3", "3", "4", "4", "5", "5","6");
        HashMap<String,ArrayList<String>> player = new HashMap<>();
        int t = trump.size()/3;
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(trump);
            for (int j = 0; j < t; j++) {
                ArrayList<String> trump1 = new ArrayList<>();
                trump1.add(trump.get(0));
                trump.remove(trump.get(0));
                player.put("hrm",trump1);
            }
            ArrayList<String> cards = player.get("hrm");
            Collections.sort(cards);
        }

    }
}
