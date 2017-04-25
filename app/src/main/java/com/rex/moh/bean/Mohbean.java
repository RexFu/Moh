package com.rex.moh.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rex on 2017/4/23.
 */

public class Mohbean implements Serializable {
    private List<AllDataBean> allData;
    private List<String> cardType;
    private List<String> percentage;
    private List<String> runBeard;
    private List<String> runFast;
    public  int Pos;
    public List<AllDataBean> getAllData() {
        return allData;
    }

    public void setAllData(List<AllDataBean> allData) {
        this.allData = allData;
    }

    public List<String> getCardType() {
        return cardType;
    }

    public void setCardType(List<String> cardType) {
        this.cardType = cardType;
    }

    public List<String> getPercentage() {
        return percentage;
    }

    public void setPercentage(List<String> percentage) {
        this.percentage = percentage;
    }

    public List<String> getRunBeard() {
        return runBeard;
    }

    public void setRunBeard(List<String> runBeard) {
        this.runBeard = runBeard;
    }

    public List<String> getRunFast() {
        return runFast;
    }

    public void setRunFast(List<String> runFast) {
        this.runFast = runFast;
    }

    public static class AllDataBean implements Serializable{
        /**
         * image : image1
         * list : ["南昌麻将","九江麻将","上饶麻将"]
         * name : 星期五游戏
         */

        private String image;
        private String name;
        private List<String> list;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
