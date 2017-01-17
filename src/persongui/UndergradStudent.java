/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persongui;

/**
 *
 * @author shaoxiong Lan
 */


public class UndergradStudent extends person {
    int YearRegistered;
    String DegreeProgram;
    int YearInProgram;
    float GPA;
    int TotalCredits;

    /**
     *
     * @param YearRegistered
     * @param DegreeProgram
     * @param YearInProgram
     * @param GPA
     * @param TotalCredits
     * @param newName
     * @param newAddress
     * @param newPhoneHome
     * @param newPhoneWork
     * @param newEmail
     */
    public UndergradStudent(int YearRegistered, String DegreeProgram, int YearInProgram, float GPA, int TotalCredits, String newName, Address newAddress, String newPhoneHome, String newPhoneWork, String newEmail) {
        super(newName, newAddress, newPhoneHome, newPhoneWork, newEmail);
        this.YearRegistered = YearRegistered;
        this.DegreeProgram = DegreeProgram;
        this.YearInProgram = YearInProgram;
        this.GPA = GPA;
        this.TotalCredits = TotalCredits;
    }

    public int getYearRegistered() {
        return YearRegistered;
    }
    
    public String getDegreeProgram() {
        return DegreeProgram;
    }

    public int getYearInProgram() {
        return YearInProgram;
    }

    public float getGPA() {
        return GPA;
    }

    public int getTotalCredits() {
        return TotalCredits;
    }

    public void setYearRegistered(int YearRegistered) {
        this.YearRegistered = YearRegistered;
    }

    public void setDegreeProgram(String DegreeProgram) {
        this.DegreeProgram = DegreeProgram;
    }

    public void setYearInProgram(int YearInProgram) {
        this.YearInProgram = YearInProgram;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public void setTotalCredits(int TotalCredits) {
        this.TotalCredits = TotalCredits;
    }

    @Override
    public String toString() {
        return Name;
    }
    
    

}
