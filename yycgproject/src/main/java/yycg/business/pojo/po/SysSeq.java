package yycg.business.pojo.po;

public class SysSeq {
    private Integer bm;

    private String var;

    public Integer getBm() {
        return bm;
    }

    public void setBm(Integer bm) {
        this.bm = bm;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var == null ? null : var.trim();
    }
}