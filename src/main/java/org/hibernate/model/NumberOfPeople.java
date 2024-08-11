package org.hibernate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class NumberOfPeople extends BaseModel{


    private int number;
    private String message;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "number_of_people_id")
    private List<People> people;


}
