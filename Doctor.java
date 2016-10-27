package com.bridgelabz.clinic;
import com.bridgelabz.clinic.Utility;
import java.util.Random;
import java.util.ArrayList;
class Doctor
{
    Utility u = new Utility();    
    int Id;
    String Specialization, Avalibility, Name;
    public Doctor()
    {
    }
    public Doctor(int Id, String Specialization, String Avalibility, String Name)
    {
        this.Id = Id;
        this.Specialization = Specialization;
        this.Avalibility = Avalibility;
        this.Name = Name;
    } 
    public void listDoctors(ArrayList<Doctor> doctors)
    {
        for(Doctor info :doctors)
        {
            System.out.println("Id: " + info.Id);
            System.out.println("Name: " + info.Name);
            System.out.println("Specialization: " + info.Specialization);
            System.out.println("Avalibility:"  + info.Avalibility);
        }
    }
    public void printDoctor(Doctor d)
    {
        System.out.println("Id: " + d.Id);
        System.out.println("Name: " + d.Name);
        System.out.println("Specialization: " + d.Specialization);
        System.out.println("Avalibility:"  + d.Avalibility);
    }
    public void searchByName(ArrayList<Doctor> doctors, String Name)
    {
        int count = 0;
        for(Doctor d : doctors)
        {
            if(Name.equals(d.Name))
            {
                this.printDoctor(d);
                count++;
            }

        }
        if(count == 0)
        {
            System.out.println("Sorry Doctor Not Available here");
        }
    }
    public void searchById (ArrayList<Doctor> doctors, int Id)
    {
        int count = 0;
        for(Doctor d : doctors)
        {
            if(Id == d.Id)
            {
                this.printDoctor(d);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("Sorry Doctor Not Available here");
        }
    }
    public void SearchByAvalaibility(ArrayList<Doctor> doctors, String Avalibility)
    {
        int count =0;
        for(Doctor d : doctors)
        {
            if(Avalibility.equals(d.Avalibility))
            {
                this.printDoctor(d);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("Sorry Doctor Not Available here");
        }
    }
    public void searchBySpecialization(ArrayList<Doctor> doctors, String Specialization)
    {
        int count =0;
        for(Doctor d : doctors)
        {
            if(Specialization.equals(d.Specialization))
            {
                this.printDoctor(d);
                count++;
            }
        }
        if(count == 0)
        {
            System.out.println("Sorry Doctor Not Available here");
        }
    }
    //boolean check = true;
    public void searchDoctor(ArrayList<Doctor> doctors) 
    {
        System.out.println("Please give 1.for search by name, 2. for search by id, 3. for search by availibility. 4. for search by      specialization, 5 for exit");
        int choice = u.inputInt();
        switch(choice)
        {
            case 1:
            {
                String name = u.inputString();
                this.searchByName(doctors, name);
                break;  
            }
            case 2:
            {
                int id = u.inputInt();
                this.searchById(doctors, id);
                break;  
            }
            case 3:
            {
                String avalibility = u.inputString();
                this.SearchByAvalaibility(doctors, avalibility);
                break;  
            }
            case 4:
            {
                String specialization = u.inputString();
                this.searchBySpecialization(doctors, specialization);
                break; 
            }

            default:
            {
               System.out.println("wrong choice");
               
            }

        }
    }
    public void popularDoc(ArrayList<Doctor> doctors)
    {
        Random r = new Random();
        int i = r.nextInt();
        System.out.println("Popular Doctor in hospital");
        this.searchById(doctors, i);
    }
    
}
