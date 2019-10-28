package cn.mdsoftware.mdframework.bean.entity.host;

//排班信息
public class SchedulingInformationDO {
    private Integer xh;
    private String jc;
    private String xx;
    private String wardName;
    private String wardCode;

    @Override
    public String toString() {
        return "SchedulingInformationDo{" +
                "xh='" + xh + '\'' +
                ", jc='" + jc + '\'' +
                ", xx='" + xx + '\'' +
                ", wardName='" + wardName + '\'' +
                ", wardCode='" + wardCode + '\'' +
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
}
