package org.test.controller;

import org.test.service.RainyHillsHistogram;

import javax.ejb.EJB;
import java.io.Serializable;

/**
 * Managed bean for rainyHills.xhtml
 *
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
public class RainyHillsHistogramController implements Serializable {

    private RainyHillsHistogram rainyHillsHistogram;
    private int[] data;
    private int volume;

    @EJB
    public void setRainyHillsHistogram(RainyHillsHistogram rainyHillsHistogram) {
        this.rainyHillsHistogram = rainyHillsHistogram;
    }

    public void compute() {
        volume = rainyHillsHistogram.computeWaterVolume(data);
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int[] getData() {
        return data;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
