package com.oa.pojo;

public class Salary {
    private Integer id;

    private Integer userid;

    private String month;

    private Float basicsalary;

    private Float fsalary;

    private Integer checkingdays;

    private Float trafficallowance;

    private Float otherallowance;

    private Float totalallowance;

    private Float endowmentinsurance;

    private Float medicalinsurance;

    private Float unemploymentinsurance;

    private Float employmentinjuryinsurance;

    private Float maternityinsurance;

    private Float housingfund;

    private Float othersdeduct;

    private Float totaldeduct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public Float getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(Float basicsalary) {
        this.basicsalary = basicsalary;
    }

    public Float getFsalary() {
        return fsalary;
    }

    public void setFsalary(Float fsalary) {
        this.fsalary = fsalary;
    }

    public Integer getCheckingdays() {
        return checkingdays;
    }

    public void setCheckingdays(Integer checkingdays) {
        this.checkingdays = checkingdays;
    }

    public Float getTrafficallowance() {
        return trafficallowance;
    }

    public void setTrafficallowance(Float trafficallowance) {
        this.trafficallowance = trafficallowance;
    }

    public Float getOtherallowance() {
        return otherallowance;
    }

    public void setOtherallowance(Float otherallowance) {
        this.otherallowance = otherallowance;
    }

    public Float getTotalallowance() {
        return totalallowance;
    }

    public void setTotalallowance(Float totalallowance) {
        this.totalallowance = totalallowance;
    }

    public Float getEndowmentinsurance() {
        return endowmentinsurance;
    }

    public void setEndowmentinsurance(Float endowmentinsurance) {
        this.endowmentinsurance = endowmentinsurance;
    }

    public Float getMedicalinsurance() {
        return medicalinsurance;
    }

    public void setMedicalinsurance(Float medicalinsurance) {
        this.medicalinsurance = medicalinsurance;
    }

    public Float getUnemploymentinsurance() {
        return unemploymentinsurance;
    }

    public void setUnemploymentinsurance(Float unemploymentinsurance) {
        this.unemploymentinsurance = unemploymentinsurance;
    }

    public Float getEmploymentinjuryinsurance() {
        return employmentinjuryinsurance;
    }

    public void setEmploymentinjuryinsurance(Float employmentinjuryinsurance) {
        this.employmentinjuryinsurance = employmentinjuryinsurance;
    }

    public Float getMaternityinsurance() {
        return maternityinsurance;
    }

    public void setMaternityinsurance(Float maternityinsurance) {
        this.maternityinsurance = maternityinsurance;
    }

    public Float getHousingfund() {
        return housingfund;
    }

    public void setHousingfund(Float housingfund) {
        this.housingfund = housingfund;
    }

    public Float getOthersdeduct() {
        return othersdeduct;
    }

    public void setOthersdeduct(Float othersdeduct) {
        this.othersdeduct = othersdeduct;
    }

    public Float getTotaldeduct() {
        return totaldeduct;
    }

    public void setTotaldeduct(Float totaldeduct) {
        this.totaldeduct = totaldeduct;
    }
}