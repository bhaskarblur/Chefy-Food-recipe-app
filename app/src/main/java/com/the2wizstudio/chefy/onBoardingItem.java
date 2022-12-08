package com.the2wizstudio.chefy;

public class onBoardingItem {

    int imageId;
    String headText;
    String subText;

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setHeadText(String headText) {
        this.headText = headText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public int getImageId() {
        return imageId;
    }

    public String getHeadText() {
        return headText;
    }

    public String getSubText() {
        return subText;
    }

    public onBoardingItem(int imageId, String headText, String subText) {
        this.imageId=imageId;
        this.headText=headText;
        this.subText=subText;
    }
}
