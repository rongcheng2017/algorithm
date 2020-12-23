package rongcheng.array;

/**
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class _977_SquaresofaSortedArray {

    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];
        int midIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                midIndex = i;
            }
            nums[i] = nums[i] * nums[i];
        }
        int zIndex = midIndex + 1;
        int cur = 0;
        while ( cur <nums.length) {
            if(midIndex<0){
                result[cur++] = nums[zIndex++];
            }else if(zIndex>=nums.length){
                result[cur++] = nums[midIndex--];
            }else if (nums[zIndex] > nums[midIndex]) {
                result[cur++] = nums[midIndex--];
            } else {
                result[cur++] = nums[zIndex++];

            }
        }
        return result;
    }
}
