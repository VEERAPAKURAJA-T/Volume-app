package com.example.volume_app;
//This class is acting as: "MODEL CLASS"
//it is represents the data structure or individual data items
//that your adapter is going to display
/*
It's essential container for the data that you want to show in your UI
using an adapter,and it helps to organize and encapsulate the data in a
meaningful way.
 */
public class shape {
    /*
    the image view in android studio are referred and stored in the
    int variables.For that we create the integer variable as
    shape image and create another variable called shape.
     */
    int shapeImg;
    String shapeName;

    public shape(int shapeImg, String shapeName) {
        this.shapeImg = shapeImg;
        this.shapeName = shapeName;
    }
    //next step is to create a getter & setter.

    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
}
