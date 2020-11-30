import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
   static Roulette roulette = new Roulette();
   static List<Player> luckyPack = new ArrayList<>();

    public static void main(String[] args) {
        roulette.fillMap();
        int menu;
        Scanner si = new Scanner(System.in);
do {

    System.out.println("Szimuláció ---> 1-es gomb");
    System.out.println("Játék  -------> 2-es gomb");
    System.out.println("Kilépés  -----> 0-ás gomb");

     menu = si.nextInt();
    if (menu == 1) {
        System.out.println("Mennyi legyen a tét?");
        int bet1= si.nextInt();
        System.out.println(" Hány pörgetés legyen?");
        int spin = si.nextInt();
        simulation(bet1, spin, luckyPack);
    } else if (menu == 2) {
        interaction();
    }
}
    while (menu != 0) ;
    si.close();

        Player mb = new MartingelBela();
        luckyPack.add(mb);


    }
    static void  simulation(int min, int  spin, List<Player> players){

        int redCounter = 0;
        int blackCounter = 0;
        int zeroCounter = 0;
        String r;
        Map.Entry<Integer, String> rouletteEntry ;

        for (int i = 0; i < spin; i++) {
            rouletteEntry = roulette.spin();
            System.out.println(rouletteEntry);
            r = rouletteEntry.getValue();
            for (Player player : luckyPack) {
                if (r.contains(player.strategy())){
                    redCounter++;
                }else if (!r.contains(player.strategy())) {
                    blackCounter++;
                } else {
                    zeroCounter++;
                }
            }
        }
        System.out.println("Piros: " +redCounter+ " fekete: "+blackCounter+ " 0: "+zeroCounter);
        System.out.println((redCounter*min)-min*(blackCounter+zeroCounter));
    }
    static void interaction(){
        String answer;
        String r;
        Map.Entry<Integer, String> rouletteEntry ;
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        System.out.println("Mennyi a tőkéd?");
        int pocketMoney = sc.nextInt();
        while ( play) {
            System.out.println("Add meg a tétet.");
            int bet = sc.nextInt();
            String s = "piros";
            pocketMoney -= bet;

                if (pocketMoney >= 0) {
                    rouletteEntry = roulette.spin();
                    System.out.println(rouletteEntry);
                    r = rouletteEntry.getValue();
                    if (r.contains(s)) {
                        bet *= 2;
                    } else if (r.contains("fekete")) {
                        bet = 0;
                    } else {
                        bet = 0;
                    }
                    System.out.println(" Ebben a körben ennyi pénzt nyertél: " + bet);

                }else {
                    System.out.println("Nincs elég pénzed.");
                }
            pocketMoney += bet;
            System.out.println(" Összesen ennyi pénzed van most: " + pocketMoney);

            System.out.println("Akarsz még játszani?(igen/nem)");
            answer = sc.next();
            answer= answer.toLowerCase();
            play = answer.equals("igen");
            if(pocketMoney<=0){
                play= false;
                System.out.println("Elfogyott a pénzed.");
            }

        }

    }
}

