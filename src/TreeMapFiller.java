import java.io.*;
import java.lang.StringBuilder;
import java.util.TreeMap;

public class TreeMapFiller {
        private StringBuilder word = new StringBuilder();
        private final TreeMap<StringBuilder, Integer> data = new TreeMap();
        private int totalCounter;
        private final int firstInput = 1;

    public void read(String fileName) {
        try(FileReader reader = new FileReader(fileName)){
            int sym;
            while ((sym = reader.read()) != -1){
                if(Character.isDigit((char) sym) || Character.isLetter((char) sym)) {
                    word.append((char) sym);
                }
                else if (!(word.isEmpty())){
                    filler(word);
                    word = new StringBuilder();
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
        
    private void filler(StringBuilder word) {
            Integer currentValue = data.putIfAbsent(word, firstInput);
            if(currentValue != null)
                data.put(word, currentValue + 1);
            totalCounter++;
        }

    public Map<StringBuilder, Integer> getTreeMap(){
        return data;
    }
    public int getTotalCounter(){
        return totalCounter;
    }
}
