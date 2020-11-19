#include <assert.h>
#include <iostream>
#include <vector>

using namespace std;

class MinHeap {
public:
    // Return the min element.
	int peek() const { return data_[0]; }

    // Extract the min element.
    int pop() {
    	// Swap the min element with the last one. O(1)
    	swap(data_.back(), data_[0]);
    	// Get the min element. O(1)
    	int min_el = data_.back();
    	// Evict the min element. O(1)
    	data_.pop_back();
    	// Maintain heap property. O(logn)
	    heapifyDown(0);
	    return min_el;
    }

    // Add a new element to the heap.
    void push(int key) {
    	// Add the element to the end of the array. O(1)
    	data_.push_back(key);
    	// Maintain heap property. O(logn)
    	heapifyUp(data_.size() - 1);
    }
    // Return the size of the heap.
    int size() const { return data_.size(); }
private:
	void heapifyUp(int index) {
		// Stop at root.
		if (index == 0) return;
		int parent = (index - 1) / 2;
		// Stop if greater or equal to parent.
		if (data_[index] >= data_[parent]) return;
		// Swap with parent.
		swap(data_[index], data_[parent]);
		// Continue heapifyUp on parent.
		heapifyUp(parent);
	}

	void heapifyDown(int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		// Stop if has no left child.
		if (left >= data_.size()) return;
		// Get the min child.
		int min_child = 
		  right < data_.size() && data_[right] < data_[left] ? right : left;
		// Stop if less or equal to min child.
		if (data_[index] <= data_[min_child])
			return;
		// Swap with min child.
		swap(data_[index], data_[min_child]);
		// Continue heapifyDown on min_child.
		heapifyDown(min_child);
	}
    vector<int> data_;
};

int main() {
	vector<int> data{5,1,3,5,3,4,3,7};
	MinHeap heap;
	for (int x : data)
		heap.push(x);
	vector<int> output;
	while (heap.size())
		output.push_back(heap.pop());
	assert(output == vector<int>(1,3,3,3,4,5,5,7));
}
