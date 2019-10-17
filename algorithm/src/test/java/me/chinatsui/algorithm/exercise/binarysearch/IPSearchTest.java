package me.chinatsui.algorithm.exercise.binarysearch;

import me.chinatsui.algorithm.exercise.binarysearch.IPSearch.IPLocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPSearchTest {

    private IPSearch ips;

    @Before
    public void setup() {
        IPLocation[] ipLocations = new IPLocation[]{
                new IPLocation("202.102.133.0", "202.102.133.255", "A"),
                new IPLocation("202.102.135.0", "202.102.136.255", "B"),
                new IPLocation("202.102.156.34", "202.102.157.255", "C"),
                new IPLocation("202.102.48.0", "202.102.48.255", "D"),
                new IPLocation("202.102.49.15", "202.102.133.255", "E"),
                new IPLocation("202.102.56.0", "202.102.133.255", "F"),
        };

        ips = new IPSearch(ipLocations);
    }

    @Test
    public void test() {
        Assert.assertEquals("D", ips.search("202.102.48.7"));
        Assert.assertEquals("B", ips.search("202.102.135.25"));
        Assert.assertEquals("A", ips.search("202.102.133.15"));
        Assert.assertEquals("C", ips.search("202.102.156.78"));
    }
}
