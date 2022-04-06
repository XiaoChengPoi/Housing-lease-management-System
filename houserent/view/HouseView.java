package com.study.houserent.view;
import com.study.houserent.domain.House;
import com.study.houserent.service.HouseService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class HouseView {
    //菜单循环控制
    boolean isLoop = true;
    //实例一个业务模块作为属性并调用其方法
    private HouseService service = new HouseService();
    //提供一个接口获取业务类
    public HouseService getService(){
        return service;
    }
    //打印主菜单
    private void mainMenu(){
        System.out.println("======房屋出租系统======");
        System.out.println("=====1.房屋信息列表=====");
        System.out.println("=====2.租房      ======");
        System.out.println("=====3.退房      ======");
        System.out.println("=====4.房屋信息修改=====");
        System.out.println("=====5.退出系统   ======");
        System.out.println("请输入你的选择：");
    }
    //程序启动方法
    public void startProgram(LinkedList<House> houses){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id = 0;//获取具体房屋的序号
        int chose = 0;//switch选择变量
        do{
            mainMenu();
            try {
                chose = Integer.parseInt(reader.readLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            switch (chose){
                case 1://房屋信息列表
                    service.printHouses(houses);
                    break;
                case 2://租房
                    //获取想要的房屋的ID
                    System.out.println("请输入将出租的房屋ID");
                    try {
                         id = Integer.parseInt(reader.readLine());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        return;
                    }
                    service.rent(id,houses);
                    break;
                case 3://退房
                    //获取想退还的房屋的ID
                    System.out.println("请输入将退还的房屋ID");
                    try {
                        id = Integer.parseInt(reader.readLine());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        return;
                    }
                    service.disRent(id,houses);
                    break;
                case 4://修改房屋信息
                    int key = 0;
                    System.out.println("1.增加房屋");
                    System.out.println("2.删除房屋");
                    System.out.println("3.更改某房屋信息");
                    System.out.println("请选择：");
                    try {
                        key = Integer.parseInt(reader.readLine());
                    }catch ( Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("输入格式错误！请重试");
                        break;
                    }
                    try {
                        service.changeHouseMessage(houses, key);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5://退出系统
                    isLoop = false;
                    break;
                default:
                    System.out.println("输入了错误的选择，请重试！");
                    break;
            }
        }while(isLoop);
        System.out.println("欢迎下次使用！");
    }
}
