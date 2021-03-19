// 1603

package com.oddcc.leetcode.editor.cn;

public class DesignParkingSystem {
    public static void main(String[] args) {
        DesignParkingSystem obj = new DesignParkingSystem();
        obj.test();
    }

    private void test() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1)); // return true because there is 1 available slot for a big car
        System.out.println(parkingSystem.addCar(2)); // return true because there is 1 available slot for a medium car
        System.out.println(parkingSystem.addCar(3)); // return false because there is no available slot for a small car
        System.out.println(parkingSystem.addCar(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ParkingSystem {
        // 其实是个计数器
        private int[] count;

        public ParkingSystem(int big, int medium, int small) {
            count = new int[4];
            count[1] = big;
            count[2] = medium;
            count[3] = small;
        }

        public boolean addCar(int carType) {
            if (count[carType] > 0) {
                count[carType]--;
                return true;
            }
            return false;
        }
    }

    /**
     * Your ParkingSystem object will be instantiated and called as such:
     * ParkingSystem obj = new ParkingSystem(big, medium, small);
     * boolean param_1 = obj.addCar(carType);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}