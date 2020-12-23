package rongcheng.union;

/**
 * QuickUnion rank的优化 的路径减半(Path Halving)
 * <p>
 * 重写find即可
 */
public class UnionFind_QU_R_PH extends UnionFind_QU_R {

    protected UnionFind_QU_R_PH(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangCheck(v);
        while (parents[v] != v) {//找到根节点
            //v指向它的祖父节点
            parents[v] = parents[parents[v]];
            v = parents[v];// 1->3->5...
        }
        return parents[v];
    }

}
