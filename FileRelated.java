import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileRelated {
    public Map<Integer, List<String>> parse(String fileName) { //讀入diary.txt
        Map<Integer, List<String>> diary = new TreeMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] entries = line.split("\\s+");
                int date = Integer.parseInt(entries[0]);
                String schedule = entries[1];

                diary.computeIfAbsent(date, k -> new ArrayList<String>()).add(schedule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diary;
    }

    public void create(String accountName) { //創建對應的diary.txt
        File accListFile = new File(accountName + ".txt");
        try {
            accListFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
