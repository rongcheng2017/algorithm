package rongcheng.union;

/**
 * QuickUnion size的优化
 */
public class UnionFind_QU_S extends UnionFind_QU {

    private int sizes[];

    protected UnionFind_QU_S(int capacity) {
        super(capacity);
        sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            sizes[i] = 1;
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

        if (sizes[p1] < sizes[p2]) {
            //p1作为根节点的树size小于 p2作为根节点的树的size 将根节点的元素的值 改成v2根节点
            parents[p1] = p2;
            //p2的size增加
            sizes[p2] += sizes[p1];
        } else {
            //与上面的想反
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        }
    }
}
