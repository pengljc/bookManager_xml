package com.jxd.book.vo;

/**
 * @ClassName BookWithTypeVO
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/2
 * @Version 1.0
 */
public class BookWithTypeVO {
    private int bno;
    private String bname;
    private String author;
    private String press;
    private String pubdate;
    private int bnums;
    private double price;
    private int tno;
    private String type;

    public BookWithTypeVO() {
    }

    public BookWithTypeVO(int bno, String bname, String author, String press, String pubdate, int bnums,
                          double price, int tno, String type) {
        this.bno = bno;
        this.bname = bname;
        this.author = author;
        this.press = press;
        this.pubdate = pubdate;
        this.bnums = bnums;
        this.price = price;
        this.tno = tno;
        this.type = type;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public int getBnums() {
        return bnums;
    }

    public void setBnums(int bnums) {
        this.bnums = bnums;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookWithTypeVO{" +
                "bno=" + bno +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", bnums=" + bnums +
                ", price=" + price +
                ", tno=" + tno +
                ", type='" + type + '\'' +
                '}';
    }
}
