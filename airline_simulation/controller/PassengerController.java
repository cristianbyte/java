package controller;

import entity.Passenger;
import model.PassengerModel;

import javax.swing.*;
import java.util.List;

public class PassengerController {

    PassengerModel objPatientModel = new PassengerModel();

    private String creatingQuestion( String message,String title){
        return JOptionPane.showInputDialog(null,
                message,
                title,
                JOptionPane.QUESTION_MESSAGE
                );
    }

    public void create() {

        Passenger objPassenger = new Passenger();

        String name = creatingQuestion("Name: ","Creating Patient");
        objPassenger.setName(name);
        String lastName = creatingQuestion("Last Name: ","Creating Patient");
        objPassenger.setLast_name(lastName);
        String birth_date = JOptionPane.showInputDialog("Enter your date of birth: yyyy-mm-dd");
        while (!birth_date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            birth_date = JOptionPane.showInputDialog("Please enter a valid date: yyyy-mm-dd");
        }
        objPassenger.setBirth_date(birth_date);
        //ALL EYES ON ME! ↓↓↓↓↓↓ Be careful ↓↓↓↓↓↓
        String identity = JOptionPane.showInputDialog("Enter your identity: ");
        while (!identity.matches("\\d+")) {
            identity = JOptionPane.showInputDialog("Please enter a valid number:");
        }
        objPassenger.setIdentity(identity);

        objPassenger = (Passenger) this.objPatientModel.create(objPassenger);

        JOptionPane.showMessageDialog(null, objPassenger.toString());
  }

    public void getAll(){
        String list = this.getAll(objPatientModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List listObject){
        StringBuilder list = new StringBuilder("List Patients: \n");
        for(Object obj : listObject){
            Passenger objCoder = (Passenger) obj;
            list.append(objCoder.toString()).append("\n");
        }
        return list.toString();
    }

    public void update(){
        String listPatient = this.getAll(this.objPatientModel.findAll());

        int idUpdated = Integer.parseInt(JOptionPane.showInputDialog(listPatient + "\n Enter the ID to edit."));

        Passenger objPassenger = (Passenger) this.objPatientModel.findById(idUpdated);

        if(objPassenger == null){
            JOptionPane.showMessageDialog(null,"Patient not found.");
        }else{
            String name = JOptionPane.showInputDialog(null,"Enter patient name:", objPassenger.getName());
            String lastName = JOptionPane.showInputDialog(null, "Enter patient last name:", objPassenger.getLast_name());
            String birth_date = JOptionPane.showInputDialog(null,"Enter birth date's patient:", objPassenger.getBirth_date());
            while (!birth_date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                birth_date = JOptionPane.showInputDialog(null,"Please enter a valid date: yyyy-mm-dd");
            }

            String identity = JOptionPane.showInputDialog(null,"Enter patient identity:", objPassenger.getIdentity());
            while (!identity.matches("\\d+")) {
                identity = JOptionPane.showInputDialog("Please enter a valid number:");
            }

            objPassenger.setName(name);
            objPassenger.setLast_name(lastName);
            objPassenger.setBirth_date(birth_date);
            objPassenger.setIdentity(identity);

            this.objPatientModel.update(objPassenger);
        }
    }

    public void delete(){
        String listPatient = this.getAll(this.objPatientModel.findAll());

        int confirm;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listPatient + "Enter the ID to delete"));
        Passenger objPassenger = (Passenger) this.objPatientModel.findById(idDelete);

        if(objPassenger == null){
            JOptionPane.showMessageDialog(null,"Patient not found.");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"Sure? You want to delete this patient? \n"+ objPassenger.toString(), "Deleting Patient",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION){
                this.objPatientModel.delete(objPassenger);
            }
        }
    }
}
