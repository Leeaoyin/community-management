package org.management.core.infrastructure.repository.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 住户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * email
     */
    private String email;

    /**
     * phone
     */
    private String phone;

    /**
     * 房间编号
     */
    @Column(name = "room_number")
    private Integer roomNumber;

    /**
     * 健康状态：0康/1病
     */
    @Column(name = "health_state")
    private Byte healthState;

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
     * 获取住户姓名
     *
     * @return user_name - 住户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置住户姓名
     *
     * @param userName 住户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取email
     *
     * @return email - email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取phone
     *
     * @return phone - phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置phone
     *
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取房间编号
     *
     * @return room_number - 房间编号
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * 设置房间编号
     *
     * @param roomNumber 房间编号
     */
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * 获取健康状态：0康/1病
     *
     * @return health_state - 健康状态：0康/1病
     */
    public Byte getHealthState() {
        return healthState;
    }

    /**
     * 设置健康状态：0康/1病
     *
     * @param healthState 健康状态：0康/1病
     */
    public void setHealthState(Byte healthState) {
        this.healthState = healthState;
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