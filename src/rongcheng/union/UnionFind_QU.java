package rongcheng.union;

public class UnionFind_QU extends UnionFind {

    protected UnionFind_QU(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int element) {
        rangCheck(element);
        while (element != parents[element]) {
            element = parents[element];
        }
        return element;
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
        //将根节点的元素的值 改成v2根节点
        parents[p1] = p2;
    }
}
