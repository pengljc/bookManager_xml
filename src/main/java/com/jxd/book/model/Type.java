package com.jxd.book.model;

/**
 * @ClassName Type
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/2
 * @Version 1.0
 */
public class Type {
    private int tno;
    private String type;

    public Type() {
    }

    public Type(int tno, String type) {
        this.tno = tno;
        this.type = type;
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
        return "BookType{" +
                "tno=" + tno +
                ", type='" + type + '\'' +
                '}';
    }
}
