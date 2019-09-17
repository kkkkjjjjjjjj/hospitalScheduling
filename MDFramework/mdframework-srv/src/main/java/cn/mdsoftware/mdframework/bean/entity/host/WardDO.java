package cn.mdsoftware.mdframework.bean.entity.host;
//病区人员排序
public class WardDO {
    private Integer xh;         //对应数据库xh     序号
    private String userName;    //对应数据库user_name  工号
    private String name;        //对应数据库name   姓名
    private String wardCode;    //对应数据库ward_code   病房号
    private String wardName;    //对应数据库ward_name   病房门名称
    private String zu;          //对应数据库zu   小组

    @Override
    public String toString() {
        return "PaibanRenYuanDO{" +
                "xh=" + xh +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", wardCode='" + wardCode + '\'' +
                ", wardName='" + wardName + '\'' +
                ", zu='" + zu + '\'' +
                '}';
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
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
