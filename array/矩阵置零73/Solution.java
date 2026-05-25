package array.矩阵置零73;

class Solution {
    /*
     * 做题思路：
     * - 先扫描矩阵，记录哪些行和列需要被置零。
     * - 第二次遍历时，只要当前位置所在行或列被标记，就把它改成 0。
     * - 这种写法逻辑直观，用额外数组换取实现上的清晰。
     */
    public void setZeroes(int[][] matrix) {
        int[] r = new int[matrix.length];
        int[] c = new int[matrix[0].length];
//        System.out.println(r.length+" "+c.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (r[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (c[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
