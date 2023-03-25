package ua.goit.vic.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SQLReader {
    public static String fileReader (String file_path){
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            while (br.ready()) {
                sb.append(br.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
