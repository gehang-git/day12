package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Dept implements Serializable {
    /**
     * 部门ID
     */
    @Id
    private Integer id;

    /**
     * 部门名
     */
    private String name;

    private static final long serialVersionUID = 1L;

    /**
     * 获取部门ID
     *
     * @return id - 部门ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置部门ID
     *
     * @param id 部门ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门名
     *
     * @return name - 部门名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名
     *
     * @param name 部门名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }
}