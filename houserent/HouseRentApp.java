package com.study.houserent;
import com.study.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        //实例化页面对象
        HouseView view = HouseView.getInstance();
        //启动程序
        view.startProgram(view.getService().getHouses());
    }
}
