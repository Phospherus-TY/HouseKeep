package com.ty.yysauto.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("orderinfo")
public class OrderInfo {
    @TableField("id")
    private String id;
    @TableField("name")
    private String name;
    @TableField("telnumber")
    private String telnumber;
    @TableField("local")
    private String local;
    @TableField("firsttime")
    private Date firsttime;
    @TableField("firsttimebz")
    private String  firsttimebz;
    @TableField("firststatus")
    private Integer  firststatus;

    @TableField("secondtime")
    private Date secondtime;
    @TableField("secondtimebz")
    private String  secondtimebz;
    @TableField("secondstatus")
    private Integer  secondstatus;

    @TableField("thirdtime")
    private Date thirdtime;
    @TableField("thirdtimebz")
    private String  thirdtimebz;
    @TableField("thirdstatus")
    private Integer  thirdstatus;

    @TableField("fourthtime")
    private Date fourthtime;
    @TableField("fourthtimebz")
    private String  fourthtimebz;
    @TableField("fourthstatus")
    private Integer  fourthstatus;

    @TableField("collectiontime")
    private Date collectiontime;
    @TableField("area")
    private String  area;
    @TableField("price")
    private String  price;
    @TableField("collectionway")
    private String  collectionway;
    @TableField("source")
    private String  source;
    @TableField("bz")
    private String  bz;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(Date firsttime) {
        this.firsttime = firsttime;
    }

    public String getFirsttimebz() {
        return firsttimebz;
    }

    public void setFirsttimebz(String firsttimebz) {
        this.firsttimebz = firsttimebz;
    }

    public Integer getFirststatus() {
        return firststatus;
    }

    public void setFirststatus(Integer firststatus) {
        this.firststatus = firststatus;
    }

    public Date getSecondtime() {
        return secondtime;
    }

    public void setSecondtime(Date secondtime) {
        this.secondtime = secondtime;
    }

    public String getSecondtimebz() {
        return secondtimebz;
    }

    public void setSecondtimebz(String secondtimebz) {
        this.secondtimebz = secondtimebz;
    }

    public Integer getSecondstatus() {
        return secondstatus;
    }

    public void setSecondstatus(Integer secondstatus) {
        this.secondstatus = secondstatus;
    }

    public Date getThirdtime() {
        return thirdtime;
    }

    public void setThirdtime(Date thirdtime) {
        this.thirdtime = thirdtime;
    }

    public String getThirdtimebz() {
        return thirdtimebz;
    }

    public void setThirdtimebz(String thirdtimebz) {
        this.thirdtimebz = thirdtimebz;
    }

    public Integer getThirdstatus() {
        return thirdstatus;
    }

    public void setThirdstatus(Integer thirdstatus) {
        this.thirdstatus = thirdstatus;
    }

    public Date getFourthtime() {
        return fourthtime;
    }

    public void setFourthtime(Date fourthtime) {
        this.fourthtime = fourthtime;
    }

    public String getFourthtimebz() {
        return fourthtimebz;
    }

    public void setFourthtimebz(String fourthtimebz) {
        this.fourthtimebz = fourthtimebz;
    }

    public Integer getFourthstatus() {
        return fourthstatus;
    }

    public void setFourthstatus(Integer fourthstatus) {
        this.fourthstatus = fourthstatus;
    }

    public Date getCollectiontime() {
        return collectiontime;
    }

    public void setCollectiontime(Date collectiontime) {
        this.collectiontime = collectiontime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCollectionway() {
        return collectionway;
    }

    public void setCollectionway(String collectionway) {
        this.collectionway = collectionway;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public String toString() {
        return "orderinfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", local='" + local + '\'' +
                ", firsttime=" + firsttime +
                ", firsttimebz='" + firsttimebz + '\'' +
                ", firststatus=" + firststatus +
                ", secondtime=" + secondtime +
                ", secondtimebz='" + secondtimebz + '\'' +
                ", secondstatus=" + secondstatus +
                ", thirdtime=" + thirdtime +
                ", thirdtimebz='" + thirdtimebz + '\'' +
                ", thirdstatus=" + thirdstatus +
                ", fourthtime=" + fourthtime +
                ", fourthtimebz='" + fourthtimebz + '\'' +
                ", fourthstatus=" + fourthstatus +
                ", collectiontime=" + collectiontime +
                ", area='" + area + '\'' +
                ", price='" + price + '\'' +
                ", collectionway='" + collectionway + '\'' +
                ", source='" + source + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }
}
