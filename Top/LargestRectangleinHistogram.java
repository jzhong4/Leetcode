//1. 暴力搜索O(n^3) 2. 暴力搜索加最大高度O(n^2) 3. Stack，维持一个升序的Stack，因为bar的面积，受到左右两个小的bar的影响。pop大的bar,计算面积。最后结尾也要清空Stack计算面积。面积公式宽度两次不同。
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxArea = 0;
        for(int i  = 0; i < heights.length; i++){ 
           while(stack.peek() != -1 && heights[i] < heights[stack.peek()]){
               maxArea = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), maxArea);
           }
           stack.push(i);
        }
        
        while(stack.peek() != -1){
            maxArea = Math.max(heights[stack.pop()] * (heights.length - stack.peek() - 1), maxArea);
        }
        return maxArea;
    }
}