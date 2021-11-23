package pkg4hue_2;

import java.util.concurrent.Callable;

public class Thread implements Callable<Integer> {

    int min;
    int max;

    public Thread(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Thread() {
    }

    @Override
    public Integer call() throws Exception {
        int erg = 0;
        for (int i = min; i <= max; i++) {
            erg += i;
        }
        return erg;
    }
}
