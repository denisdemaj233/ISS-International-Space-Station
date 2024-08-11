package org.hibernate.httpcalls;

import org.hibernate.dao.SpaceResponse;

public class MainCall {
    public static void main(String[] args) {
        try {
            SpaceResponse spaceResponse = HttpClientCalls.getSpace();
            System.out.println("Timestamp: " + spaceResponse.getTimestamp());
            System.out.println("Message: " + spaceResponse.getMessage());
            System.out.println("ISS Position:");
            System.out.println("  Longitude: " + spaceResponse.getIss_position().getLongitude());
            System.out.println("  Latitude: " + spaceResponse.getIss_position().getLatitude());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
