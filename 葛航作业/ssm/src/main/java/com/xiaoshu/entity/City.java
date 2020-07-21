package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;

public class City implements Serializable {
    /**
     * 城市ID
     */
    @Id
    private Integer id;

    /**
     * 城市名
     */
    private String name;

    /**
     * 父级城市ID
     */
    private Integer pid;

    private static final long serialVersionUID = 1L;

    /**
     * 获取城市ID
     *
     * @return id - 城市ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置城市ID
     *
     * @param id 城市ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取城市名
     *
     * @return name - 城市名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置城市名
     *
     * @param name 城市名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取父级城市ID
     *
     * @return pid - 父级城市ID
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父级城市ID
     *
     * @param pid 父级城市ID
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", pid=").append(pid);
        sb.append("]");
        return sb.toString();
    }
}