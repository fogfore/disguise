import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int cur = s.nextInt();
            int gap = s.nextInt();
            pairs[i] = new Pair(cur, gap);
        }
        while (true) {
            int i1 = -1, i2 = -1;
            for (int i = 0; i < n; i++) {
                if (pairs[i].cur > 0) {
                    if (i1 == -1) {
                        i1 = i;
                    } else if (pairs[i].cur > pairs[i1].cur || (pairs[i].cur == pairs[i1].cur && pairs[i].gap > pairs[i1].gap)) {
                        i2 = i1;
                        i1 = i;
                    } else if (i2 == -1) {
                        i2 = i;
                    } else if (pairs[i].cur > pairs[i2].cur || (pairs[i].cur == pairs[i2].cur && pairs[i].gap > pairs[i2].gap)) {
                        i2 = i;
                    }
                }
            }
            if (i1 > -1) pairs[i1].cur = -1;
            if (i2 > -1) pairs[i2].cur = -1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (pairs[i].cur > 0) {
                    pairs[i].cur = Math.max(0, pairs[i].cur - pairs[i].gap);
                }
                if (pairs[i].cur > 0) {
                    count++;
                }
            }
            if (count < m) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(pairs[i].cur);
        }
    }

    static class Pair {
        int cur;
        int gap;

        Pair(int cur, int gap) {
            this.cur = cur;
            this.gap = gap;
        }
    }
}