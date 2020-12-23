package rongcheng.union;

/**
 * QuickUnion rank的优化
 */
public class UnionFind_QU_R extends UnionFind_QU {

    private int ranks[];

    protected UnionFind_QU_R(int capacity) {
        super(capacity);
        ranks = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            ranks[i] = 1;
        }
    }

    /**
     * 将v1的根节点指向v2的根节点位置，从而实现合并
     *
     * @param v1 元素
     * @param v2 元素
     */
    @Override
    public void union(int v1, int v2) {
        //找到根节点
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        if (ranks[p1] < ranks[p2]) {
            //p1作为根节点的树高度小于 p2作为根节点的树的高度
            parents[p1] = p2;
            //矮的嫁接到高的 高的高度不用改动
        } else if (ranks[p1] > ranks[p2]) {
            //与上面的想反
            parents[p2] = p1;
        } else {
            //两个数的高度一样，树的高度+1,谁合并到谁无所谓，主要是高度别加错
            parents[p1] = p2;
            ranks[p2]++;
        }
    }
}
