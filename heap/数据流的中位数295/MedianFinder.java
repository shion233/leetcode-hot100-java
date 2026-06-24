package heap.数据流的中位数295;

import java.util.PriorityQueue;

class MedianFinder {
    /*
     * 做题思路：
     * - 数据流会不断加入新数字，如果每次都排序再取中位数成本太高，所以用两个堆动态维护中位数位置。
     * - maxHeap 是大顶堆，保存较小的一半数字，堆顶是较小一半里的最大值；minHeap 是小顶堆，保存较大的一半数字，堆顶是较大一半里的最小值。
     * - addNum 时，先根据 num 和 maxHeap.peek() 的关系决定放入哪一边，保证 maxHeap 中的数整体不大于 minHeap 中的数。
     * - 插入后如果两个堆大小差超过 1，就把元素较多一边的堆顶移动到另一边，让两个堆保持平衡。
     * - findMedian 时，如果某个堆元素更多，中位数就是该堆堆顶；如果两个堆大小相等，中位数就是两个堆顶的平均值。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的双堆解法，适合持续处理数据流。
     */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.add(num);
            return;
        }
        if(num <= maxHeap.peek()){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }

        if(maxHeap.size()-1>minHeap.size()){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size()-1>maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size()==0&&minHeap.size()==0) {
            return 0;
        }
        if(maxHeap.size()>minHeap.size()) {
            return maxHeap.peek();
        }else if(minHeap.size()>maxHeap.size()) {
            return minHeap.peek();
        }else  {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}
class test {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
