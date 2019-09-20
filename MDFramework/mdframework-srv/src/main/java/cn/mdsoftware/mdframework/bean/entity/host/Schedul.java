package cn.mdsoftware.mdframework.bean.entity.host;

public class Schedul {
    String xh;
    String userName;
    String name;
    String wardCode;
    String wardName;
    String zu;

    @Override
    public String toString() {
        return "Schedul{" +
                "xh='" + xh + '\'' +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", wardCode='" + wardCode + '\'' +
                ", wardName='" + wardName + '\'' +
                ", zu='" + zu + '\'' +
                '}';
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getZu() {
        return zu;
    }

    public void setZu(String zu) {
        this.zu = zu;
    }
}
