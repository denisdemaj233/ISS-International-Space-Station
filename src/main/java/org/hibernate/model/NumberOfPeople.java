package org.hibernate.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class NumberOfPeople extends BaseModel{

    private People people;
    private int number;
    private String message;

}
