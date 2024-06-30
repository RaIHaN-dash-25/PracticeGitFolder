package main.midpractice1;

public class ComplexNo {
    private String real,img;

    public ComplexNo(String real, String img) {
        this.real = real;
        this.img = img+'i';
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public String getImg() {
        return img;
    }



    public void setImg(String img) {
        this.img = img;
    }

    public ComplexNo(int i) {
    }
}
