package org.management.core.infrastructure.repository.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "vaccine_order")
public class VaccineOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 预约人ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 预约人手机号
     */
    private String phone;

    /**
     * 预约疫苗名称
     */
    @Column(name = "vaccine_name")
    private String vaccineName;

    /**
     * 预约时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 是否过期，0未过期/1已过期
     */
    private Byte state;

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
     * 获取预约人ID
     *
     * @return user_id - 预约人ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置预约人ID
     *
     * @param userId 预约人ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取预约人手机号
     *
     * @return phone - 预约人手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置预约人手机号
     *
     * @param phone 预约人手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取预约疫苗名称
     *
     * @return vaccine_name - 预约疫苗名称
     */
    public String getVaccineName() {
        return vaccineName;
    }

    /**
     * 设置预约疫苗名称
     *
     * @param vaccineName 预约疫苗名称
     */
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    /**
     * 获取预约时间
     *
     * @return order_time - 预约时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置预约时间
     *
     * @param orderTime 预约时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取是否过期，0未过期/1已过期
     *
     * @return state - 是否过期，0未过期/1已过期
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置是否过期，0未过期/1已过期
     *
     * @param state 是否过期，0未过期/1已过期
     */
    public void setState(Byte state) {
        this.state = state;
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