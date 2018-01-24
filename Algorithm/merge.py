#
#Given two sorted integer arrays nums1 and nums2, merge num2 into num1 as one sorted array.
#Note:
#	You may assume that nums1 has enough space(size that is greater or equal to m+n) to hold additional elements from num2. The number of elements initialized in num1 and num2 are m and respectively
class Solution(object):
	def merge(self, nums1, m, nums2, n):
		if not nums1 or not nums2: return
		while m > 0 and n > 0:
			if nums1[m - 1] >= nums2[n - 1]:
			   nums1[m + n - 1] = nums1[m - 1]
			   m -= 1
			else:
				nums1[m + n - 1] = nums2[n - 1]
				n -= 1
		if n > 0:
			nums1[:n] = nums2[:n]
			
			
			
#First Missing Positive
#Give an unsorted integer array, find the first missing positive integer.
#Your algorithm should run in O(n) time and uses constant space.


class Solution(object):
	def firstMissingPositive(self, nums):
		if not nums: return 1
		max_num = len(nums) + 1
		num_set = set(nums)
		for i in range(1, max_num):
			if i not in num_set:
				return i
#	    return max_num
	
	def twoSum(self, nums, target):
		numIndexDict = {}
		for i, x in enumerate(nums):
			y = target - x
			if y in numIndexDict:
				return (numIndexDict[y], i)
			numIndexDict[x] = i;
			
	def isValid(self, s):
		stack = []
		for char in s:
			if char == "[" or char == "(" or char == "{":
				stack.append(char)
			else: 
				if not self.check_adjust_stack(stack, char):
					return False
		return not stack
		
	def check_adjust_stack(self, stack, char):
		if not stack:
			return False
		if (char == "]" and stack[-1] == "[") or (char == ")" and stack[-1] == "(") or (char == "}" and stack[-1] == "{"):
			return True
		return False

    def isValidd(self, s):
	    braces_dict = {'[':']','(':')','{':'}'}
	    stack = []
        for char in s:
	        if char in braces_dict.keys():
		       stack.append(braces_dict[char])
		     else:
			    if stack and stack[-1] == char:
				   stack.pop()
				else:
					return False
		return not stack
		
		def sortColor(self, nums):
			if not nums: return
			count = [0] * 3
			for i, x in enumerate(nums):
				has_key = x
				count[has_key] += 1
			index = 0
			for i, x in enumerate(count):
				for _ in range(x):
					nums[index] = i
		            index += 1 
		     print(nums)
	    

	

		