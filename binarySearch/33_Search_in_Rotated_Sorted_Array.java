class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) { return -1; }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] >= nums[0]) {
                    if (target >= nums[0] && target < nums[mid]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[nums.length - 1]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }
        }
        if (target == nums[start]) { return start; }
        if (target == nums[end]) { return end; }
        return -1;    
    }
}
