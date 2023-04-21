/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class XFile {
    public static void writeFile(String path){
        File f = new File(path);
        FileOutputStream fos = null;
         try{
             fos = new FileOutputStream(f);
             byte arr[] = {10,20,30};
             fos.write(arr);
             fos.close();
             
         }catch(FileNotFoundException e){
             System.err.println(e);
         }catch(IOException ex){
             System.err.println("Failed");
         }
    }
    public static void readFile (String path){
        File f = new File(path);
        FileInputStream fis = null;
         try{
             fis = new FileInputStream(f);
             int fileSize = (int)f.length();
          
             byte arr [] = new byte [fileSize];
                fis.read(arr);
             for (int i = 0; i < fileSize; i++) {
                 System.out.print(arr[i]+" ");
             }
//             byte arr[] = {10,20,30};
//             fis.write(arr);
             fis.close();
             
         }catch(FileNotFoundException e){
             System.err.println(e);
         }catch(IOException ex){
             System.err.println("Failed");
    }
    }
    
    
    public static void writeDataFile(String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(5);
            dos.writeUTF("mónsieur.Enma 2k5");
            dos.writeDouble(9.5);
            dos.close();
            
        }catch(IOException e){
            System.err.println("Fail");
        }
    }
    
     public static void readDataFile (String path){
         try {
             FileInputStream Fis = new FileInputStream(path);
             DataInputStream Dis = new DataInputStream(Fis);       
             int fileSize = (int)path.length();
             System.out.println(Dis.readInt()); 
             System.out.println(Dis.readUTF()); 
             System.out.println(Dis.readDouble()); 
             
             Dis.close();
             
         } catch (Exception e) {
         }
    }
    
     public static void writeBuffer(String path, String text){
         try{
             FileWriter fw = new FileWriter(path);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write(text);
             bw.close();
         }catch(IOException e){
             System.err.println("YOU FAIL BEING A ENGINEER");
         }
     }
     
     public static String readBuffer(String path){
         StringBuilder sb = new StringBuilder();
         try {
               FileReader fr = new FileReader(path);
               BufferedReader br = new BufferedReader(fr);
               String firstline = br.readLine();
               while(firstline!=null){
                   sb.append(firstline);
                   firstline = br.readLine();
                   if(firstline!=null) sb.append("\n");
               }
                  }catch(IOException e){
                      System.err.println("YOU FAIL BEING A ENGINEER");
                  }
       
         return sb.toString();
     }
     
    public static void writeObject(String path, Object o){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(o);
            oos.close();
        }catch(IOException e){
            System.err.println("Failed");
        }
    }
      public static Object readObject(String path){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Object o = ois.readObject();
            ois.close();
            return o;
        }catch(IOException e){
            System.err.println("Failed");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not Found");
        }
        return null;
    }
     
    public static void main(String[] args) {
        String filePath = "./src/lib/KONCAT.dat";
//        writeBuffer(filePath, "mónsieur.Enma 2k5 \n olala ");
//        readBuffer(filePath);

//        writeFile(filePath);
//        readFile(filePath);

//            writeDataFile(filePath);
//            readDataFile(filePath);
        
        }
            }

    

