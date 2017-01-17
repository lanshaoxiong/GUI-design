/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persongui;

import java.io.Serializable;

/**
 *
 * @author shaoxiong Lan
 */

public class GraduateStudent extends UndergradStudent{
    person ThesisSupervior;
    Thesis myThesis;
    int ScholarShipAmount;
    String degreeType;

    public GraduateStudent(person ThesisSupervior, Thesis myThesis, int ScholarShipAmount, String degreeType, int YearRegistered, String DegreeProgram, int YearInProgram, float GPA, int TotalCredits, String newName, Address newAddress, String newPhoneHome, String newPhoneWork, String newEmail) {
        super(YearRegistered, DegreeProgram, YearInProgram, GPA, TotalCredits, newName, newAddress, newPhoneHome, newPhoneWork, newEmail);
        this.ThesisSupervior = ThesisSupervior;
        this.myThesis = myThesis;
        this.ScholarShipAmount = ScholarShipAmount;
        this.degreeType = degreeType;
    }

    public person getThesisSupervior() {
        return ThesisSupervior;
    }

    public Thesis getMyThesis() {
        return myThesis;
    }

    public int getScholarShipAmount() {
        return ScholarShipAmount;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setThesisSupervior(person ThesisSupervior) {
        this.ThesisSupervior = ThesisSupervior;
    }

    public void setMyThesis(Thesis myThesis) {
        this.myThesis = myThesis;
    }

    public void setScholarShipAmount(int ScholarShipAmount) {
        this.ScholarShipAmount = ScholarShipAmount;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }
    @Override
    public String toString() {
        return Name;
    }
           
}


class Thesis implements Serializable {
    String title;
    String area;

    public Thesis(String title, String area) {
        this.title = title;
        this.area = area;
    }

    public String getTitle() {
        return title;
    }

    public String getArea() {
        return area;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}