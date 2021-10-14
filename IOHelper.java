package misc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOHelper {

    public static List<String> readFile(String pathname){

        BufferedReader br;
        List<String> fileContent = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(pathname));

            while(br.ready()){
                var line = br.readLine();
                fileContent.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;

    }

    public static List<String> readFile(String pathname, int numberOfLines){

        BufferedReader br;
        List<String> fileContent = new ArrayList<>();
        int index = 0;

        try {
            br = new BufferedReader(new FileReader(pathname));

            while(br.ready() && index < numberOfLines){
                var line = br.readLine();
                fileContent.add(line);
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;

    }

    public static void writeFile(String filepath, String line){
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath, true);
            fw.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
