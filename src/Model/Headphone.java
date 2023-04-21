/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Headphone implements Serializable{
    private int ID;
    private String Brand;

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
    
    public Headphone(int ID, String name, double price, String Iday, boolean type, String brand) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.Iday = Iday;
        this.type = type;
        this.Brand = brand;
    }
    private String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public String getIday() {
        return Iday;
    }

    public void setIday(String Iday) {
        this.Iday = Iday;
    }

    
    private double price;
    private String Iday;
    private boolean type;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isType() {
        return type;
    }
    public String getType(String x){
        if(isType() == false){
            x = "99%";
        }else{
            x = "new";
        }
        return x;
    }
    
    public void setType(boolean type) {
        this.type = type;
    }
}
