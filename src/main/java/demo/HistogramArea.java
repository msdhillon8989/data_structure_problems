package demo;

import java.util.Stack;

public class HistogramArea {


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 3,5,1};
        System.out.println(getMaxArea(arr));
    }

    private static int getMaxArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= arr.length; i++) {

            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] > arr[i])) {
                int top = stack.pop();
                int area = 0;
                if (stack.isEmpty()) {
                    area = arr[top] * i;

                } else {
                    area = arr[top] * (i - stack.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            stack.push(i);

        }
        return maxArea;
    }
}

