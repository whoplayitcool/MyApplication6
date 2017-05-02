package cn.bxw1.bxapp.bean;

/**
 * Package:cn.bxw1.bxapp.bean
 * author:liuting
 * Date:2017/3/23
 * Desc:滚动广告实体类
 */

public class BannerInfo {
    private String name;//名称
    private String imgUrl;//图片URL
    private  String id;//描述
    private int imgUri;

    public int getImgUri() {
        return imgUri;
    }

    public void setImgUri(int imgUri) {
        this.imgUri = imgUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
