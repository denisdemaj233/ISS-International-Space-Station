package org.hibernate.functionality;

import org.hibernate.config.HttpCall;
import org.hibernate.dao.NumberOfPeopleDao;
import org.hibernate.model.NumberOfPeople;
import org.hibernate.model.People;

import java.util.List;

public class NumberOfPeopleFunction {
    public static int numberOfPeopleInSpace(){
        try {

            String url = "http://api.open-notify.org/astros.json";


            NumberOfPeople numberOfPeople = HttpCall.sendGetRequest(url, NumberOfPeople.class);


            System.out.println("Number: " + numberOfPeople.getNumber());
            System.out.println("Message: " + numberOfPeople.getMessage());


            List<People> peopleList = numberOfPeople.getPeople();


            NumberOfPeople peoples = new NumberOfPeople();
            peoples.setMessage(numberOfPeople.getMessage());
            peoples.setNumber(numberOfPeople.getNumber());
            peoples.setPeople(peopleList);


            NumberOfPeopleDao numberOfPeopleDao = new NumberOfPeopleDao();
            numberOfPeopleDao.savePeopleInSpace(peoples);

            return numberOfPeople.getPeople().size();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
