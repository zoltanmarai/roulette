import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
   static Roulette roulette = new Roulette();
   static List<Player> luckyPack = new ArrayList<>();

    public static void main(String[] args) {
        roulette.fillMap();
        roulette.setPrizeList();
        MartingelBela mb = new MartingelBela();
        RandomRudolf rr = new RandomRudolf();
        luckyPack.add(mb);
        luckyPack.add(rr);
        int menu;
        Scanner si = new Scanner(System.in);
do {

    System.out.println("Szimuláció ---> 1-es gomb");
    System.out.println("Játék  -------> 2-es gomb");
    System.out.println("Kilépés  -----> 0-ás gomb");

     menu = si.nextInt();
    if (menu == 1) {
        System.out.println(" Hány pörgetés legyen?");
        int spin = si.nextInt();
        simulation( spin);
    } else if (menu == 2) {
        interaction();
    }
}
    while (menu != 0) ;
    si.close();

    }
    static void  simulation(int  spin) {

        int redCounter = 0;
        int blackCounter = 0;
        int zeroCounter = 0;
        int result = 0;
        String r;
        String strategy = "";
        Map.Entry<Integer, String> rouletteEntry;
        PrizeClass prizeClass = null;

        for (int i = 0; i < spin; i++) {
            rouletteEntry = roulette.spin();
            System.out.println(rouletteEntry);
            r = rouletteEntry.getValue();

            for (Player player : luckyPack) {
                strategy = player.strategy();
                System.out.println(strategy);
                //System.out.println(r);
                for (int j = 0; j < roulette.prizeList.size(); j++) {
                    if (strategy.equals(roulette.prizeList.get(j).getName())) {
                        prizeClass = new PrizeClass(roulette.prizeList.get(j).getName(), roulette.prizeList.get(j).getMultiplier(), roulette.prizeList.get(j).getOpposite());
                    }
                }

                if (r.contains(strategy)) {

                    redCounter++;
                    player.setResult(player.getResult ()+(prizeClass.getMultiplier() - 1) *player.getMin());
                    player.setMin(player.betStrategy(true,player.getMin()));
                } else {

                    blackCounter++;
                    player.setResult(player.getResult()-(player.getMin() * (prizeClass.getMultiplier() - 1)));
                    player.setMin(player.betStrategy(false,player.getMin()));
                }



               // System.out.println(" Nyert: " + redCounter + " " +  "Vesztett : " + (blackCounter + zeroCounter));
                System.out.println(player.getName()+" "+player.getResult());
                System.out.println(player.getMin());
            }
        }

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

