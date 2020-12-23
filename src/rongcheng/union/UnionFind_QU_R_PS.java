package rongcheng.union;

/**
 * QuickUnion rank的优化 的路径分裂(Path Splitting)
 * <p>
 * 重写find即可
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R {

    protected UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangCheck(v);
        while (parents[v] != v) {//找到根节点
            //先保留父节点
            int p = parents[v];
            //v指向它的祖父节点
            parents[v] = parents[parents[v]];
            v = p;//不修改就漏了2->4->6...
        }
        return parents[v];
    }

}
