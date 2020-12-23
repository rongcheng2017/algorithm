package rongcheng.union;

/**
 * QuickUnion rank的优化 的路径压缩(Path Compression)
 * <p>
 * 重写find即可
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R {

    protected UnionFind_QU_R_PC(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangCheck(v);
        if (parents[v] != v) {
            parents[v] = find(parents[v]);
        }
        //路径压缩后 v和parents[v]不一样了
        return parents[v];
    }

}
