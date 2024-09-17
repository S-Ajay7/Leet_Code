/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int res = binarySearch(mountainArr, target, 0, peak);
        if (res != -1) {
            return res;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    static int findPeak(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int binarySearch(MountainArray mountainArr, int target, int start, int end) {
        boolean isASC = true;
        if (mountainArr.get(start) > mountainArr.get(end)) {
            isASC = false;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (isASC) {
                if (mountainArr.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (mountainArr.get(mid) > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}