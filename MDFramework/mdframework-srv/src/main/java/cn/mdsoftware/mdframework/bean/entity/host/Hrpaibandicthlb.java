package cn.mdsoftware.mdframework.bean.entity.host;

public class Hrpaibandicthlb {
    private Integer xh;
    private String jc;
    private String xx;
    private String starttime;
    private String endtime;
    private String shijian;
    private String danwei;

    @Override
    public String toString() {
        return "Hrpaibandicthlb{" +
                "xh=" + xh +
                ", jc='" + jc + '\'' +
                ", xx='" + xx + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", shijian='" + shijian + '\'' +
                ", danwei='" + danwei + '\'' +
                '}';
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }
}
