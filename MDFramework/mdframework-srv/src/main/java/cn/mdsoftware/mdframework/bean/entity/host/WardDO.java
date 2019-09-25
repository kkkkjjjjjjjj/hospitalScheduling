package cn.mdsoftware.mdframework.bean.entity.host;

import java.util.List;

//病区人员排序
public class WardDO {
    private static final long serialVersionUID = 1L;
    private Integer xh;         //对应数据库xh     序号
    private String userName;    //对应数据库user_name  工号
    private String name;        //对应数据库name   姓名
    private String wardCode;    //对应数据库ward_code   病房号
    private String wardName;    //对应数据库ward_name   病房门名称
    private String zu;          //对应数据库zu   小组

    private List<SchedulDO> schedulMon;
    private List<SchedulDO> schedulTues;
    private List<SchedulDO> schedulWed;
    private List<SchedulDO> schedulThu;
    private List<SchedulDO> schedulFri;
    private List<SchedulDO> schedulSat;
    private List<SchedulDO> schedulSun;

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

    public List<SchedulDO> getSchedulMon() {
        return schedulMon;
    }

    public void setSchedulMon(List<SchedulDO> schedulMon) {
        this.schedulMon = schedulMon;
    }

    public List<SchedulDO> getSchedulTues() {
        return schedulTues;
    }

    public void setSchedulTues(List<SchedulDO> schedulTues) {
        this.schedulTues = schedulTues;
    }

    public List<SchedulDO> getSchedulWed() {
        return schedulWed;
    }

    public void setSchedulWed(List<SchedulDO> schedulWed) {
        this.schedulWed = schedulWed;
    }

    public List<SchedulDO> getSchedulThu() {
        return schedulThu;
    }

    public void setSchedulThu(List<SchedulDO> schedulThu) {
        this.schedulThu = schedulThu;
    }

    public List<SchedulDO> getSchedulFri() {
        return schedulFri;
    }

    public void setSchedulFri(List<SchedulDO> schedulFri) {
        this.schedulFri = schedulFri;
    }

    public List<SchedulDO> getSchedulSat() {
        return schedulSat;
    }

    public void setSchedulSat(List<SchedulDO> schedulSat) {
        this.schedulSat = schedulSat;
    }

    public List<SchedulDO> getSchedulSun() {
        return schedulSun;
    }

    public void setSchedulSun(List<SchedulDO> schedulSun) {
        this.schedulSun = schedulSun;
    }
}
