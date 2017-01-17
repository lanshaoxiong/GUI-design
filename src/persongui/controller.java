/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persongui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.DefaultListModel;

/**
 *
 * @author shaoxiong lan
 */
public class controller {
  
    public static final String FILE_NAME_NORMAL = "infomation_normal.txt";
    public static final String FILE_NAME_UN = "infomation_undergraduate.txt";
    public static final String FILE_NAME_GRAD = "infomation_graduate.txt";
    
    DefaultListModel<person> listModel_normal;
    DefaultListModel<UndergradStudent> listModel_underGra;
    DefaultListModel<GraduateStudent> listModel_graduate;
    
    Lock lock = new ReentrantLock();
    
    controller(DefaultListModel<person> newlistModel_normal, DefaultListModel<UndergradStudent> newlistModel_underGra, DefaultListModel<GraduateStudent> newlistModel_graduate){
        listModel_normal = newlistModel_normal;
        listModel_underGra = newlistModel_underGra;
        listModel_graduate = newlistModel_graduate;       
    }
    
    void CreatePerson(String newName, Address address, String phone_home, String phone_work, String email){
        try{
            lock.lock();
            person newPerson = new person(newName,address,phone_home,phone_work,email);
            listModel_normal.addElement(newPerson);
        }
        finally{
            lock.unlock();
        }
    }
    
    void CreateUnderStudent(int YearRegistered, String DegreeProgram, int YearInProgram, float GPA, int TotalCredits,String newName, Address address, String phone_home, String phone_work, String email){
        try{
            lock.lock();
            UndergradStudent newUnderStudent = new UndergradStudent(YearRegistered, DegreeProgram, YearInProgram, GPA, TotalCredits,newName,address,phone_home,phone_work,email);
            listModel_underGra.addElement(newUnderStudent);
        }
        finally{
            lock.unlock();
        }
    }
    
    void CreateGradStudent(person ThesisSupervior, Thesis myThesis, int ScholarShipAmount, String degreeType,int YearRegistered, String DegreeProgram, int YearInProgram, float GPA, int TotalCredits,String newName, Address address, String phone_home, String phone_work, String email){
        try{
            lock.lock();
            GraduateStudent newGraStudent = new  GraduateStudent(ThesisSupervior, myThesis, ScholarShipAmount, degreeType,YearRegistered, DegreeProgram, YearInProgram, GPA, TotalCredits,newName,address,phone_home,phone_work,email);
            listModel_graduate.addElement(newGraStudent);
            listModel_normal.addElement(ThesisSupervior);
            
        }
        finally{
            lock.unlock();
        }
    }
    
void UpdatePerson(String newName, Address newAddress, String newPhoneHome, String newPhoneWork, String newEmail,int index){
        try{
            lock.lock();
            person temp = listModel_normal.get(index);
            temp.setName(newName);
            temp.setAddress(newAddress);
            temp.setPhonenumHome(newPhoneHome);
            temp.setPhonenumWork(newPhoneWork);
            temp.setEmail(newEmail);
            listModel_normal.setElementAt(temp, index);
        }
        finally{
            lock.unlock();
        }
    }
    
    void UpdateUndergraStu(int YearRegistered, String DegreeProgram, int YearInProgram, float GPA, int TotalCredits, String newName, Address newAddress, String newPhoneHome, String newPhoneWork, String newEmail, int index) {
        try {
            lock.lock();
            UndergradStudent temp = listModel_underGra.get(index);
            temp.setYearRegistered(YearRegistered);
            temp.setDegreeProgram(DegreeProgram);
            temp.setYearInProgram(YearInProgram);
            temp.setGPA(GPA);
            temp.setTotalCredits(TotalCredits);
            temp.setName(newName);
            temp.setAddress(newAddress);
            temp.setPhonenumHome(newPhoneHome);
            temp.setPhonenumWork(newPhoneWork);
            temp.setEmail(newEmail);
            listModel_underGra.setElementAt(temp, index);
        } finally {
            lock.unlock();
        }
    }    
    void UpdateGradStu(person ThesisSupervior, Thesis myThesis, int ScholarShipAmount, String degreeType,int YearRegistered, String DegreeProgram, int YearInProgram, float GPA, int TotalCredits, String newName, Address newAddress, String newPhoneHome, String newPhoneWork, String newEmail, int index) {
        try {
            lock.lock();
            GraduateStudent temp = listModel_graduate.get(index);
            temp.setThesisSupervior(ThesisSupervior);
            temp.setMyThesis(myThesis);
            temp.setScholarShipAmount(ScholarShipAmount);
            temp.setDegreeType(degreeType);
            temp.setYearRegistered(YearRegistered);
            temp.setDegreeProgram(DegreeProgram);
            temp.setYearInProgram(YearInProgram);
            temp.setGPA(GPA);
            temp.setTotalCredits(TotalCredits);
            temp.setName(newName);
            temp.setAddress(newAddress);
            temp.setPhonenumHome(newPhoneHome);
            temp.setPhonenumWork(newPhoneWork);
            temp.setEmail(newEmail);
            listModel_graduate.setElementAt(temp, index);
        } finally {
            lock.unlock();
        }
    }
    

    void delete(int index, int list_flag){
        try{
            lock.lock();
            if(list_flag == 1)
                listModel_normal.removeElementAt(index);
            else if(list_flag == 2)
                listModel_underGra.removeElementAt(index);
            else if(list_flag == 3)
                listModel_graduate.removeElementAt(index);
            else ;
        }        
        finally{
            lock.unlock();
        }
    }  
    
    void readFromFile() throws IOException, ClassNotFoundException{
        ObjectInputStream is_normal = new ObjectInputStream(new FileInputStream(FILE_NAME_NORMAL));
        DefaultListModel<person> inObject_normal =  (DefaultListModel<person>) is_normal.readObject();
        is_normal.close();
        while(!inObject_normal.isEmpty()){
            listModel_normal.addElement(inObject_normal.remove(0));
        }
        
        ObjectInputStream is_underGrad = new ObjectInputStream(new FileInputStream(FILE_NAME_UN));
        DefaultListModel<UndergradStudent> inObject_underGrad =  (DefaultListModel<UndergradStudent>) is_underGrad.readObject();
        is_underGrad.close();
        while(!inObject_underGrad.isEmpty()){
            listModel_underGra.addElement(inObject_underGrad.remove(0));
        }
        
        ObjectInputStream is_grad = new ObjectInputStream(new FileInputStream(FILE_NAME_GRAD));
        DefaultListModel<GraduateStudent> inObject_graduate =  (DefaultListModel<GraduateStudent>) is_grad.readObject();
        is_grad.close();
        while(!inObject_graduate.isEmpty()){
            listModel_graduate.addElement(inObject_graduate.remove(0));
        }
    }
    
    void writeToFile() throws IOException{
        ObjectOutputStream os_normal = new ObjectOutputStream(new FileOutputStream(FILE_NAME_NORMAL));
        os_normal.writeObject(listModel_normal);
        os_normal.close();
        
        ObjectOutputStream os_underGrad = new ObjectOutputStream(new FileOutputStream(FILE_NAME_UN));
        os_underGrad.writeObject(listModel_underGra);
        os_underGrad.close();
        
        ObjectOutputStream os_grad = new ObjectOutputStream(new FileOutputStream(FILE_NAME_GRAD));
        os_grad.writeObject(listModel_graduate);
        os_grad.close();
    }
    

    
}
