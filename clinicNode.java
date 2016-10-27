package com.bridgelabz.clinic;
import java.lang.*;
import java.io.*;
 class clinicNode<T>
    {
        T data;
        clinicNode next;

       public T getData ()  //get data
        {
            return data;
        }       
        public clinicNode getNext ()  //get next node ka reference
        {
            return next;
        }
        public void setData(T d)  // set data
        {
             data = d;
        }
        public void setNext (clinicNode n) // set next node ka reference
        {
            next = n;
        }

    }

