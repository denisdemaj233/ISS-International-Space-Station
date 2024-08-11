package org.hibernate.dao;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SpaceResponse {
    @Id
    private int id;
    private Long timestamp;
    private String message;
    private Iss iss_position;

}

