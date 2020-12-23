package rongcheng.array;

/**
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，
 * 若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * 示例：
 * <p>
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 * <p>
 * 0 <= len(array) <= 1000000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题_16_16_部分排序 {

    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};
        // 从左往右

        // 默认第一个值是最大值。
        int max = array[0];
        //记录最右边逆序值的位置
        int right = -1;

        //开始扫描
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                right = i;
            }
        }

        //说明是升序了，后面可以结束。
        if (right == -1) {
            return new int[]{-1, -1};
        }

        //从右往左

        //默认最后一个值是最小值
        int min = array[array.length - 1];
        //记录最左边逆序值的位置
        int left = -1;

        //开始扫描
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                left = i;
            }
        }


        return new int[]{left, right};
    }
}
