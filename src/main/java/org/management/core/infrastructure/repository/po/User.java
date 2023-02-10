package org.management.core.infrastructure.repository.po;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * user id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * user name
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * user password
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 0:administrator，1:ordinary user
     */
    @Column(name = "user_type")
    private Byte userType;

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
     * 获取user id
     *
     * @return id - user id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置user id
     *
     * @param id user id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取user name
     *
     * @return user_name - user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置user name
     *
     * @param userName user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取user password
     *
     * @return user_password - user password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置user password
     *
     * @param userPassword user password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取0:administrator，1:ordinary user
     *
     * @return user_type - 0:administrator，1:ordinary user
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * 设置0:administrator，1:ordinary user
     *
     * @param userType 0:administrator，1:ordinary user
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
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