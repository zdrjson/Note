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
			