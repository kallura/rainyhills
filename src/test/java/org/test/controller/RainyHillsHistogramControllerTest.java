package org.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.test.service.RainyHillsHistogram;

/**
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
public class RainyHillsHistogramControllerTest {

    private RainyHillsHistogramController rainyHillsHistogramController;
    private RainyHillsHistogram rainyHillsHistogram;

    @Before
    public void init() {
        rainyHillsHistogramController = new RainyHillsHistogramController();
        rainyHillsHistogram = mock(RainyHillsHistogram.class);
        rainyHillsHistogramController.setRainyHillsHistogram(rainyHillsHistogram);
    }

    @Test
    public void compute() {
        int[] data = {3, 2, 4, 1, 2};
        rainyHillsHistogramController.setData(data);
        when(rainyHillsHistogram.computeWaterVolume(data)).thenReturn(2);

        rainyHillsHistogramController.compute();

        assertEquals("The volume is 2", 2, rainyHillsHistogramController.getVolume());
        verify(rainyHillsHistogram, times(1)).computeWaterVolume(data);
        verifyNoMoreInteractions(rainyHillsHistogram);
    }
}