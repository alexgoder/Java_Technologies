package com.example.ex;

public class Rectangle {
    private int length;
    private int width;

    public void area() {
        System.out.println("Rectangle area is "+(length*width));
    }

    public int getLength() { return length; }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() { return width; }

    public void setWidth(int width) {
        this.width = width;
    }
}
