class Solution {

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    private int quickSelect(int[] nums, int low, int high, int target) {

        int pivot = partition(nums, low, high);

        if (pivot == target)
            return nums[pivot];

        if (pivot < target)
            return quickSelect(nums, pivot + 1, high, target);

        return quickSelect(nums, low, pivot - 1, target);
    }

    private int partition(int[] nums, int low, int high) {

        int pivot = nums[high];

        int i = low;

        for (int j = low; j < high; j++) {

            if (nums[j] <= pivot) {

                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, high);

        return i;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
