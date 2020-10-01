import java.util.*;
import java.util.stream.Collectors;

public class CardTest {
    public static void main(String[] args) {

    String[] numbers = new String[]{"2","3","4","5","6","7","8","9","10","A","J","K","Q"};
    String[] signs = new String[]{"C","D","H","S"};
    List<String> allCards = new ArrayList<>();
    String card = "";
        for(String number : numbers){
            for(String sign : signs){
                card = number + sign +".png";
                allCards.add(card);
                System.out.print(card + " ");
            }
        }
        for (int j = allCards.size() - 1; j >= 0; j--) {
            int random = (int) Math.floor(Math.random() * (j + 1));
            String temp = allCards.get(j);
            allCards.set(j,allCards.get(random));
            allCards.set(random,temp);
        }
        Set cardSet = new HashSet<>(allCards);
        System.out.println(cardSet.size());
        for(String c :allCards){
            System.out.print(c + " ");
        }
        System.out.println();
        String path = "/pokers/";
        int random = 0;
        int startIndex = 0;
        while (true){
            random = new Random().nextInt(52);
            if(random < 48){
                startIndex = random;
                break;
            }

        }
        List<String> randomCards = new ArrayList<>();
        for(int i = startIndex; i<= startIndex + 3; i++){
            randomCards.add(allCards.get(i));
        }
        System.out.println();
        System.out.println("random cards:");
        for(String c : randomCards){
            System.out.print(c + " ");
        }
    }
}
