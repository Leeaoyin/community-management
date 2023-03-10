# community-management

### <u>一个后台管理系统</u>


<img src="https://img.shields.io/badge/-spring-brightgreen"> <img src="https://img.shields.io/badge/-Springboot-brightgreen">
<img src="https://img.shields.io/badge/-SpringMVC-brightgreen">
<img src="https://img.shields.io/badge/-mybatis-brightgreen">
<img src="https://img.shields.io/badge/-tk.mapper-brightgreen">
<img src="https://img.shields.io/badge/-JWTtoken-brightgreen">
<img src="https://img.shields.io/badge/-Dockerfile-brightgreen">


## 接口设计
### 1、权限接口
#### 登录
url：/api/login
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| username | string | true | 用户名 |
| password | string | true | 密码 |

请求模板：
```json
{
    "username":"root",
    "password":123456
}
```
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| userId | int | id |
| userType | byte | 0：管理员，1：普通用户 |
| token | string | 无 |

响应模板：
```json
{
    "data": {
        "userId": 1,
        "userType": 1,
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJ0b2tlbl9"
    },
    "message": "success",
    "code": 200
}
```

#### 注册
url：/api/register
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| username | string | true | 用户名 |
| password | string | true | 密码 |
| usertype | int | true | 0：管理员，1：普通用户 |

请求模板：
```json
{
    "username":"admin",
    "password":"123456",
    "usertype":0
}
```
响应数据：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| id | int | 用户id |
| userName | string | 用户名 |
| userPassword | string | 密码 |
| userType | int | 用户类型 |

响应字段：
```json
{
    "data": {
        "id": 3,
        "userName": "admin",
        "userPassword": "123456",
        "userType": 0,
        "createTime": "2023-02-10T11:27:22.394+0000",
        "updateTime": null
    },
    "message": "success",
    "code": 200
}
```

### 2、出门/到访申请
url：/api/active
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| activetype | int | true | 0:外出，1:亲友进入 |
| activetime | date | true | 外出/进入时间 |
| reason | string | true | 外出/进入原因 |
| familyfriend | list | false | 亲戚朋友姓名 |

请求模板：
外出：
```json
[
    {
    "activetype": 0,
    "activetime": "2023-10-26T11:47:12.000Z",
    "reason": "外出采购"
    }
]
```
到访：
```json
[
    {
    "activetype": 1,
    "activetime": "2023-10-26T11:47:12.000Z",
    "reason": "z走访",
  	"familyfriend": ["zhang","lee","wang"]
    }
]
```
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| success | bool | 是否成功 |

响应模板：
```json
{
    "code": 200,
    "data": {
        "success": true
    },
    "message": "success"
}
```
##### 获取当前用户申请列表
url：/api/getActives
method：GET
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| activetime | date | 活动时间 |
| createtime | date | 创建时间 |
| reason | string | 申请原因 |
| state | int | 状态，0未审核/1审核通过 |

响应模板：
```json
{
    "code": 200,
    "data": [
        {
            "activeTime": "2023-10-26 19:47:12",
            "activeType": 0,
            "createTime": "2023-02-12 18:20:17",
            "familyFriend": "",
            "id": 6,
            "reason": "ceshi",
            "state": 0,
            "updateTime": "",
            "userId": 3
        },
      	{
            "activeTime": "2023-10-26 19:47:12",
            "activeType": 0,
            "createTime": "2023-02-13 22:03:04",
            "familyFriend": "null",
            "id": 16,
            "reason": "出去买烧烤",
            "state": 0,
            "updateTime": "",
            "userId": 3
        }
    ],
    "message": "success"
}
```
### 3、物资申请
url：/api/material
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| materialname | string | true | 物品名称 |
| num | int | true | 物品数量 |

请求模板：
```json
[
    {
  	"materialname": "毛巾",
    "num":1
    },
  {
  	"materialname": "梳子",
    "num":2
    },
  {
  	"materialname": "洗衣液",
    "num":1
    }
]
```
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| success | bool | 是否成功 |

响应模板：
```json
{
    "code": 200,
    "data": {
        "success": true
    },
    "message": "success"
}
```

##### 获取当前用户申请列表
url：/api/getMaterials
method：GET
响应模板：
```json
{
    "code": 200,
    "data": [
        {
            "createTime": "2023-02-12 20:02:32",
            "id": 1,
            "materialName": "毛巾",
            "num": 1,
            "updateTime": "",
            "userId": 2
        },
        {
            "createTime": "2023-02-12 20:02:32",
            "id": 2,
            "materialName": "梳子",
            "num": 2,
            "updateTime": "",
            "userId": 2
        },
        {
            "createTime": "2023-02-12 20:02:32",
            "id": 3,
            "materialName": "洗衣液",
            "num": 1,
            "updateTime": "",
            "userId": 2
        }
    ],
    "message": "success"
}
```

### 4、疫苗预约
url：/api/orderVaccine
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| phone | string | true | 电话 |
| vaccinename | string | true | 疫苗名称 |
| ordertime | date | true | 预约时间 |

请求模板：
```json
{
    "phone":"10086",
    "vaccinename":"瞎打疫苗",
    "ordertime":"2023-10-26T11:47:12.000Z"
}
```
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| success | bool | 添加成功 |

响应模板：
```json
{
    "code": 200,
    "data": {
        "success": true
    },
    "message": "success"
}
```

##### 获取当前用户预约列表
url：/api/getOrderedVaccine
method：GET
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| state | Int | 0未过期/1已过期 |
| ordertime | date | 预约时间 |
| phone | string | 预约手机号 |
| vaccinename | string | 所预约名称 |

响应模板：
```json
{
    "code": 200,
    "data": [
        {
            "ordertime": "2023-10-26 19:47:12",
            "phone": "10086",
            "state": 0,
            "vaccinename": "科兴疫苗"
        },
        {
            "ordertime": "2023-10-26 19:47:12",
            "phone": "10086",
            "state": 0,
            "vaccinename": "瞎打疫苗"
        }
    ],
    "message": "success"
}
```
### 5、添加用户信息
url：/api/addUserInfo
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| email | string | true | 邮箱 |
| phone | string | true | 电话 |
| roomnumber | int | true | 房间号 |
| healthstate | int | true | 状态：0康/1病 |

请求模板：
```json
{
    "email": "test@jksh.com",
    "phone": "12345917048",
    "roomnumber": 522,
    "healthstate": 0
}
```
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| success | bool | 添加成功 |

响应模板：
```json
{
    "code": 200,
    "data": {
        "success": true
    },
    "message": "success"
}
```

### 6、健康上报
url：/api/reportHealth
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| healthstate | int | true | 0康/1病 |

请求模板：
```json
{
    "healthstate": 1
}
```
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| success | bool | 上报成功 |

响应模板：
```json
{
    "code": 200,
    "data": {
        "success": true
    },
    "message": "success"
}
```

### 7、出门/到访审批
##### 批量审批

url：/api/verifyActives
method：POST
请求参数：

| 字段 | 类型 | 必须 | 备注 |
| --- | --- | --- | --- |
| id | int | true | 活动id |

请求模板：
```json
[
    {
        "id":11
    },
    {
        "id":14
    },
    {
        "id":15
    }
]
```
响应字段：

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| success | bool | 是否批准 |

响应模板：
```json
{
    "code": 200,
    "data": {
        "success": true
    },
    "message": "success"
}
```

##### 

## 

