import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Roulette {
    public  Map<Integer, String> numbersFeatures;

    public Roulette() {

    }

    public Map<Integer, String> getNumbersFeatures() {
        return numbersFeatures;
    }

    public Map.Entry<Integer,String> spin(){

      int result = (int)(Math.random()*37);
      Set<Map.Entry<Integer,String>> rouletteEntries = numbersFeatures.entrySet();
        for (Map.Entry<Integer, String> rouletteEntry : rouletteEntries) {
            if(rouletteEntry.getKey()== result){
                return rouletteEntry;
            }
        }
      return null;
    }
    public void fillMap(){

        numbersFeatures = new TreeMap<>();
        numbersFeatures.put(0,"zöld");
        numbersFeatures.put(1,"piros,páratlan,1.harmad,1.fél,1.oszlop");
        numbersFeatures.put(2,"fekete,páros,1.harmad,1.fél,2.oszlop");
        numbersFeatures.put(3,"piros,páratlan,1.harmad,1.fél,3.oszlop");
        numbersFeatures.put(4,"fekete,páros,1.harmad,1.fél,1.oszlop");
        numbersFeatures.put(5,"piros,páratlan,1.harmad,1.fél,2.oszlop");
        numbersFeatures.put(6,"fekete,páros,1.harmad,1.fél,3.oszlop");
        numbersFeatures.put(7,"piros,páratlan,1.harmad,1.fél,1.oszlop");
        numbersFeatures.put(8,"fekete,páros,1.harmad,1.fél,2.oszlop");
        numbersFeatures.put(9,"piros,páratlan,1.harmad,1.fél,3.oszlop");
        numbersFeatures.put(10,"fekete,páros,1.harmad,1.fél,1.oszlop");
        numbersFeatures.put(11,"fekete,páratlan,1.harmad,1.fél,2.oszlop");
        numbersFeatures.put(12,"piros,páros,1.harmad,1.fél,3.oszlop");

        numbersFeatures.put(13,"fekete,páratlan,2.harmad,1.fél,1.oszlop");
        numbersFeatures.put(14,"piros,páros,2.harmad,1.fél,2.oszlop");
        numbersFeatures.put(15,"fekete,páratlan,2.harmad,1.fél,3.oszlop");
        numbersFeatures.put(16,"piros,páros,2.harmad,1.fél,1.oszlop");
        numbersFeatures.put(17,"fekete,páratlan,2.harmad,1.fél,2.oszlop");
        numbersFeatures.put(18,"piros,páros,2.harmad,1.fél,3.oszlop");
        numbersFeatures.put(19,"piros,páratlan,2.harmad,2.fél,1.oszlop");
        numbersFeatures.put(20,"fekete,páros,2.harmad,2.fél,2.oszlop");
        numbersFeatures.put(21,"piros,páratlan,2.harmad,2.fél,3.oszlop");
        numbersFeatures.put(22,"fekete,páros,2.harmad,2.fél,1.oszlop");
        numbersFeatures.put(23,"piros,páratlan,2.harmad,2.fél,2.oszlop");
        numbersFeatures.put(24,"fekete,páros,2.harmad,2.fél,3.oszlop");

        numbersFeatures.put(25,"piros,páratlan,3.harmad,2.fél,1.oszlop");
        numbersFeatures.put(26,"fekete,páros,3.harmad,2.fél,2.oszlop");
        numbersFeatures.put(27,"piros,páratlan,3.harmad,2.fél,3.oszlop");
        numbersFeatures.put(28,"fekete,páros,3.harmad,2.fél,1.oszlop");
        numbersFeatures.put(29,"fekete,páratlan,3.harmad,2.fél,2.oszlop");
        numbersFeatures.put(30,"piros,páros,3.harmad,2.fél,3.oszlop");
        numbersFeatures.put(31,"fekete,páratlan,3.harmad,2.fél,1.oszlop");
        numbersFeatures.put(32,"piros,páros,3.harmad,2.fél,2.oszlop");
        numbersFeatures.put(33,"fekete,páratlan,3.harmad,2.fél,3.oszlop");
        numbersFeatures.put(34,"piros,páros,3.harmad,2.fél,1.oszlop");
        numbersFeatures.put(35,"fekete,páratlan,3.harmad,2.fél,2.oszlop");
        numbersFeatures.put(36,"piros,páros,3.harmad,2.fél,3.oszlop");
    }
}
