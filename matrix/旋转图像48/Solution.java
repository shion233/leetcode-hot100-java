package matrix.旋转图像48;

class Solution {
    /*
     * 做题思路：
     * - 顺时针旋转 90 度可以拆成两个原地操作：先沿主对角线转置，再逐行反转。
     * - 转置把 matrix[i][j] 和 matrix[j][i] 交换，行反转把每一行左右对调。
     * - 注释掉的代码是我最初使用额外矩阵的解法，结果正确但不符合原地旋转要求；
     *   当前写法只用常数额外空间。
     */
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left=0,right=n-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] r = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        solution.rotate(r);
        int n=r.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(r[i][j]+" ");
            }
            System.out.println();
        }
    }
//不符合题意，没有原地旋转
//    public void rotate(int[][] matrix) {
//        int n=matrix.length;
//        int[][] res=new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i][j]=matrix[i][j];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[j][n-i-1]=res[i][j];
//            }
//        }
//    }
}
