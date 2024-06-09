package com.main.complexnumberapplication;

class ComplexNo {
    private int real, img;

    static int complexNoCount=0;

    public ComplexNo() {
        real = img = 0;
        complexNoCount++;
        System.out.println("FYI, This is the " + complexNoCount +"-th ComplexNo");
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public static int getComplexNoCount() {
        return complexNoCount;
    }

    public static void setComplexNoCount(int complexNoCount) {
        ComplexNo.complexNoCount = complexNoCount;
    }

    public ComplexNo(int real, int img) {
        this.real = real;
        this.img = img;
        complexNoCount++;
        System.out.println("FYI, This is the " + complexNoCount +"-th ComplexNo");
    }
    //will add methods in future classes
    public ComplexNo add(ComplexNo c){
        ComplexNo temp = new ComplexNo();
        temp.real = this.real + c.real;
        temp.img = this.img + c.img;
        return temp;
    }

    public ComplexNo add(ComplexNo para1, ComplexNo para2){
        ComplexNo temp = new ComplexNo();
        temp.real = this.real + para1.real + para2.real;
        temp.img = this.img + para1.img + para2.img;
        return temp;
    }
    public ComplexNo add(int val){
        ComplexNo temp = new ComplexNo();
        temp.real = this.real + val;
        temp.img = this.img + val;
        return temp;
    }



    public ComplexNo subtract(ComplexNo c){
        ComplexNo temp = new ComplexNo();
        temp.real = this.real - c.real;
        temp.img = this.img - c.img;
        return temp;
    }


    @Override
    public String toString() {
        String sign = "";
        if(img>=0) sign = "+";
        return "Complex No: " + real + sign + img + "i";
    }


}
