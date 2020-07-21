package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "tb_emp")
public class Emp implements Serializable {
    /**
     * 员工ID
     */
    @Id
    @Column(name = "tb_emp_id")
    private Integer tbEmpId;

    /**
     * 员工名
     */
    @Column(name = "tb_emp_name")
    private String tbEmpName;

    /**
     * 员工性别
     */
    @Column(name = "tb_emp_sex")
    private String tbEmpSex;

    /**
     * 员工年龄
     */
    @Column(name = "tb_emp_age")
    private Integer tbEmpAge;

    /**
     * 员工住址
     */
    @Column(name = "tb_emp_address")
    private String tbEmpAddress;

    /**
     * 员工头像
     */
    @Column(name = "tb_emp_img")
    private String tbEmpImg;

    /**
     * 员工出生日期
     */
    @Column(name = "tb_emp_birthday")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date tbEmpBirthday;

    /**
     * 员工所在地省id
     */
    @Column(name = "tb_emp_shengid")
    private Integer tbEmpShengid;

    /**
     * 员工所在地市id
     */
    @Column(name = "tb_emp_sid")
    private Integer tbEmpSid;

    /**
     * 员工所在地县id
     */
    @Column(name = "tb_emp_xid")
    private Integer tbEmpXid;

    /**
     * 员工所属部门id
     */
    @Column(name = "tb_emp_did")
    private Integer tbEmpDid;

    private static final long serialVersionUID = 1L;

    /**
     * 获取员工ID
     *
     * @return tb_emp_id - 员工ID
     */
    public Integer getTbEmpId() {
        return tbEmpId;
    }

    /**
     * 设置员工ID
     *
     * @param tbEmpId 员工ID
     */
    public void setTbEmpId(Integer tbEmpId) {
        this.tbEmpId = tbEmpId;
    }

    /**
     * 获取员工名
     *
     * @return tb_emp_name - 员工名
     */
    public String getTbEmpName() {
        return tbEmpName;
    }

    /**
     * 设置员工名
     *
     * @param tbEmpName 员工名
     */
    public void setTbEmpName(String tbEmpName) {
        this.tbEmpName = tbEmpName == null ? null : tbEmpName.trim();
    }

    /**
     * 获取员工性别
     *
     * @return tb_emp_sex - 员工性别
     */
    public String getTbEmpSex() {
        return tbEmpSex;
    }

    /**
     * 设置员工性别
     *
     * @param tbEmpSex 员工性别
     */
    public void setTbEmpSex(String tbEmpSex) {
        this.tbEmpSex = tbEmpSex == null ? null : tbEmpSex.trim();
    }

    /**
     * 获取员工年龄
     *
     * @return tb_emp_age - 员工年龄
     */
    public Integer getTbEmpAge() {
        return tbEmpAge;
    }

    /**
     * 设置员工年龄
     *
     * @param tbEmpAge 员工年龄
     */
    public void setTbEmpAge(Integer tbEmpAge) {
        this.tbEmpAge = tbEmpAge;
    }

    /**
     * 获取员工住址
     *
     * @return tb_emp_address - 员工住址
     */
    public String getTbEmpAddress() {
        return tbEmpAddress;
    }

    /**
     * 设置员工住址
     *
     * @param tbEmpAddress 员工住址
     */
    public void setTbEmpAddress(String tbEmpAddress) {
        this.tbEmpAddress = tbEmpAddress == null ? null : tbEmpAddress.trim();
    }

    /**
     * 获取员工头像
     *
     * @return tb_emp_img - 员工头像
     */
    public String getTbEmpImg() {
        return tbEmpImg;
    }

    /**
     * 设置员工头像
     *
     * @param tbEmpImg 员工头像
     */
    public void setTbEmpImg(String tbEmpImg) {
        this.tbEmpImg = tbEmpImg == null ? null : tbEmpImg.trim();
    }

    /**
     * 获取员工出生日期
     *
     * @return tb_emp_birthday - 员工出生日期
     */
    public Date getTbEmpBirthday() {
        return tbEmpBirthday;
    }

    /**
     * 设置员工出生日期
     *
     * @param tbEmpBirthday 员工出生日期
     */
    public void setTbEmpBirthday(Date tbEmpBirthday) {
        this.tbEmpBirthday = tbEmpBirthday;
    }

    /**
     * 获取员工所在地省id
     *
     * @return tb_emp_shengid - 员工所在地省id
     */
    public Integer getTbEmpShengid() {
        return tbEmpShengid;
    }

    /**
     * 设置员工所在地省id
     *
     * @param tbEmpShengid 员工所在地省id
     */
    public void setTbEmpShengid(Integer tbEmpShengid) {
        this.tbEmpShengid = tbEmpShengid;
    }

    /**
     * 获取员工所在地市id
     *
     * @return tb_emp_sid - 员工所在地市id
     */
    public Integer getTbEmpSid() {
        return tbEmpSid;
    }

    /**
     * 设置员工所在地市id
     *
     * @param tbEmpSid 员工所在地市id
     */
    public void setTbEmpSid(Integer tbEmpSid) {
        this.tbEmpSid = tbEmpSid;
    }

    /**
     * 获取员工所在地县id
     *
     * @return tb_emp_xid - 员工所在地县id
     */
    public Integer getTbEmpXid() {
        return tbEmpXid;
    }

    /**
     * 设置员工所在地县id
     *
     * @param tbEmpXid 员工所在地县id
     */
    public void setTbEmpXid(Integer tbEmpXid) {
        this.tbEmpXid = tbEmpXid;
    }

    /**
     * 获取员工所属部门id
     *
     * @return tb_emp_did - 员工所属部门id
     */
    public Integer getTbEmpDid() {
        return tbEmpDid;
    }

    /**
     * 设置员工所属部门id
     *
     * @param tbEmpDid 员工所属部门id
     */
    public void setTbEmpDid(Integer tbEmpDid) {
        this.tbEmpDid = tbEmpDid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tbEmpId=").append(tbEmpId);
        sb.append(", tbEmpName=").append(tbEmpName);
        sb.append(", tbEmpSex=").append(tbEmpSex);
        sb.append(", tbEmpAge=").append(tbEmpAge);
        sb.append(", tbEmpAddress=").append(tbEmpAddress);
        sb.append(", tbEmpImg=").append(tbEmpImg);
        sb.append(", tbEmpBirthday=").append(tbEmpBirthday);
        sb.append(", tbEmpShengid=").append(tbEmpShengid);
        sb.append(", tbEmpSid=").append(tbEmpSid);
        sb.append(", tbEmpXid=").append(tbEmpXid);
        sb.append(", tbEmpDid=").append(tbEmpDid);
        sb.append("]");
        return sb.toString();
    }
}