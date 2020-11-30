public class MartingelBela implements Player {
    String name = "Béla";
    int result;
    int min = 10;
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getResult() {
        return result;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public void setMin(int min) {
        this.min= min;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String strategy() {
        String st = "piros";
        return st;
    }

    @Override
    public int betStrategy(boolean winBefore, int bet) {
        if(!winBefore){
            bet *= 2;
        }else{
            bet = 10;
        }
        if (bet > 100){
            bet = 100;
        }
        return bet;
    }
}


