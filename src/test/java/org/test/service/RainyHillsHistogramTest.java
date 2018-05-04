package org.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

/**
 * @author Kseniia Orlenko
 * @version 4/29/18
 */
public class RainyHillsHistogramTest {

    private static EJBContainer ejbContainer;
    private RainyHillsHistogram rainyHillsHistogram;

    @BeforeClass
    public static void startTheContainer() {
        ejbContainer = EJBContainer.createEJBContainer();
    }

    @Before
    public void lookupABean() throws NamingException {
        Object object = ejbContainer.getContext()
                .lookup("java:global/rainyhills/RainyHillsHistogramImpl");

        assertTrue(object instanceof RainyHillsHistogram);

        rainyHillsHistogram = (RainyHillsHistogram) object;
    }

    @AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

    @Test
    public void computeWaterVolume2() {

        int[] surfaceProfile = new int[] {3, 2, 4, 1, 2};

        int waterVolume = rainyHillsHistogram.computeWaterVolume(surfaceProfile);

        assertEquals("The volume of water should be 2", 2, waterVolume);
    }

    @Test
    public void computeWaterVolume8() {

        int[] surfaceProfile = new int[] {4, 1, 1, 0, 2, 3};

        int waterVolume = rainyHillsHistogram.computeWaterVolume(surfaceProfile);

        assertEquals("The volume of water should be 8", 8, waterVolume);
    }

    @Test
    public void computeWaterVolume10() {

        int[] surfaceProfile = new int[] {4, 1, 1, 0, 0, 3};

        int waterVolume = rainyHillsHistogram.computeWaterVolume(surfaceProfile);

        assertEquals("The volume of water should be 10", 10, waterVolume);
    }


    @Test
    public void computeWaterVolume25() {

        int[] surfaceProfile = new int[] {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5};

        int waterVolume = rainyHillsHistogram.computeWaterVolume(surfaceProfile);

        assertEquals("The volume of water should be 25", 25, waterVolume);
    }
}