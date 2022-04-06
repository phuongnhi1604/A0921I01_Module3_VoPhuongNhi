package com.codegym;

public class demo_packing {
    public static void main(String[] args) {
        //Write your code
    }

    public static void giaiPTB2(float a, float b, float c){
        if (a==b){
            if (b==0){
                System.out.println("Phuong trinh vo nghiem");
            }else {
                System.out.println("Phuong trinh co 1 nghiem: x = "+ (-c/b));
            }
        }
        float delta = b*b - 4*a*c;
        float x1,x2;
        if (delta > 0){
            x1 = (float) ((-b + Math.sqrt(delta))/(2*a));
            x2 = (float) ((-b - Math.sqrt(delta))/(2*a));
            System.out.println("Phuong trinh co 2 nghiem: x1 = "+x1+", x2 = "+ x2);
        }else if (delta == 0){
            x1 = -b/(2*a);
            System.out.println("Phuong trinh co nghiem kep: x1 = x2 = "+x1);
        }else {
            System.out.println("Phuong trinh vo nghiem");
        }
    }
}
