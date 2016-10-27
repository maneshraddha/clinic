package com.bridgelabz.clinic;
import com.bridgelabz.clinic.Utility;
import java.util.Random;
import java.util.ArrayList;
class Patient
{
    Utility u = new Utility();
    int Id, Age, doctId;
    String Name, MobNo;
    public Patient()
    {
    }
    public Patient(int Id, String MobNo, int Age, String Name, int doctId)
    {
        this.Id = Id;
        this.MobNo = MobNo;
        this.Age = Age;
        this.Name = Name;
        this.doctId = doctId;
    }
    public void printPatient(Patient p)
    {
        System.out.println("Name is: " + p.Name);
        System.out.println("Id is: " + p.Id);
        System.out.println("MobNo is: " + p.MobNo);
        System.out.println("Age is: " + p.Age);
    }
    public void listPatient(ArrayList<Patient> patients)
    {
        for(Patient info : patients)
        {
            System.out.println("Name is: " + info.Name);
            System.out.println("Id is: " + info.Id);
            System.out.println("MobNo is: " + info.MobNo);
            System.out.println("Age is: " + info.Age);
            
        }
    }
    public void searchById( ArrayList<Patient>patients, int Id)
    {
        int count = 0;
        for(Patient p :patients)
        {
            if(Id ==p.Id )
            {
               printPatient(p);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("No such patient");
        }
    }
    public void searchByAge( ArrayList<Patient>patients, int Age)
    {
        int count = 0;
        for(Patient p :patients)
        {
            if(Age ==p.Age )
            {
               printPatient(p);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("No such patient");
        }
    }
    public void searchByMobNo( ArrayList<Patient>patients, String MobNo)
    {
        int count = 0;
        for(Patient p :patients)
        {
            if(MobNo ==p.MobNo)
            {
               printPatient(p);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("No such patient");
        }
    }
    public void searchByName( ArrayList<Patient>patients, String Name)
    {
        int count = 0;
        for(Patient p :patients)
        {
            if(Name.equals(p.Name))
            {
               printPatient(p);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("No such patient");
        }
    }
    public void searchPatient(ArrayList<Patient> patients)   
    {
        System.out.println("Select patient you eant");
        System.out.println("Press 1. for id. 2. for name, 3. for age. 4. mobile number");
        int choice = u.inputInt();
        switch(choice)
        {
            case 1:
            {
                System.out.println("select id you want");
                int id = u.inputInt();
                this.searchById(patients, id);
                break; 
            }
            case 2:
            {
                System.out.println("select name you want");
                String name= u.inputString();
                this.searchByName(patients, name);
                break; 
            }
            case 3:
            {
                System.out.println("select age you want");
                int age = u.inputInt();
                this.searchById(patients,age);
                break; 
            }
            case 4:
            {
                System.out.println("select mobile number you want");
                String mobno = u.inputString();
                this.searchByMobNo(patients,mobno);
                break; 
            }
            default:
            {
                 System.out.println("Wrong choice");
            }

        }
        
    }
}
