package com.bridgelabz.clinic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgelabz.clinic.Patient;
class JSONPatientData
{
    int Age, Id =1;
    String MobNo, Name;
    JSONParser parser = new JSONParser();
    File file = new File("Patients.json");
    Patient patient1 = new Patient();
    JSONObject object = new JSONObject();
    JSONArray patientarr = new JSONArray();
    public int getList()
    {
        try
        {
            Object obj = parser.parse(new FileReader(file));
            JSONObject patientobj = (JSONObject)obj;
            JSONArray patientarr = (JSONArray)patientobj.get("Patients");
            return patientarr.size();
        }
        catch(Exception e)
        {
			System.out.println(e);
		}
		return 1;
    }
    
    public Patient readFile(int y)
    {
        try
        {
            Object obj = parser.parse(new FileReader(file));
            JSONObject patientobj = (JSONObject)obj;
            JSONArray patientarr = (JSONArray)patientobj.get("Patients");
            
            JSONObject patient = (JSONObject)patientarr.get(y);
            Object object = patient.get("Name");
            String name = (String)object;
            object = patient.get("MonNo");
            String mobno = (String)object;
            object = patient.get("Age");
		    int age = Integer.parseInt(String.valueOf(object));	
		    object = patient.get("ID");
		    int Id = Integer.parseInt(String.valueOf(object));
            object = patient.get("doctID");
		    int doctId = Integer.parseInt(String.valueOf(object));
            Patient patient1 = new Patient(Id,mobno,age, name, doctId);
            return patient1;
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
        
       return patient1;  
  }
    public void writeIntoFile(Patient patientInfo)
    
    {
        JSONObject obj = new JSONObject();
        patientarr.add(obj);
        obj.put("Name",patientInfo.Name);
        obj.put("MobNo", patientInfo.MobNo);
        obj.put("Age",patientInfo.Age);
        obj.put("Id",patientInfo.Id);
        obj.put("doctId",patientInfo.doctId);
        Id++;
        object.put("Patient",patientarr);
        try
        {
            FileWriter writefile = new FileWriter(file);
            writefile.write(obj.toJSONString());
            writefile.flush();
            writefile.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    } 
}

