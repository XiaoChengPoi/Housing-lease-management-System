package com.study.houserent.service;
import com.study.houserent.domain.House;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class HouseService {
    //创建房屋集合作为成员属性
    private LinkedList<House> houses = new LinkedList<>();
    //房屋集合Getter方法
    public LinkedList<House> getHouses(){
        return houses;
    }
    //单例模式设计思想
    private static HouseService service ;
    //私有化构造器
    private HouseService(){

    }
    //提供获取业务模块的方法
    public static HouseService getInstance(){
        if(service == null){
            service = new HouseService();
        }
        return service;
    }
    //打印房屋清单
    public void printHouses(LinkedList<House> houses){
        System.out.println("序号"+"\t\t"+"房主"+"\t\t"+"联系电话"+"\t\t"+"房屋地址"+"\t\t"+"月租"+"\t\t"+"出租状态");
        for(Object obj:houses){
            House house = (House) obj;
            System.out.print(house);
        }
        System.out.println("=====信息显示完毕=====");
    }
    //增加房屋
   public void add(String houseHold,String tel,String address,int monthCost,LinkedList<House> houses){
      //获取集合长度作为序号
       int id = houses.size()+1;
       //循环查找序号有无相同，如果有就+1
        boolean flag = false;
        do{
           for(Object obj:houses) {
               House house = (House) obj;
               if(house.getId()==id){
                   flag = true;
                   id++;
                   break;
               }else{
                   flag = false;//ID没有重复则退出循环
               }
           }}while (flag);

       houses.addLast(new House(id,houseHold,tel,address,monthCost,"未出租"));
       System.out.println("房屋创建成功！");
    }

   //删除房屋
    public void delete(int id,LinkedList<House> houses){
        Iterator it = houses.iterator();
        boolean flag = false;
        while(it.hasNext()){
            Object obj = it.next();
            House house = (House) obj;
            if(house.equals(id)){
                it.remove();//删除对象
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("序号："+id+"的房屋信息删除成功！");
        }
        else System.out.println("房屋信息删除失败，未找到该房屋！");
    }

    //修改房屋信息
    public void changeHouseMessage(LinkedList<House> houses,int key) throws IOException {
        //定义一个抽象房屋来储存被操作的集合对象
        House house = null;
        //定义房屋具体信息变量
        int id = 0;
        String houseHold;
        String tel;
        String address;
        int monthCost = 0;
        //实例一个读写对象
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //没有输入任何选择
        if(key == 0){
            System.out.println("选择错误！请重试");
            return;
        }

        //增加房屋
        if(key == 1){
            System.out.println("请输入新房屋信息：");
            try {
                System.out.println("房主名:");
                 houseHold = reader.readLine();
                System.out.println("房主联系电话:");
                 tel = reader.readLine();
                System.out.println("房屋地址:");
                 address = reader.readLine();
                System.out.println("房屋月租:");
                 monthCost = Integer.parseInt(reader.readLine());
            }catch (Exception e){
                System.out.println("格式错误！房屋添加失败！");
                return;
            }
            //调用增加方法
            add(houseHold,tel,address,monthCost,houses);
        }

        //删除房屋
        if(key == 2){
            System.out.println("请输入要删除的房屋序号：");
            try {
                id = Integer.parseInt(reader.readLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
                return;
            }
            delete(id,houses);
        }

        //修改房屋信息
        if(key == 3){
            System.out.println("请输入要修改的房屋的序号：");
            try {
                //获取用户输入的id
                id = Integer.parseInt(reader.readLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
                return;
            }

            //判断该房屋是否存在
            boolean flag = false;
            for(Object obj:houses){
                house = (House)obj;
                if(house.getId() == id){
                    flag = true;
                }
            }

            //如果存在
            if(flag){
                //选择要修改哪些信息
                boolean control = true;//控制循环
                int chose;//存放选择
                while(control){
                    //每次循环输出一次房屋信息
                    System.out.println("序号为:"+id+"的房屋信息如下:");
                    System.out.println("序号"+"\t\t"+"房主"+"\t\t"+"联系电话"+"\t\t"+"房屋地址"+"\t\t"+"月租"+"\t\t"+"出租状态");
                    for(Object obj:houses){
                        house = (House)obj;
                        if(house.getId() == id){
                            System.out.println(house);
                            //此时house对象引用的是指定的id的房屋
                            break;
                        }
                    }
                    //打印菜单信息
                    System.out.println("======================");
                    System.out.println("请选择要修改的信息：");
                    System.out.println("1.房屋ID");
                    System.out.println("2.房主名称");
                    System.out.println("3.房主联系电话");
                    System.out.println("4.房屋地址");
                    System.out.println("5.房屋月租");
                    System.out.println("6.出租状态");
                    System.out.println("7.退出");
                    System.out.println("请输入要修改的信息:");
                    try {
                        chose = Integer.parseInt(reader.readLine());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        return;
                    }

                    switch(chose){
                        case 1:
                            System.out.println("修改后的信息为：");
                            int id1 = Integer.parseInt(reader.readLine());//存储输入的id
                            boolean isCopy = false;//判断ID是否重复
                            for(Object obj:houses){
                                House house2 = (House) obj;
                                if(house2.getId()==id1){
                                    System.out.println("该ID已存在，请更换其他ID！");
                                    isCopy = true;
                                }
                            }
                            if(isCopy == false){
                            house.setId(id1);
                            System.out.println("修改成功！");
                            }
                            else System.out.println("修改失败!");
                            break;
                        case 2:
                            System.out.println("修改后的信息为：");
                            house.setHouseHold(reader.readLine());
                            System.out.println("修改成功！");
                            break;
                        case 3:
                            System.out.println("修改后的信息为：");
                            house.setTel(reader.readLine());
                            System.out.println("修改成功！");
                            break;
                        case 4:
                            System.out.println("修改后的信息为：");
                            house.setAddress(reader.readLine());
                            System.out.println("修改成功！");
                            break;
                        case 5:
                            System.out.println("修改后的信息为：");
                            house.setMonthCost(Integer.parseInt(reader.readLine()));
                            System.out.println("修改成功！");
                            break;
                        case 6:
                            System.out.println("修改后的信息为：");
                            house.setState(reader.readLine());
                            System.out.println("修改成功！");
                            break;
                        case 7:
                            control = false;
                            break;
                    }
                }
            }
            else {
                System.out.println("修改失败，该房屋不存在！");
                return;
            }
        }
    }

    //租房
    public void rent(int id,LinkedList<House> houses){
        boolean flag = false;
        for (Object obj:houses) {
            House house = (House) obj;
            if(house.getId() == id){
                if (house.getState().equals("已出租")){
                    System.out.println("该房屋已被租出！请更换其他房屋");
                    return;
                }
                house.setState("已出租");
                flag = true;
            }
        }
        if(flag){
            System.out.println("出租成功！");
        }
    }

    //退房
    public void disRent(int id,LinkedList<House> houses){
        boolean flag = false;
        for (Object obj:houses) {
            House house = (House) obj;
            if(house.getId() == id){
                if (house.getState().equals("已出租")){
                    house.setState("未出租");
                    System.out.println("序号为:"+house.getId()+"的房屋已成功退房!");
                    return;
                }
                flag = true;
            }
        }
        if(flag){
            System.out.println("该房屋还未被出租，不能退房！");
        }
    }
}
