package _16_io_text_file.practices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumNumberInFile {
    private static final String path="Module2/src/main/java/_16_io_text_file/practices/number.txt";
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line="";
            int sum=0;
            while ((line= bf.readLine())!=null){
                sum+= Integer.parseInt(line);
            }
            bf.close();
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
