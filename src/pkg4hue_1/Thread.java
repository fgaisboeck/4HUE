package pkg4hue_1;

import java.util.List;

public class Thread implements Runnable {

    private List<Integer> chunk;
    private int divider;

    public Thread(List<Integer> chunk, int divider) {
        this.chunk = chunk;
        this.divider = divider;
    }

    public Thread() {
    }

    @Override
    public void run() {
        for (int i = 0; i < chunk.size(); i++) {
            Integer get = chunk.get(i);
            if (get % divider == 0) {
                System.out.println(get);
            }
        }
    }
}
