package com.demo.hntest.Designpatterns.java.flyweight;

import java.util.HashMap;

/**
 * 享元工厂
 */
public class ShapeFactory {
    private static final HashMap<ShapeType,FlyShape>  shapeMap= new HashMap<>();

    public static FlyShape getShape(ShapeType type){
        FlyShape shape = null;
        if(shapeMap.containsKey(type)){
            shape = shapeMap.get(type);
        }else{
            switch (type){
                case OVL_FILL:
                    shape = new Ovl();
                    break;
                case OVL_NOFILL:
                    shape = new Ovl();
                    break;
                case LINE:
                    shape = new Line();
                    break;
            }
            shapeMap.put(type,shape);
        }
        return shape;
    }
    public static enum ShapeType{
        OVL_FILL,OVL_NOFILL,LINE
    }
}
