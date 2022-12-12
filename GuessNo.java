package com.leetcode;

public class GuessNo {
    public static void main(String[] args) {
        System.out.println(new GuessNo().guessNumber(2126753390));
    }

    private int guess(int n) {
        if (n == 1702766719) {
            return 0;
        } else if (n > 1702766719) {
            return -1;
        } else {
            return 1;
        }
    }

    public int guessNumber(int n) {
        return guessNumberHelper(n);
    }

    public int guessNumberHelper(int n) {
        long low = 1;
        long high = n;

        while (low <= high) {
            long mid = (low + high) / 2;

            System.out.println(mid);

            int value = guess((int)mid);

            if (value == 0) {
                return (int)mid;
            } else if (value == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 1;
    }
}
