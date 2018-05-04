package org.test.service;

import javax.ejb.Remote;

/**
 * The rainy hills histogram is implementing an algorithm to compute the volume of water
 * it could hold in case of rainy weather. The algorithm takes O(N) time and O(N) memory
 *
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
@Remote
public interface RainyHillsHistogram {

    /**
     * The method takes an array as an input and calculates the volume of water
     *
     * @param data is input array describes profile of a surface
     * @return volume of water
     */
    int computeWaterVolume(int[] data);
}
