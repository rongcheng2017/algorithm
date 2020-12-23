package rongcheng.array;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 */
public class _75_SortColors {
    public void sortColors(int[] nums) {
        int cur =0;
        //记录红色即0的位置，0放前面，所以从0开始
        int redIndex = 0;
        //记录蓝色即2的位置。2放尾部，所以其实值是length-1
        int blueIndex = nums.length-1;

        //当blueIndex<cur时，说明cur后面的值都是2了。没有必须再继续了。
        //需要注意的是 blueIndex==cur时不能结束。需要再判断下。
        while (cur <= blueIndex) {
            if (nums[cur]==0){
                //拿到0，将其放到redIndex位置，并且redIndex++，cur++。
                swap(nums,cur++,redIndex++);
            }else if (nums[cur]==1){
                //拿到1，不动 cur++。
                cur++;
            }else{
                //拿到2，blueIndex--，注意cur不能动，因为换回来的值还需要再判断一下，即重新走上面的流程。
                swap(nums,cur,blueIndex--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
