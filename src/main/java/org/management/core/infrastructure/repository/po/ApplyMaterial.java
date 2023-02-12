package org.management.core.infrastructure.repository.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "apply_material")
public class ApplyMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 物资名称
     */
    @Column(name = "material_name")
    private String materialName;

    /**
     * 物资数量
     */
    private Integer num;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取物资名称
     *
     * @return material_name - 物资名称
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * 设置物资名称
     *
     * @param materialName 物资名称
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * 获取物资数量
     *
     * @return num - 物资数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置物资数量
     *
     * @param num 物资数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}