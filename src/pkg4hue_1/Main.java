package pkg4hue_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        String line = "";
        final String delimiter = ":";
        try {
            File f = new File("numbers.csv");
            FileReader fileReader = new FileReader(f);

            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                String[] token = line.split(delimiter);
                for (int i = 0; i < token.length; i++) {
                    String string = token[i];
                    try {
                        numbers.add(Integer.parseInt(string));
                    } catch (Exception e) {
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("chunks:");
        int chunks = Integer.parseInt(sc.nextLine());
        System.out.println("divider");
        int divider = Integer.parseInt(sc.nextLine());

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        List<Integer> chunksList = new ArrayList<>();
        int min = 0;
        int max = chunks;
        for (int i = 0; i < numbers.size() / chunks; i++) {
            for (int j = min; j < max; j++) {
                chunksList.add(numbers.get(j));
            }
            min += chunks;
            max += chunks;
            Thread t = new Thread(chunksList, divider);
            chunksList = new ArrayList<>();
            executor.execute(t);
        }
        executor.shutdown();
    }
}
