package com.bridgelabz.clinic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Utility
{
    BufferedReader br = null;
    Utility()
    {
        
        br = new BufferedReader(new InputStreamReader(System.in)); 
    }
    //reading string
    public String inputString()
    {
        try
        {
            return br.readLine();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "";
    }
    //reading integer
    public int inputInt()
    {
        try
        {
            return Integer.parseInt(br.readLine());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
        //reading double
    public double inputDouble()
    {
        try
        {
            return Double.parseDouble(br.readLine());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0.0;
    }
        //reading boolean
    public boolean inputBoolean()
    {
        try
        {
            return Boolean.parseBoolean(br.readLine());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
        
}
