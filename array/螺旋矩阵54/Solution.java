package array.螺旋矩阵54;

import java.util.LinkedList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 用 top、bottom、left、right 四个边界表示当前还没有遍历的矩形。
     * - 每一圈按从左到右、从上到下、从右到左、从下到上的顺序收集元素。
     * - 每走完一条边就收缩对应边界，并在遍历前判断边界是否仍然有效。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        int r=matrix.length;
        int c=matrix[0].length;
        int top = 0, bottom = r-1, left = 0, right = c-1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom){
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right){
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
//    {1,2,3},{4,5,6},{7,8,9}
    public static void main(String[] args) {
        List<Integer> list = new Solution().spiralOrder(new int[][]{{3},{2}});
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
//    public List<Integer> spiralOrder(int[][] matrix) {
//        LinkedList<Integer> res = new LinkedList<Integer>();
//        int r=matrix.length;
//        int c=matrix[0].length;
//        int rt = 0;
//        int ct = 0;
//        boolean rflag=true;
//        boolean lflag=false;
//        boolean uflag=false;
//        boolean dflag=false;
//        int ir=0;
//        int ic=0;
////        System.out.println(r+" "+c);
//        int count=r*c;
//        while(count>0){
//            res.add(matrix[ir][ic]);
//            count--;
//            if(rflag){
//                if (++ic<c){
////                    System.out.println(ic);
//                }else {
//                    --ic;
//                    rflag=false;
//                    dflag=true;
//                    c--;
//                }
//            }
//            if(dflag){
//                if(++ir<r){
//                }else {
//                    --ir;
//                    dflag=false;
//                    lflag=true;
//                    r--;
//                }
//            }
//            if(lflag){
//                if(--ic>=ct){
//                }else  {
//                    ++ic;
//                    lflag=false;
//                    uflag=true;
//                    ct++;
//                }
//            }
//            if(uflag){
//                if(--ir>rt){
//                }else  {
//                    ++ir;
//                    uflag=false;
//                    rflag=true;
//                    rt++;
//                }
//            }
//
//        }
//        return res;
//    }
}
