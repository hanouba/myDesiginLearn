package com.demo.hntest;

import android.os.Build;

import com.demo.hntest.Designpatterns.java.BuiderDesign.Builder;
import com.demo.hntest.Designpatterns.java.BuiderDesign.ConcreateBuilder;
import com.demo.hntest.Designpatterns.java.BuiderDesign.Director;
import com.demo.hntest.Designpatterns.java.BuiderDesign.Product;
import com.demo.hntest.Designpatterns.java.Template.Cricket;
import com.demo.hntest.Designpatterns.java.Template.Game;
import com.demo.hntest.Designpatterns.java.adapter.PowerAdapter;
import com.demo.hntest.Designpatterns.java.adapter.SpecialPowerOutlet;
import com.demo.hntest.Designpatterns.java.bridge.GreenColor;
import com.demo.hntest.Designpatterns.java.bridge.Pentagon;
import com.demo.hntest.Designpatterns.java.bridge.RedColor;
import com.demo.hntest.Designpatterns.java.bridge.Shape;
import com.demo.hntest.Designpatterns.java.bridge.Triangle;
import com.demo.hntest.Designpatterns.java.composite.Circle;
import com.demo.hntest.Designpatterns.java.composite.Drawing;
import com.demo.hntest.Designpatterns.java.decorator.Component;
import com.demo.hntest.Designpatterns.java.decorator.ConcreateDecorator1;
import com.demo.hntest.Designpatterns.java.decorator.ConcreateDecorator2;
import com.demo.hntest.Designpatterns.java.decorator.ConcreteComponent;
import com.demo.hntest.Designpatterns.java.facadedesignpattern.Facade;
import com.demo.hntest.Designpatterns.java.factory.Cumputer;
import com.demo.hntest.Designpatterns.java.factory.CumputerFactory;
import com.demo.hntest.Designpatterns.java.factory.PCFractory;
import com.demo.hntest.Designpatterns.java.factory.ServerFractory;
import com.demo.hntest.Designpatterns.java.proxy.CommandExecutor;
import com.demo.hntest.Designpatterns.java.proxy.CommandExecutorProxy;

import org.junit.Test;

public class TestAll {

    @Test
    public  void testFractory() {
        //测试工厂模式
//        Cumputer cf = CumputerFactory.getInstance("PC", "16G", "i7", "1T");
//        Cumputer sf = CumputerFactory.getInstance("Server", "32G", "i9", "2T");
//        System.out.println(cf.getCPU());
//        System.out.println(cf.getHDD());
//        System.out.println(cf.getRAM());
//        System.out.println("ServerCumputer  " + sf);
//        System.out.println("PC Cumputer  " + cf);
        //测试抽象工厂模式
        Cumputer pc = CumputerFactory.getCumputer(new PCFractory("16G", "i7", "1T"));
        System.out.println("个人电脑 "+pc);
        Cumputer server = CumputerFactory.getCumputer(new ServerFractory("32G", "i9", "2T"));
        System.out.println("服务器 "+server);
    }

    //建造者模式
    @Test
    public void testBuilder() {
        Builder builder = new ConcreateBuilder();//创建建造者
        Director director = new Director(builder);//创建指挥者
        director.construct();//指挥建造者
        Product product = builder.getProduct();//获得产品
        product.show();//显示产品
    }

    @Test
    public void testAdapter(){
        PowerAdapter powerAdapter = new PowerAdapter(new SpecialPowerOutlet());
        int voltage = powerAdapter.getVoltage();
        System.out.println("适配器获取到的 特殊voltage "+voltage);
    }
    @Test
    public void testBridge(){
        Shape tri = new Triangle(new RedColor());
        Shape pent = new Pentagon(new GreenColor());

        tri.applyColor();
        pent.applyColor();}

    @Test
    public void testShape() {
        com.demo.hntest.Designpatterns.java.composite.Shape circle = new Circle();
        com.demo.hntest.Designpatterns.java.composite.Shape tri = new com.demo.hntest.Designpatterns.java.composite.Triangle();
        com.demo.hntest.Designpatterns.java.composite.Shape tri2 = new com.demo.hntest.Designpatterns.java.composite.Triangle();

        Drawing drawing = new Drawing();
        drawing.add(circle);
        drawing.add(tri);
        drawing.add(tri2);
        drawing.draw("red");


        drawing.clear();

        drawing.add(tri);
        drawing.add(tri2);
        drawing.add(circle);
        drawing.draw("blue");

    }

    @Test
    public void testDecorator(){
        Component component = new ConcreteComponent();

         component = new ConcreateDecorator1(component);
         component = new ConcreateDecorator2(component);

        component.operation();
    }

    @Test
    public void testFacade(){
        Facade facade = new Facade();
        facade.facadeMethod();
    }

    @Test
    public void testProxy(){
        CommandExecutor executor = new CommandExecutorProxy("admin", "admin");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand("rm -rf abc.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTemplate(){
        Game game = new Cricket();
        game.play();
    }
}

