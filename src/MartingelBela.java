public class MartingelBela implements Player {

    @Override
    public String strategy() {
        String st = "piros";
        return st;
    }

    @Override
    public int betStrategy(boolean winBefore) {
        int bet = 1;
        if(!winBefore){
            bet *= 2;
        }
        return bet;
    }
}


