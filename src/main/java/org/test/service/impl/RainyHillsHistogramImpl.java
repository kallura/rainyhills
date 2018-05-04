package org.test.service.impl;

import org.test.service.RainyHillsHistogram;

import javax.ejb.Stateless;

/**
 * (non-Javadoc)
 *
 * @author Kseniia Orlenko
 * @version 4/29/18
 * @see org.test.service.RainyHillsHistogram
 */
@Stateless
public class RainyHillsHistogramImpl implements RainyHillsHistogram {

    /**
     * (non-Javadoc)
     *
     * @see org.test.service.RainyHillsHistogram#computeWaterVolume(int[])
     */
    public int computeWaterVolume(int[] data) {
        int volume = 0;
        int[] leftMaxes = new int[data.length];
        int leftMax = data[0];
        for (int i = 0; i < data.length; i++) {
            leftMax = Math.max(leftMax, data[i]);
            leftMaxes[i] = leftMax;
        }
        int rightMax = data[data.length - 1];
        for (int i = data.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, data[i]);
            int nextMax = Math.min(rightMax, leftMaxes[i]);
            if (nextMax > data[i]) {
                volume += nextMax - data[i];
            }
        }
        return volume;
    }
}
