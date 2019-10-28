package cn.mdsoftware.mdframework.bean.entity.host;

import java.util.List;

public class ListenDO {

    private static final long serialVersionUID = 1L;
    private String wardName;
    private String wardCode;
    private String ting;
    private String riqi;
    private String jc;

    private List<ListenDO> listenMon;
    private List<ListenDO> listenTues;
    private List<ListenDO> listenWed;
    private List<ListenDO> listenThu;
    private List<ListenDO> listenFri;
    private List<ListenDO> listenSat;
    private List<ListenDO> listenSun;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<ListenDO> getListenMon() {
        return listenMon;
    }

    public void setListenMon(List<ListenDO> listenMon) {
        this.listenMon = listenMon;
    }

    public List<ListenDO> getListenTues() {
        return listenTues;
    }

    public void setListenTues(List<ListenDO> listenTues) {
        this.listenTues = listenTues;
    }

    public List<ListenDO> getListenWed() {
        return listenWed;
    }

    public void setListenWed(List<ListenDO> listenWed) {
        this.listenWed = listenWed;
    }

    public List<ListenDO> getListenThu() {
        return listenThu;
    }

    public void setListenThu(List<ListenDO> listenThu) {
        this.listenThu = listenThu;
    }

    public List<ListenDO> getListenFri() {
        return listenFri;
    }

    public void setListenFri(List<ListenDO> listenFri) {
        this.listenFri = listenFri;
    }

    public List<ListenDO> getListenSat() {
        return listenSat;
    }

    public void setListenSat(List<ListenDO> listenSat) {
        this.listenSat = listenSat;
    }

    public List<ListenDO> getListenSun() {
        return listenSun;
    }

    public void setListenSun(List<ListenDO> listenSun) {
        this.listenSun = listenSun;
    }

    @Override
    public String toString() {
        return "ListenDO{" +
                "wardName='" + wardName + '\'' +
                ", wardCode='" + wardCode + '\'' +
                ", ting='" + ting + '\'' +
                ", riqi='" + riqi + '\'' +
                ", jc='" + jc + '\'' +
                '}';
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getTing() {
        return ting;
    }

    public void setTing(String ting) {
        this.ting = ting;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }
}
