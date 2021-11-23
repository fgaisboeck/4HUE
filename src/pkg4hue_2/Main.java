package pkg4hue_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);
        System.out.println("n: ");
        int n = Integer.parseInt(sc.nextLine());

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);

        int h = n / 100;
        int erg = 0;
        for (int i = 1; i < h * 100; i += 100) {
            Thread t = new Thread(i, i + 99);
            Future<Integer> submit = executor.submit(t);
            int zwischenerg = submit.get().intValue();
            erg += zwischenerg;

        }
        System.out.println("Sum: " + erg);
        executor.shutdown();
    }

}
