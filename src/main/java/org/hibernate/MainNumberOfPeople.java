package org.hibernate;

import org.hibernate.config.HttpCall;
import org.hibernate.dao.NumberOfPeopleDao;
import org.hibernate.model.NumberOfPeople;
import org.hibernate.model.People;

public class MainNumberOfPeople {
    public static void main(String[] args) {

        try {
            String url = "http://api.open-notify.org/astros.json";
            NumberOfPeople numberOfPeople = HttpCall.sendGetRequest(url, NumberOfPeople.class);

            System.out.println("Craft: " + numberOfPeople.getPeople().getCraft());
            System.out.println("Name: " + numberOfPeople.getPeople().getName());
            System.out.println("Number:" + numberOfPeople.getNumber());
            System.out.println("Message: " + numberOfPeople.getMessage());

            NumberOfPeople peoples = new NumberOfPeople();

            peoples.setMessage(numberOfPeople.getMessage());
            peoples.setNumber(numberOfPeople.getNumber());

            People astronaut = new People();
            astronaut.setCraft(numberOfPeople.getPeople().getCraft());
            astronaut.setCraft(numberOfPeople.getPeople().getName());

            peoples.setPeople(astronaut);

            NumberOfPeopleDao numberOfPeopleDao = new NumberOfPeopleDao();
            numberOfPeopleDao.savePeopleInSpace(peoples);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
