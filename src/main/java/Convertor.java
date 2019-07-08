/*
 * Copyright (c) 2019-present unTill Pro, Ltd. and Contributors
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */


public class Convertor {
    private static final boolean DEBUG = false;
    private static final int lowMask = (1 << (Integer.SIZE / 2)) - 1; // 0000...01...1111
    private static final int hiMask = -1 - lowMask;                // 1111...10...0000

    public static Cracked crack(int value) {
        int lowVal = value & lowMask;
        int hiVal = (value & hiMask) >> Integer.SIZE / 2;
        if (DEBUG) {
            printMask((short) hiVal);
            printMask((short) lowVal);
        }
        return new Cracked((short) hiVal, (short) lowVal);
    }

    public static int uncrack(Cracked cracked) {
        int hiVal = ((int) (cracked.hi) << (Integer.SIZE / 2));
        int lowVal = ((int) cracked.low) & cracked.low & lowMask;
        if (DEBUG) {
            printMask(hiVal);
            printMask(lowVal);
        }
        return hiVal + lowVal;
    }

    protected static void printMask(short x) {
        printMask(x, Short.SIZE);
    }

	protected static void printMask(int x) {
        printMask(x, Integer.SIZE);
    }

    private static void printMask(int x, int typeSize) {
        System.out.print(x + ": ");
        for (int i = typeSize - 1; i >= 0; i--) {
            if ((x & (1 << i)) != 0) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }
        System.out.println();
    }
}
