package matrix.搜索二维矩阵II240;


//真正想考察的解法，是从右上角（或左下角）开始，一次排除一行或一列，做到 O ( m + n ) O(m+n) 的时间，且不需要二分查找。
class Solution {
    /*
     * 做题思路：
     * - 当前代码从右上角开始搜索，因为这个位置向左变小、向下变大。
     * - 如果当前值小于 target，就下移排除当前行；如果大于 target，就左移排除当前列。
     * - 注释掉的代码是我最初对每一行做二分的思路，也能做，但没有充分利用列有序；
     *   当前写法每次排除一行或一列，复杂度是 O(m + n)。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag=false;
        int m=matrix.length,n=matrix[0].length;
        int row=0,col=n-1;
        while (row<m&&col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return  flag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));
    }


//    public boolean searchMatrix(int[][] matrix, int target) {
//        boolean flag=false;
//        int m=matrix.length,n=matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            flag=binarySearch(matrix[i],target);
//            if(flag==true){
//                break;
//            }
//        }
//        return  flag;
//    }
//    boolean binarySearch(int[] matrix,int target){
//        boolean flag=false;
//        int low=0,high=matrix.length-1;
//        while (low<=high){
//            int mid=(low+high)/2;
//            if(target<matrix[mid]){
//                high=mid-1;
//            }
//            else if(target>matrix[mid]){
//                low=mid+1;
//            }
//            else{
//                return true;
//            }
//        }
//        return flag;
//    }
}
