package com.bridgelabz.clinic;
import java.io.File;
import java.lang.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgelabz.clinic.Doctor;
import com.bridgelabz.clinic.Utility;
class JSONDoctorData
{
    JSONParser parser = new JSONParser();
    File file = new File("Doctors.json");
    Doctor doctor1 = new Doctor();
    int id = 1;
    public Doctor readDoctFile(int y)
    {
        try
        {
            Object object = parser.parse(new FileReader(file));
            JSONObject docobj = (JSONObject)object;
            JSONArray docarr = (JSONArray)docobj.get("Doctors");
            JSONObject doctor = (JSONObject)docarr.get(y);

            Object obj1 = doctor.get("Name");
            String Name = (String)obj1;
           
            obj1 = doctor.get("Id");
            int Idinfo = Integer.parseInt(String.valueOf(obj1));

            obj1 = doctor.get("Specialization");
            String Specialization = (String)obj1;

            obj1 = doctor.get("Availability");
            String Availability = (String)obj1;
            doctor1 = new Doctor(Idinfo, Specialization,Availability, Name);
            return doctor1;

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return doctor1;
    }
    public int getList()
    {
        try
        {       
            Object object = parser.parse(new FileReader(file));
            JSONObject docobj = (JSONObject)object;
            JSONArray docarr = (JSONArray)docobj.get("Doctors");
            return docarr.size();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 1;
    }
}
