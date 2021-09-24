package com.zxf.designModel.FactoryPattern.test;

import com.zxf.designModel.FactoryPattern.Impl.Circle;
import com.zxf.designModel.FactoryPattern.Impl.Rectangle;
import com.zxf.designModel.FactoryPattern.Impl.Square;
import com.zxf.designModel.FactoryPattern.Shape;

/**
 * @Author: zhaoxiaofeng
 * @Description: 用于获取具体对象
 * @Date: 2020/6/12 21:16
 */
public class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
