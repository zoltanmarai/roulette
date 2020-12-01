public interface Player {


    public int strategy();

    public int betStrategy(boolean winBefore, int bet);


    void setResult(int result);
    public String getName();

    int getResult();

    int getMin();

    void setMin(int min);
}
