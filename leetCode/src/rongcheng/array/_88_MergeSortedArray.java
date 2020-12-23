package rongcheng.array;

/**
 * 88. 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 *  
 * <p>
 * 提示：
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //num1起始取值的位置
        int num1Index = m-1;
        //num2起始取值的位置
        int num2Index = n-1;
        //当前已经存储到的位置
        int cur = n + m -1;

        //num2取完直接结束
        while (num2Index>=0) {
            //num1先取完，就需要将num2剩余的都挨个取出放入num1剩余位置。
            if (num1Index>=0&&nums1[num1Index] > nums2[num2Index]) {
                nums1[cur--] = nums1[num1Index--];
            } else {
                nums1[cur--] = nums2[num2Index--];
            }
        }
    }

}
