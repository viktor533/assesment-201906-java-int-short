/*
 * Copyright (c) 2019-present unTill Pro, Ltd. and Contributors
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

import org.junit.Assert;
import org.junit.Test;

public class ConvertorTest {

    @Test
    public void borderOneTest() {
        int value = 1;
        Assert.assertEquals(value, Convertor.uncrack(Convertor.crack(value)));
    }

    @Test
    public void borderZeroTest() {
        int value = 0;
        Assert.assertEquals(value, Convertor.uncrack(Convertor.crack(value)));
    }

    @Test
    public void borderMaxMaskTest() {
        int value = -1;
        Assert.assertEquals(value, Convertor.uncrack(Convertor.crack(value)));
    }

    @Test
    public void borderMaxIntTest() {
        int value = Integer.MAX_VALUE;
        Assert.assertEquals(value, Convertor.uncrack(Convertor.crack(value)));
    }

    @Test
    public void borderMinIntTest() {
        int value = Integer.MIN_VALUE;
        Assert.assertEquals(value, Convertor.uncrack(Convertor.crack(value)));
    }

    @Test
    public void overRangeMagnitudeTest() {
        int stepCost = 123;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE - stepCost; i += stepCost)
            Assert.assertEquals(i, Convertor.uncrack(Convertor.crack(i)));
    }
}
