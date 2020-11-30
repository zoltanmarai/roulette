public class PrizeClass {

    private String name;
    private int multiplier;
    private String opposite;

    public PrizeClass( String name,int multiplier,String opposite ) {
        this.name = name;
        this.multiplier = multiplier;
        this.opposite = opposite;
    }

    public String getName() {
        return name;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public String getOpposite() {
        return opposite;
    }
}
