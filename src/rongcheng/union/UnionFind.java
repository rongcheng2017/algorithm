package rongcheng.union;

public abstract class UnionFind {

    protected int[] parents;

    protected UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >0");
        }
        parents = new int[capacity];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;//每个元素的父元素是自己
        }
    }

    /**
     * 查找当前元素的父元素
     *
     * @param element 当前元素
     * @return 父元素
     */
    public abstract int find(int element);

    /**
     * 判断这两个元素是否在一组，父元素相同认为是一组
     *
     * @param v1 元素1
     * @param v2 元素2
     * @return 是否为一组
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /**
     * 将元素v1所在的组合并到元素v2所在的组中
     *
     * @param v1 元素
     * @param v2 元素
     *           其实就是修改他们的父元素
     */
    public abstract void union(int v1, int v2);

    protected void rangCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
