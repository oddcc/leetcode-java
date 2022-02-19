// 605

package com.oddcc.leetcode.editor.cn;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new CanPlaceFlowers().new Solution();
        // System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        // System.out.println(solution.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        // System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        // System.out.println(solution.canPlaceFlowers(new int[]{0}, 1));
        System.out.println(solution.canPlaceFlowers(new int[]{0, 0, 1, 0}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            return validPlace(flowerbed, n, 0, flowerbed.length);
        }

        // 包含low，不包含high
        private boolean validPlace(int[] flowerbed, int n, int low, int high) {
            if (n == 0) return true;
            if (low >= high) return false; // 说明没有坑，长度为0，当然不能种了
            // 当有一个坑时，如果没有要种的花或这个坑可以种花且还有一个要种，则返回true，否则返回false
            if (low == high - 1) {
                return flowerbed[low] == 0 && n <= 1;
            }
            if (flowerbed[low] == 0) {
                if (flowerbed[low + 1] == 0) {
                    n--;
                    return validPlace(flowerbed, n, low + 2, high);
                }
                else {
                    return validPlace(flowerbed, n, low + 3, high);
                }
            }
            return validPlace(flowerbed, n, low + 2, high);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}