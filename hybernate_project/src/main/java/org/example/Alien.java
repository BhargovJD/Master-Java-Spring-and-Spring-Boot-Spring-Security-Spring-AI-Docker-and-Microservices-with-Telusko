
package org.example;
// Defines the package where the Alien class belongs.

import jakarta.persistence.Entity;
// Imports the Entity annotation to mark this class as a Hibernate entity.

import jakarta.persistence.Id;
// Imports the Id annotation to identify the primary key.

import jakarta.persistence.Table;
// Imports the Table annotation to specify the database table name.

import jakarta.persistence.Column;
// Imports the Column annotation to specify database column names.

@Entity(name = "AlienEntity")
// Tells Hibernate this class is an entity.
// "AlienEntity" is the entity name used in Hibernate queries.

@Table(name = "alien_details")
// Maps this Java class to the database table named alien_details.

public class Alien {
// Defines a public Java class named Alien.

    @Id
    // Marks this field as the primary key.

    @Column(name = "alien_id")
    // Maps the aid field to the database column alien_id.
    private int aid;
    // Stores the alien's ID as an integer.

    @Column(name = "alien_name")
    // Maps the aname field to the database column alien_name.
    private String aname;
    // Stores the alien's name as a String.

    @Column(name = "technology")
    // Maps the tech field to the database column technology.
    private String tech;
    // Stores the alien's technology as a String.

    public int getAid() {
        // Getter method that returns the alien's ID.
        return aid;
        // Returns the current value of aid.
    }

    public void setAid(int aid) {
        // Setter method that accepts a new alien ID.
        this.aid = aid;
        // Assigns the parameter value to the object's aid field.
    }

    public String getAname() {
        // Getter method that returns the alien's name.
        return aname;
        // Returns the current value of aname.
    }

    public void setAname(String aname) {
        // Setter method that accepts a new alien name.
        this.aname = aname;
        // Assigns the parameter value to the object's aname field.
    }

    public String getTech() {
        // Getter method that returns the alien's technology.
        return tech;
        // Returns the current value of tech.
    }

    public void setTech(String tech) {
        // Setter method that accepts a new technology.
        this.tech = tech;
        // Assigns the parameter value to the object's tech field.
    }

    @Override
    // Indicates that this method overrides a method from the parent class.

    public String toString() {
        // Returns a readable text representation of the Alien object.
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
        // Combines the field names and values into one String.
    }
    // Ends the toString() method.

}
// Ends the Alien class.
