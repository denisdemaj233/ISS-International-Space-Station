package org.hibernate;

import org.hibernate.dao.*;
import org.hibernate.httpcalls.HttpClientCalls;

import java.util.UUID;

public class MainSpace {
    public static void main(String[] args) {

        try {
            SpaceResponse spaceResponse = HttpClientCalls.getSpace();
            System.out.println("Timestamp: " + spaceResponse.getTimestamp());
            System.out.println("Message: " + spaceResponse.getMessage());
            System.out.println("ISS Position:");
            System.out.println("  Longitude: " + spaceResponse.getIss_position().getLongitude());
            System.out.println("  Latitude: " + spaceResponse.getIss_position().getLatitude());


            SpaceResponse spaceResponse1 = new SpaceResponse();
            //spaceResponse1.setId(UUID.randomUUID().toString());
            spaceResponse1.setMessage(spaceResponse.getMessage());
            spaceResponse1.setTimestamp(spaceResponse.getTimestamp());

            Iss iss= new Iss();
            iss.setLatitude(spaceResponse.getIss_position().getLatitude());
            iss.setLongitude(spaceResponse.getIss_position().getLongitude());

            spaceResponse1.setIss_position(iss);

            SpaceDao spaceDao = new SpaceDao();
            spaceDao.saveSpace(spaceResponse1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}
