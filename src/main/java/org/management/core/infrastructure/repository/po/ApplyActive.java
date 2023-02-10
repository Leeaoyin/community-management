package org.management.core.infrastructure.repository.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "apply_active")
public class ApplyActive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 0:外出，1:进入
     */
    @Column(name = "active_type")
    private Integer activeType;

    /**
     * 外出/进入时间
     */
    @Column(name = "active_time")
    private Date activeTime;

    /**
     * 申请原因
     */
    private String reason;

    /**
     * 亲戚朋友姓名
     */
    @Column(name = "family_friend")
    private String familyFriend;

    /**
     * 状态，0未审核/1审核通过
     */
    private Integer state;

    /**
     * create time
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * update time
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
     * 获取0:外出，1:进入
     *
     * @return active_type - 0:外出，1:进入
     */
    public Integer getActiveType() {
        return activeType;
    }

    /**
     * 设置0:外出，1:进入
     *
     * @param activeType 0:外出，1:进入
     */
    public void setActiveType(Integer activeType) {
        this.activeType = activeType;
    }

    /**
     * 获取外出/进入时间
     *
     * @return active_time - 外出/进入时间
     */
    public Date getActiveTime() {
        return activeTime;
    }

    /**
     * 设置外出/进入时间
     *
     * @param activeTime 外出/进入时间
     */
    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    /**
     * 获取申请原因
     *
     * @return reason - 申请原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置申请原因
     *
     * @param reason 申请原因
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取亲戚朋友姓名
     *
     * @return family_friend - 亲戚朋友姓名
     */
    public String getFamilyFriend() {
        return familyFriend;
    }

    /**
     * 设置亲戚朋友姓名
     *
     * @param familyFriend 亲戚朋友姓名
     */
    public void setFamilyFriend(String familyFriend) {
        this.familyFriend = familyFriend;
    }

    /**
     * 获取状态，0未审核/1审核通过
     *
     * @return state - 状态，0未审核/1审核通过
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态，0未审核/1审核通过
     *
     * @param state 状态，0未审核/1审核通过
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取create time
     *
     * @return create_time - create time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置create time
     *
     * @param createTime create time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取update time
     *
     * @return update_time - update time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置update time
     *
     * @param updateTime update time
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}