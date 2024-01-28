package com.sparkdevelopie.server.Model;

import com.sparkdevelopie.server.enumeration.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author sparkdevelopie
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message ="IP Address Cannot be Empty Or Null ")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;
}