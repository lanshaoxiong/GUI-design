/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persongui;

/**
 *
 * @author Shaoxiong Lan
 */

import java.io.Serializable;

/**
 *
 * @author Ray
 */
public class person implements Serializable{
    String Name;
    Address address;
    String PhonenumHome;
    String PhonenumWork;
    String Email;

    public person(String Name, Address address, String PhonenumHome, String PhonenumWork, String Email) {
        this.Name = Name;
        this.address = address;
        this.PhonenumHome = PhonenumHome;
        this.PhonenumWork = PhonenumWork;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhonenumHome() {
        return PhonenumHome;
    }

    public void setPhonenumHome(String PhonenumHome) {
        this.PhonenumHome = PhonenumHome;
    }

    public String getPhonenumWork() {
        return PhonenumWork;
    }

    public void setPhonenumWork(String PhonenumWork) {
        this.PhonenumWork = PhonenumWork;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    @Override
    public String toString() {
        return Name;
    }
}

class Address implements Serializable {
    String street;
    String city;
    String prov;
    String postal_code;

    public Address(String street, String city, String prov, String postal_code) {
        this.street = street;
        this.city = city;
        this.prov = prov;
        this.postal_code = postal_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    
}
