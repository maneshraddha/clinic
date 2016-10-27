package com.bridgelabz.clinic;
import com.bridgelabz.clinic.Doctor;
import com.bridgelabz.clinic.Patient;
import com.bridgelabz.clinic.ArrangeAppointment;
import com.bridgelabz.clinic.JSONDoctorData;
import com.bridgelabz.clinic.JSONPatientData;
import com.bridgelabz.clinic.Utility;
import java.util.ArrayList;
import java.util.regex.Pattern;
class clinicManagementProgram
{
    public static void main(String args[])
    {
        Utility u = new Utility();
        int patientId = 1;
        ArrayList<Doctor> doctor = new ArrayList();
        ArrayList<Patient> patient = new ArrayList();
        JSONDoctorData docdata = new JSONDoctorData();
        JSONPatientData patientdata = new JSONPatientData();
        ArrangeAppointment appointment = new ArrangeAppointment();
        for(int i=0; i<docdata.getList(); i++)
        {
            Doctor doctors = docdata.readDoctFile(i);
            doctor.add(doctors);
        }
        for(int i=0;i<patientdata.getList();i++)
        {
            Patient patients = patientdata.readFile(i);
            appointment.takeAppointment(patients);
            patient.add(patients);
        }
        for(int i=0;i<patient.size();i++)
        {
			patientdata.writeIntoFile(patient.get(i));
		}

		//Display Options to perform operations.
		boolean check = true;
		while(check){
			System.out.println("\n\nWelcome, Please choose Your Option");
			System.out.println("1.Doctors List\n2.Patients List\n3.Search Doctor\n4.Search Patient");
			System.out.println("5.Take Appoinment\n6.Show All Appointments\n7.Popular Doctor \n8.Exit");
			int choice = u.inputInt();			
			switch(choice)
            {
				case 1:
                {
					System.out.println("List Of Available Doctors:");
					new Doctor().listDoctors(doctor);
					break;
				}
				case 2:
                {
					System.out.println("List of Patients in Clinic:");
					new Patient().listPatient(patient);
					break;
				}
				
				case 3:
                {
					System.out.println("Search Doctor By:");
					new Doctor().searchDoctor(doctor);
					break;
				}
				case 4:
                {
					System.out.println("Search Patient By:");
					Patient pati = new Patient();
                    pati.searchPatient(patient);
					break;
				}
				case 5:
                {
					//taking patient's info and appointment
					System.out.print("Please Enter Patient's Name: ");
					String name = u.inputString();
					System.out.print("Please Enter Phone number: ");
					String number = u.inputString();
					boolean checkNumber = Pattern.matches("[789]{1}\\d{9}",number);
					if(!checkNumber)
                    {
						System.out.println("Number is incorrect");
						break;
						
					}
					patientId++;
					System.out.print("Please Enter Age: ");
					int age = u.inputInt();
					System.out.print("Please enter Doctors id: ");
					int docId = u.inputInt();
					Patient newPatient = new Patient(patientId, number,age,name,docId);
					patient.add(newPatient);
					int size = patient.size();
					appointment.takeAppointment(newPatient);
					patientdata.writeIntoFile(patient.get(size-1));//data write into file
					break;
				}
				case 6:
                {
					appointment.showAppointment();
					break;
				}
		
				case 7:
                {
					Doctor doc = new Doctor();
                    doc.popularDoc(doctor);
					break;
				}
				case 8:
                {
					check = false;
					break;
				}
				default:
                {
					System.out.println("Wrong Choice!!");
					break;
				}
			}//end of switch
		}//end of while
        
    }
}
