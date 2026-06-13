package binary_search.搜索二维矩阵74;

class Solution {
    /*
     * 做题思路：
     * - 当前解法利用题目中“每行有序，且下一行第一个数大于上一行最后一个数”的条件，把 m * n 的矩阵看成一个整体升序的一维数组。
     * - low 和 high 表示这个虚拟一维数组上的左右边界，mid / n 得到真实行号 row，mid % n 得到真实列号 col。
     * - 每次比较 matrix[row][col] 和 target：相等直接返回 true，偏小就移动 low，偏大就移动 high。
     * - 注释掉的旧代码是我最初的解法：先根据每行第一个元素定位 target 可能所在的 row，再在该行中二分。
     * - 旧解法虽然能做，但需要额外处理 row 的定位和 target 越界判断，边界更容易出错；当前解法只做一次标准二分，逻辑更统一。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//        if(matrix[0][0]==target){
//            return true;
//        }
//        int m = matrix.length, n = matrix[0].length;
//        int low = 0, high = n - 1;
//        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
//            return false;
//        }
//
//        int row = m - 1;
//
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] > target) {
//                row = i - 1;
//                break;
//            }
//        }
//
//        while (low <= high) {
//            int mid = (high + low) / 2;
//            if (matrix[row][mid] == target) {
//                return true;
//            }
//            if (matrix[row][mid] < target) {
//                low = mid + 1;
//            }
//            if (matrix[row][mid] > target) {
//                high = mid - 1;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        {1,3,5,7}, {10,11,16,20}, {23,30,34,60}
        int[][] matrix = new int[][]{{1}};
        System.out.println(s.searchMatrix(matrix, 0));
    }
}
