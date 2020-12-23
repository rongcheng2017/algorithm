package rongcheng.union;

public class UnionFind_QF extends UnionFind{

    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    /**
     * 查找当前元素的父元素
     *
     * @param element 当前元素
     * @return 父元素
     */
    public int find(int element) {
        rangCheck(element);
        return parents[element];
    }



    /**
     * 将元素v1所在的组合并到元素v2所在的组中
     *
     * @param v1 元素
     * @param v2 元素
     *           其实就是修改他们的父元素
     */
    public void union(int v1, int v2) {
        int parent1 = find(v1);
        int parent2 = find(v2);
        if (parent1 == parent2) return;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == parent1) {
                parents[i] = parent2;
            }
        }
    }
}
