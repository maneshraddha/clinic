package com.bridgelabz.clinic;
import com.bridgelabz.clinic.Patient;
import com.bridgelabz.clinic.clinicNode;
class ArrangeAppointment
{
    String []docName ={ "Dr. Shirish","Dr. Sandhya", "Dr. Girish", "Dr. Suman", "Dr. Hari" };
    clinicNode[] table = new clinicNode[5];
    clinicNode tmp, head, entry;
    public ArrangeAppointment()
    {
        for(int i=0; i<5; i++)
        {
            table[i] = null;
        }
    }
    public void takeAppointment(Patient patient)
    {
        try
        {
            int id = patient.doctId;
            int count = 0;
            int num = id-1;
            if(table[num]== null)
            {
                table[num] = new clinicNode();
                table[num].setData(docName[num]);
                head = table[num];  
            }
            head = table[num];
            tmp = head;
            while(tmp.next != null)
            {
                tmp = tmp.getNext();
                count++;
            }
            if(count<=5)
            {
                head = table[num];
                tmp = head;
                entry = new clinicNode();
                entry.setData(patient);
                System.out.println("Appointment successful");
                while(tmp.getNext() != null)
                {
                    tmp= tmp.getNext();
                }
                tmp.setNext(entry);
                
            }
            else
                System.out.println("sorry no appointment possible today");
        }

        catch(ArrayIndexOutOfBoundsException ae)
        {
			System.out.println("Doctor's ID is Wrong!!");
		}
    }
    public void showAppointment()
    {
        for(int i=0; i<5; i++)
        {
            int total = 0;
            tmp = table[i];
            System.out.println(docName[i] +" ");
            if(tmp ==null)
            {
                System.out.println("Total appointments are " + total);
            }
            else
            {
                tmp = tmp.getNext();
                while(tmp != null)
                {
                    total++;
                    System.out.println(((Patient)tmp.getData()).Name+ ",");
                    tmp = tmp.getNext();
                }
                System.out.println("Total appointments are:" +total);
            }
        }
    }
}
