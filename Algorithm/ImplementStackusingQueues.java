// Idea:
// Using a single queue, for every push, shift the queue (n - 1) times such that the last element becomes the first element in the queue.
// e.g.
// push(1): q:[1]
// push(2): q:[1,2] -> [2,1]
// push(3): q:[2,1,3] -> [1,3,2] -> [3,2,1]
// push(4): q:[3,2,1,4] -> [2,1,4,3] -> [1,4,3,2] -> [4,3,2,1]
// Solution:
// Time complexity: 
// Push: O(n)
// Pop/top/empty: O(1)
// Space complexity: O(n)
class MyStack {
    private Queue<Integer> q_;
    /** Initialize your data structure here. */
    public MyStack() {
        q_ = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q_.offer(x);
        for (int i = 1; i < q_.size(); ++i) {
            q_.offer(q_.peek());
            q_.poll();
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int top = q_.peek();
        q_.poll();
        return top;
    }
    
    /** Get the top element. */
    public int top() {
        return q_.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q_.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
