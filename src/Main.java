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
        Table table = new Table();
        table.createTable();
        MartingelBela mb = new MartingelBela();
        RandomRudolf rr = new RandomRudolf();
        GyavaGyuszi gg = new GyavaGyuszi();
        BatorBotond bb = new BatorBotond();
        luckyPack.add(mb);
        luckyPack.add(rr);
        luckyPack.add(gg);
        luckyPack.add(bb);

        int menu;
        Scanner si = new Scanner(System.in);
do {

    System.out.println("Szimuláció -----------> 1-es gomb");
    System.out.println("Játék  ---------------> 2-es gomb");
    System.out.println("Játék játékosokkal ---> 3-es gomb");
    System.out.println("Kilépés  -------------> 0-ás gomb");

     menu = si.nextInt();
    if (menu == 1) {
        System.out.println(" Hány pörgetés legyen?");
        int spin = si.nextInt();
        simulation( spin);
    } else if (menu == 2) {
        interaction();
    }
    else if( menu ==3){
        fullCasino();
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
        String r ="";
        int  strategy ;
        Map.Entry<Integer, String> rouletteEntry;
        PrizeClass prizeClass = null;

        for (int i = 0; i < spin; i++) {
            rouletteEntry = roulette.spin();
            System.out.println(rouletteEntry);
            r = rouletteEntry.getValue();

            for (Player player : luckyPack) {
                strategy = player.strategy();
               // System.out.println(strategy);
                //System.out.println(r);
                for (int j = 0; j < roulette.prizeList.size(); j++) {
                    if (strategy == j) {

                        prizeClass = new PrizeClass(roulette.prizeList.get(j).getName(), roulette.prizeList.get(j).getMultiplier(), roulette.prizeList.get(j).getOpposite());
                      //  System.out.println(roulette.prizeList.get(j).getName()+" "+roulette.prizeList.get(j).getMultiplier()+" "+roulette.prizeList.get(j).getOpposite());
                    }
                }

                if (r.contains(prizeClass.getName())) {

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
        PrizeClass prizeClass = null;
        int bet1 = 0;
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        System.out.println("Mennyi a tőkéd?");
        int pocketMoney = sc.nextInt();
        while ( play) {
            System.out.println("Mire tennél?");
            System.out.println("Pirosra -------------> 1-es gomb");
            System.out.println("Feketére ------------> 2-es gomb");
            System.out.println("Párosra -------------> 3-es gomb");
            System.out.println("Páratlanra ----------> 4-es gomb");
            System.out.println("1.fél(1-18) ---------> 5-es gomb");
            System.out.println("2.fél(19-36) --------> 6-es gomb");
            System.out.println("1.harmad(1-12) ------> 7-es gomb");
            System.out.println("2.harmad(13-24) -----> 8-es gomb");
            System.out.println("3.harmad(25-36) -----> 9-es gomb");
            System.out.println("1.oszlop -----------> 10-es gomb");
            System.out.println("2.oszlop -----------> 11-es gomb");
            System.out.println("3.oszlop -----------> 12-es gomb");
            System.out.println("1 db számra --------> 13-es gomb");
            System.out.println("2 db számra --------> 14-es gomb");
            System.out.println("3 db számra --------> 15-es gomb");
            System.out.println("4 db számra --------> 16-es gomb");
            System.out.println("6 db számra --------> 17-es gomb");
            int var = sc.nextInt();
            prizeClass = new PrizeClass(roulette.prizeList.get(var-1).getName(), roulette.prizeList.get(var-1).getMultiplier(), roulette.prizeList.get(var-1).getOpposite());

            System.out.println("Add meg a tétet.");
            int bet = sc.nextInt();
            if( var < 13) {
                String s = prizeClass.getName();
                pocketMoney -= bet;

                if (pocketMoney >= 0) {
                    rouletteEntry = roulette.spin();
                    System.out.println(rouletteEntry);
                    r = rouletteEntry.getValue();
                    if (r.contains(s)) {
                        bet *= prizeClass.getMultiplier();
                    } else if (r.contains(prizeClass.getOpposite())) {
                        bet = 0;
                    } else {
                        bet = 0;
                    }
                    System.out.println(" Ebben a körben ennyi pénzt nyertél: " + bet);
                    pocketMoney += bet;
                }  else  if (pocketMoney+bet <= 0){
                    System.out.println("Nincs elég pénzed.");
                } else {
                    pocketMoney+=bet;
                }
            }else{
                List<Integer> numbers = new ArrayList<>();
                int num;
                int number;
                switch (var){

                    case 13:
                        do {
                            System.out.println("Add meg a számot");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=36));
                        numbers.add(number);
                        break;
                    case 14:

                        do {
                            System.out.println("Add meg a számot");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=33));
                        boolean a;
                        do {
                             a = false;
                            System.out.println("Add meg a 2. számot");
                            num = sc.nextInt();
                            if(number % 3 == 0 && num == number+1){
                                a = true;
                            }

                        }while ((num != number+1 && num != number+3) || a);
                        numbers.add(number);
                        numbers.add(num);
                        break;
                    case 15:
                        do {
                            System.out.println("Add meg a számot, a kombinációból, a legkisebbet.");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=33) || (number % 3!=1));
                        numbers.add(number);
                        numbers.add(number+1);
                        numbers.add(number+2);
                        break;
                    case 16:
                        do {
                            System.out.println("Add meg a számot, a kombinációból, a legkisebbet.");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=32) || (number % 3==0));
                        numbers.add(number);
                        numbers.add(number+1);
                        numbers.add(number+3);
                        numbers.add(number+4);
                        break;
                    case 17:
                        do {
                            System.out.println("Add meg a számot, a kombinációból, a legkisebbet.");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=30) || (number % 3!=1));
                        numbers.add(number);
                        numbers.add(number+1);
                        numbers.add(number+2);
                        numbers.add(number+3);
                        numbers.add(number+4);
                        numbers.add(number+5);

                        break;

                }
                String s = prizeClass.getName();
                pocketMoney -= bet;

                if (pocketMoney >= 0) {
                    rouletteEntry = roulette.spin();
                    System.out.println(rouletteEntry);
                    int win = rouletteEntry.getKey();
                        bet1=0;
                    for (int i = 0; i < numbers.size(); i++) {
                        System.out.println(numbers.get(i));
                        if (win == numbers.get(i)) {
                            bet1= bet *prizeClass.getMultiplier();

                        }
                    }
                    System.out.println(" Ebben a körben ennyi pénzt nyertél: " + bet1);
                    pocketMoney += bet1;
                } else  if (pocketMoney+bet <= 0){
                    System.out.println("Nincs elég pénzed.");
                } else {
                    pocketMoney+=bet;
                }
            }

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
    static void fullCasino(){

        String r ="";
        int  strategy ;
        Map.Entry<Integer, String> rouletteEntry;
        PrizeClass prizeClass = null;

        String answer;

        int bet1 = 0;
        Scanner sc = new Scanner(System.in);
        boolean play = true;
        System.out.println("Minden játékos 1000 pénzzel játszik");
        int pocketMoney = 1000;
        rouletteEntry = roulette.spin();
       // System.out.println(rouletteEntry);
       while ( play) {
            System.out.println("Mire tennél?");
            System.out.println("Pirosra -------------> 1-es gomb");
            System.out.println("Feketére ------------> 2-es gomb");
            System.out.println("Párosra -------------> 3-es gomb");
            System.out.println("Páratlanra ----------> 4-es gomb");
            System.out.println("1.fél(1-18) ---------> 5-es gomb");
            System.out.println("2.fél(19-36) --------> 6-es gomb");
            System.out.println("1.harmad(1-12) ------> 7-es gomb");
            System.out.println("2.harmad(13-24) -----> 8-es gomb");
            System.out.println("3.harmad(25-36) -----> 9-es gomb");
            System.out.println("1.oszlop -----------> 10-es gomb");
            System.out.println("2.oszlop -----------> 11-es gomb");
            System.out.println("3.oszlop -----------> 12-es gomb");
            System.out.println("1 db számra --------> 13-es gomb");
            System.out.println("2 db számra --------> 14-es gomb");
            System.out.println("3 db számra --------> 15-es gomb");
            System.out.println("4 db számra --------> 16-es gomb");
            System.out.println("6 db számra --------> 17-es gomb");
            int var = sc.nextInt();

            prizeClass = new PrizeClass(roulette.prizeList.get(var-1).getName(), roulette.prizeList.get(var-1).getMultiplier(), roulette.prizeList.get(var-1).getOpposite());

            System.out.println("Add meg a tétet.");
            int bet = sc.nextInt();
            if( var < 13) {
                String s = prizeClass.getName();
                pocketMoney -= bet;

                if (pocketMoney >= 0) {
                    System.out.println(rouletteEntry);
                    r = rouletteEntry.getValue();
                    if (r.contains(s)) {
                        bet *= prizeClass.getMultiplier();
                    } else if (r.contains(prizeClass.getOpposite())) {
                        bet = 0;
                    } else {
                        bet = 0;
                    }
                    System.out.println(" Ebben a körben ennyi pénzt nyertél: " + bet);
                    pocketMoney += bet;
                }  else  if (pocketMoney+bet <= 0){
                    System.out.println("Nincs elég pénzed.");
                } else {
                    pocketMoney+=bet;
                }
            }else{
                List<Integer> numbers = new ArrayList<>();
                int num;
                int number;
                switch (var){

                    case 13:
                        do {
                            System.out.println("Add meg a számot");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=36));
                        numbers.add(number);
                        break;
                    case 14:

                        do {
                            System.out.println("Add meg a számot");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=33));
                        boolean a;
                        do {
                            a = false;
                            System.out.println("Add meg a 2. számot");
                            num = sc.nextInt();
                            if(number % 3 == 0 && num == number+1){
                                a = true;
                            }

                        }while ((num != number+1 && num != number+3) || a);
                        numbers.add(number);
                        numbers.add(num);
                        break;
                    case 15:
                        do {
                            System.out.println("Add meg a számot, a kombinációból, a legkisebbet.");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=33) || (number % 3!=1));
                        numbers.add(number);
                        numbers.add(number+1);
                        numbers.add(number+2);
                        break;
                    case 16:
                        do {
                            System.out.println("Add meg a számot, a kombinációból, a legkisebbet.");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=32) || (number % 3==0));
                        numbers.add(number);
                        numbers.add(number+1);
                        numbers.add(number+3);
                        numbers.add(number+4);
                        break;
                    case 17:
                        do {
                            System.out.println("Add meg a számot, a kombinációból, a legkisebbet.");
                            number = sc.nextInt();
                        }while (!(number>=0 && number<=30) || (number % 3!=1));
                        numbers.add(number);
                        numbers.add(number+1);
                        numbers.add(number+2);
                        numbers.add(number+3);
                        numbers.add(number+4);
                        numbers.add(number+5);

                        break;

                }
                String s = prizeClass.getName();
                pocketMoney -= bet;

                if (pocketMoney >= 0) {

                    int win = rouletteEntry.getKey();
                    bet1=0;
                    for (int i = 0; i < numbers.size(); i++) {
                        System.out.println(numbers.get(i));
                        if (win == numbers.get(i)) {
                            bet1= bet *prizeClass.getMultiplier();

                        }
                    }
                    System.out.println(rouletteEntry);
                    System.out.println(" Ebben a körben ennyi pénzt nyertél: " + bet1);
                    pocketMoney += bet1;
                } else  if (pocketMoney+bet <= 0){
                    System.out.println("Nincs elég pénzed.");
                } else {
                    pocketMoney+=bet;
                }
            }

            System.out.println(" Összesen ennyi pénzed van most: " + pocketMoney);

           // System.out.println("Akarsz még játszani?(igen/nem)");
           // answer = sc.next();
          //  answer= answer.toLowerCase();
          //  play = answer.equals("igen");
          //  if(pocketMoney<=0){
           //     play= false;
           //     System.out.println("Elfogyott a pénzed.");
           // }

       // }


            r = rouletteEntry.getValue();

            for (Player player : luckyPack) {
                strategy = player.strategy();
                // System.out.println(strategy);
                //System.out.println(r);
                for (int j = 0; j < roulette.prizeList.size(); j++) {
                    if (strategy == j) {

                        prizeClass = new PrizeClass(roulette.prizeList.get(j).getName(), roulette.prizeList.get(j).getMultiplier(), roulette.prizeList.get(j).getOpposite());
                       // System.out.println(roulette.prizeList.get(j).getName()+" "+roulette.prizeList.get(j).getMultiplier()+" "+roulette.prizeList.get(j).getOpposite());
                    }
                }

                if (r.contains(prizeClass.getName())) {
                    player.setResult(player.getResult ()+(prizeClass.getMultiplier() - 1) *player.getMin());
                    player.setMin(player.betStrategy(true,player.getMin()));
                } else {
                    player.setResult(player.getResult()-(player.getMin() * (prizeClass.getMultiplier() - 1)));
                    player.setMin(player.betStrategy(false,player.getMin()));
                }

                System.out.println(player.getName()+" "+player.getResult());
                System.out.println(player.getMin());
            }

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

