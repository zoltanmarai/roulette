public class RandomRudolf implements Player{
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
    public int betStrategy(boolean winBefore) {
        return 0;
    }
}
