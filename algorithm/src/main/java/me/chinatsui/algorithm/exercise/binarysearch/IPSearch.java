package me.chinatsui.algorithm.exercise.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a data set of IP range, each range represents a country region in the world.
 * Now input an IP, indicate which country does it belong to.
 * <p>
 * Example:
 * A - [202.102.133.0, 202.102.133.255]
 * B - [202.102.135.0, 202.102.136.255]
 * C - [202.102.156.34, 202.102.157.255]
 * D - [202.102.48.0, 202.102.48.255]
 * E - [202.102.49.15, 202.102.51.251]
 * F - [202.102.56.0, 202.102.56.255]
 * <p>
 * Input IP: 202.102.56.76, returns F.
 */
public class IPSearch {

    private Map<Long, String> startIPCountryMap;
    private long[] sortedStartIPs;

    public IPSearch(IPLocation[] ipLocations) {
        if (ipLocations == null || ipLocations.length < 1) {
            throw new IllegalArgumentException();
        }

        int n = ipLocations.length;
        startIPCountryMap = new HashMap<>(n);
        sortedStartIPs = new long[n];

        int i = 0;
        for (IPLocation ipLocation : ipLocations) {
            Long ipInt = toLong(ipLocation.start);
            sortedStartIPs[i++] = ipInt;
            startIPCountryMap.putIfAbsent(ipInt, ipLocation.country);
        }

        Arrays.sort(sortedStartIPs);
    }

    public String search(String ip) {
        long target = toLong(ip);
        int n = sortedStartIPs.length;
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mi = lo + ((hi - lo) >> 1);
            if (sortedStartIPs[mi] <= target) { // last ip start less than or equals to target
                if (mi == n - 1 || sortedStartIPs[mi + 1] > target) {
                    return startIPCountryMap.get(sortedStartIPs[mi]);
                } else {
                    lo = mi + 1;
                }
            } else {
                hi = mi - 1;
            }
        }

        return null;
    }

    private long toLong(String ip) {
        String[] splits = ip.split("\\.");
        return (long) (Math.pow(2, 24) * Integer.parseInt(splits[0])
                + Math.pow(2, 16) * Integer.parseInt(splits[1])
                + Math.pow(2, 8) * Integer.parseInt(splits[2])
                + Integer.parseInt(splits[3]));
    }

    static class IPLocation {
        String start;
        String end;
        String country;

        IPLocation(String start, String end, String country) {
            this.start = start;
            this.end = end;
            this.country = country;
        }
    }
}
