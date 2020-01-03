package two;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        LinkedList<Pair> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int cur = s.nextInt();
            int gap = s.nextInt();
            Pair pair = new Pair(cur, gap, i);
            list.add(pair);
        }
        int[] rst = new int[n];
        while (list.size() >= m) {
            Pair p1 = new Pair(0, 0, -1);
            Pair p2 = new Pair(0, 0, -1);
            for (Pair p : list) {
                if (p.cur > p1.cur) {
                    p2 = p1;
                    p1 = p;
                } else if (p.cur == p1.cur && p.gap > p1.gap) {
                    p1 = p;
                } else if (p.cur > p2.cur) {
                    p2 = p;
                } else if (p.cur == p2.cur && p.gap > p2.gap) {
                    p2 = p;
                }
            }
            if (p1.idx >= 0) rst[p1.idx] = -1;
            if (p2.idx >= 0) rst[p2.idx] = -1;
            list.remove(p1);
            list.remove(p2);
            for (Pair p : list) {
                p.cur = Math.max(p.cur - p.gap, 0);
            }
            Iterator<Pair> iterator = list.iterator();
            while (iterator.hasNext()) {
                Pair next = iterator.next();
                if (next.cur == 0) {
                    iterator.remove();
                    rst[next.idx] = 0;
                }
            }
        }
        for (int i = 0; i < rst.length; i++) {
            System.out.println(rst[i]);
        }
    }

    static class Pair {
        int cur;
        int gap;
        int idx;

        Pair(int cur, int gap, int idx) {
            this.cur = cur;
            this.gap = gap;
            this.idx = idx;
        }
    }
}
