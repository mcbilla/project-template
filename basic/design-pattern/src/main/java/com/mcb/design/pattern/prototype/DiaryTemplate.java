package com.mcb.design.pattern.prototype;

import java.util.ArrayList;
import java.util.Date;

public class DiaryTemplate implements Cloneable {
    private String author;
    private Date date;
    private ArrayList<String> content;

    public DiaryTemplate(String author, Date date, ArrayList<String> content) {
        this.author = author;
        this.date = date;
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 默认为浅复制，只是拷贝了基本类型的数据，而引用类型数据，只是拷贝了一份引用地址
//        return super.clone();

        // 深复制
        try {
            DiaryTemplate dairy = (DiaryTemplate) super.clone();
            // 引用类型的成员变量，要手动调用clone方法复制一次，否则就只是复制了引用地址
            dairy.content = (ArrayList<String>) this.content.clone();
            return dairy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DiaryTemplate{");
        sb.append("author='").append(author).append('\'');
        sb.append(", date=").append(date);
        sb.append(", content=").append(content);
        sb.append('}');
        return sb.toString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }
}
