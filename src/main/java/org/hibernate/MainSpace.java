package org.hibernate;

import org.hibernate.config.HttpCall;
import org.hibernate.dao.*;
import org.hibernate.model.Iss;
import org.hibernate.model.SpaceResponse;

public class MainSpace {
    public static void main(String[] args) {

        try {
            String url = "http://api.open-notify.org/iss-now.json";
            SpaceResponse spaceResponse = HttpCall.sendGetRequest(url, SpaceResponse.class);

            System.out.println("Timestamp: " + spaceResponse.getTimestamp());
            System.out.println("Message: " + spaceResponse.getMessage());
            System.out.println("ISS Position:");
            System.out.println("  Longitude: " + spaceResponse.getIss_position().getLongitude());
            System.out.println("  Latitude: " + spaceResponse.getIss_position().getLatitude());


            SpaceResponse spaceResponse1 = new SpaceResponse();

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
