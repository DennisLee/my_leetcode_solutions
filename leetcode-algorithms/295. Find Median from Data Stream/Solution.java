/**
 * two priorityQueue solution
 * Time : O(logN)
 * Space: O(N)
 */

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;
    
    public MedianFinder() {
        larger = new PriorityQueue<>();
        smaller = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        larger.add(num);
        smaller.add(-larger.poll());
        
        if(larger.size() < smaller.size()){
            larger.add(-smaller.poll());   
        }
        
    }
    
    public double findMedian() {
        return (larger.size() + smaller.size()) % 2 == 0 ? (larger.peek() - smaller.peek())/2.0 : larger.peek();
    }
}