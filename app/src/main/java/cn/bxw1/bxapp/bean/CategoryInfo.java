package cn.bxw1.bxapp.bean;

/**
 * Package:cn.bxw1.bxapp.bean
 * author:liuting
 * Date:2017/4/1
 * Desc:分类信息类
 */

public class CategoryInfo extends BaseInfo {
    private String name;//分类名称

    public CategoryInfo() {
    }

    public CategoryInfo(String name) {
        this.name = name;
    }

    public CategoryInfo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
