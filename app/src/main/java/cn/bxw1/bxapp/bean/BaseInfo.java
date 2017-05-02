package cn.bxw1.bxapp.bean;

import java.io.Serializable;

/**
 * Package:cn.bxw1.bxapp.bean
 * author:liuting
 * Date:2017/4/1
 * Desc:基本信息类
 */

public class BaseInfo implements Serializable {
    protected long id;//id

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
