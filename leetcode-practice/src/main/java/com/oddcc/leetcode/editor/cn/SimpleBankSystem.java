// 2043

package com.oddcc.leetcode.editor.cn;

import java.util.Arrays;

public class SimpleBankSystem {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Bank {
        private long[] balance;

        public Bank(long[] balance) {
            this.balance = Arrays.copyOf(balance, balance.length);
        }

        public boolean transfer(int account1, int account2, long money) {
            if (!verifyAccount(account1) || !verifyAccount(account2)) {
                return false;
            }
            if (this.balance[account1 - 1] < money) {
                return false;
            }
            this.balance[account1 - 1] -= money;
            this.balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (!verifyAccount(account)) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        private boolean verifyAccount(int account) {
            return account >= 1 && account <= this.balance.length;
        }

        public boolean withdraw(int account, long money) {
            if (!verifyAccount(account)) {
                return false;
            }
            if (this.balance[account - 1] < money) {
                return false;
            }
            this.balance[account - 1] -= money;
            return true;
        }
    }

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
//leetcode submit region end(Prohibit modification and deletion)

}