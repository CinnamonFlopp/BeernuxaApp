package com.example.beernuxaapp.models;

public class HomeVerModel {
    int image1;
    int image2;
    int icon;
    String surname;
    String name;
    String proce;
    String ibu;
    String numb1;
    String size;
    String numb2;

    public HomeVerModel(int image1, int image2, String surname, String name, int icon, String proce, String ibu, String numb1, String size, String numb2) {
        this.image1 = image1;
        this.image2 = image2;
        this.surname = surname;
        this.name = name;
        this.icon = icon;
        this.proce = proce;
        this.ibu = ibu;
        this.numb1 = numb1;
        this.size = size;
        this.numb2 = numb2;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }
    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getProce() {
        return proce;
    }

    public void setProce(String proce) {
        this.proce = proce;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public String getNumb1() {
        return numb1;
    }

    public void setNumb1(String numb1) {
        this.numb1 = numb1;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNumb2() {
        return numb2;
    }

    public void setNumb2(String numb2) {
        this.numb2 = numb2;
    }
}
