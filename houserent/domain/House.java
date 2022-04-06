package com.study.houserent.domain;

public class House {
    //编号，房主，电话，地址，月租，出租状态
    private int id;
    private String houseHold;
    private String tel;
    private String address;
    private int monthCost;
    private String state;

    public House(int id, String houseHold, String tel, String address, int monthCost, String state) {
        this.id = id;
        this.houseHold = houseHold;
        this.tel = tel;
        this.address = address;
        this.monthCost = monthCost;
        this.state = state;
    }

    @Override
    public String toString(){
       return     id+
                  "\t\t"+houseHold+
                  "\t\t"+tel+
                  "\t\t"+address+
                  "\t\t"+monthCost+
                  "\t\t"+state+"\n";
    }

    public boolean equals(int id){
        if(this.id == id){
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(String houseHold) {
        this.houseHold = houseHold;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMonthCost() {
        return monthCost;
    }

    public void setMonthCost(int monthCost) {
        this.monthCost = monthCost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
