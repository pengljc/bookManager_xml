package com.jxd.book.model;


/**
 * @ClassName Book
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/2
 * @Version 1.0
 */
public class Book {
    private Integer bno;
    private String bname;
    private String author;
    private String press;
    private String pubdate;
    private int bnums;
    private double price;
    private int tno;

    public Book() {
    }

    public Book(Integer bno, String bname, String author, String press, String pubdate, int bnums, double price, int tno) {
        this.bno = bno;
        this.bname = bname;
        this.author = author;
        this.press = press;
        this.pubdate = pubdate;
        this.bnums = bnums;
        this.price = price;
        this.tno = tno;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
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

    @Override
    public String toString() {
        return "Book{" +
                "bno=" + bno +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", bnums=" + bnums +
                ", price=" + price +
                ", tno=" + tno +
                '}';
    }
}
