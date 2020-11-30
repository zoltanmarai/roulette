public class RandomRudolf implements Player{
    String name = "Rudolf";
    int result;
    int min = 10;


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
        this.min = min;
    }

    @Override
    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String strategy() {
        String st = "piros";
        int random = (int)(Math.random() * 2);
        if(random == 0) {
            st = "piros";
        }
        else {
            st = "fekete";
        }
        return st;
    }

    @Override
    public int betStrategy(boolean winBefore,int bet) {
        double r = Math.random();
        if (r >= 0.5) {
            bet = 20;
        }
        return bet;
    }
}
