# 谷粒商城-后台管理系统-API文档

       程序源码论坛-1024，网址 www.cx1314.cn  仅分享最流行最优质的IT资源！	
    
       不同于其他论坛平台，这里只有精品、稀有资源，已泛滥、已过时、垃圾资源不录入！
    
       Java,前端,python,人工智能,大数据,云计算...持续更新资源-最新完整且均不加密、、、

活动线报，宅男福利，最新大片...

       程序员的新大陆-更新最快的IT资源社区！开发者必备平台！
    
       欢迎访问：www.cx1314.cn      百度搜索->  程序源码论坛

## 2. 商品系统

### 2.1. 商品分类

**分类查询**：

请求地址：/pms/category/parent/{parentId}

请求方式：GET

请求参数：

| 请求参数名 | 参数说明 | 值类型 | 是否必须 | 可取值                        |
| ---------- | -------- | ------ | -------- | ----------------------------- |
| parentId   | 父节点id | long   | 是       | -1：查询所有，0：查询一级节点 |

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": [
    {
      "id": 1,
      "name": "图书、音像、电子书刊",
      "parentId": 0,
      "status": 1,
      "sort": 0,
      "icon": null,
      "unit": null
    }
  ]
}
```

---

### 2.2. 规格参数相关

#### 2.2.1. 查询三级分类的分组

请求地址：/pms/attrgroup/category/{cid}

请求方式：GET

请求参数：

| 请求参数名 | 参数说明   | 值类型 | 是否必须 |
| ---------- | ---------- | ------ | -------- |
| cid        | 三级分类id | long   | 是       |

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": [
    {
      "id": 0,
      //属性分组id
      "name": "string",
      //属性分组名
      "sort": 0,
      //分类id
      "icon": "string",
      //分组描述
      "categoryId": "string",
      //分组图标
      "sort": 0
      //分组顺序
    }
  ]
}
```

#### 2.2.2. 查询分类下的规格参数

请求地址：/pms/attr/category/{cid}?type=0&searchType=1

请求方式：GET

请求参数：

| 请求参数名 | 参数说明     | 值类型 | 是否必须                 |
| ---------- | ------------ | ------ | ------------------------ |
| cid        | 分类id       | long   | 是                       |
| type       | 是否基本属性 | int    | 0-销售属性，1-基本属性   |
| searchType | 是否搜索参数 | int    | 0-非搜索参数，1-搜索参数 |

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": [
    {
      "id": 25,
      "name": "电池容量",
      "searchType": 1,
      "icon": "http://gulimall.oss-cn-shanghai.aliyuncs.com/2019-07-24/336c39bb-2c45-40c8-8e38-abe607540bd4_u43.png",
      "valueSelect": "3000,4000,5000",
      "type": 1,
      "enable": 1,
      "groupId": 20,
      "categoryId": 225,
      "showDesc": 1
    }
  ]
}
```

---

------

#### 2.2.3. 查询组下的规格参数

请求地址：/pms/attr/group/{gid}

请求方式：GET

字段说明

| 请求参数名 | 参数说明 | 值类型 | 是否必须 |
| :--------- | -------- | ------ | -------- |
| gid        | 分组id   | Long   | 是       |

正确响应：

```json
{
  "code": 0,
  "msg": "",
  "data": [
    {
      "id": 25,
      "name": "电池容量",
      "searchType": 1,
      "icon": "http://gulimall.oss-cn-shanghai.aliyuncs.com/2019-07-24/336c39bb-2c45-40c8-8e38-abe607540bd4_u43.png",
      "valueSelect": "3000,4000,5000",
      "type": 1,
      "enable": 1,
      "groupId": 20,
      "categoryId": 225,
      "showDesc": 1
    }
  ]
}
```

------

#### 2.2.4. 查询分类下的组及规格参数

请求地址：/pms/attrgroup/withattrs/{catId}

请求方式：GET

请求参数：

| 请求参数名 | 参数说明   | 值类型 | 是否必须 |
| ---------- | ---------- | ------ | -------- |
| catId      | 三级分类id | long   | 是       |

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": [
    {
      "id": 1,
      "name": "主体",
      "sort": null,
      "remark": "大萨达发发发",
      "icon": null,
      "categoryId": 225,
      "attrEntities": [
        {
          "id": 25,
          "name": "大萨达222",
          "searchType": 1,
          "valueType": 1,
          "icon": "http://gulimall.oss-cn-shanghai.aliyuncs.com/2019-07-24/336c39bb-2c45-40c8-8e38-abe607540bd4_u43.png",
          "valueSelect": "13213,23231,3324",
          "type": 1,
          "enable": 1,
          "categoryId": 225,
          "groupId": 20,
          "showDesc": 1
        }
      ]
    }
  ]
}
```

---

### 2.3. SPU相关

通用数据模型

```json
{
  "id": 4,
  // spuId
  "spuName": "vivi",
  //商品名字
  "spuDescription": "华为",
  //商品描述
  "catalogId": 225,
  //所在分类id
  "brandId": 0,
  //所属品牌id
  "publishStatus": 1,
  //是否发布  0-未发布  1-已发布
  "createTime": "2019-07-17 00:00:00",
  //创建日期
  "uodateTime": "2019-07-17 00:00:00"
  //更新日期
}
```

#### 2.3.1. 查询spu列表

按照分类id分页查询商品列表

请求地址：pms/spu/category/{categoryId}

请求方式：GET

请求参数：

| 请求参数名   | 参数说明     | 值类型       | 是否必须                                   |
| ------------ | ------------ | ------------ | ------------------------------------------ |
| 通用分页参数 | 通用分页参数 | 通用分页参数 | 通用分页参数key就是spuid,spuname的检索条件 |
| categoryId   | 分类id       | long         | 是，0-查询全部分类；其他-查询指定分类stat  |

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": {
    "total": 15,
    "pageSize": 10,
    "totalPage": 2,
    "pageNum": 1,
    "list": [
      {
        "id": 4,
        "name": "vivo",
        "catalogId": 225,
        "brandId": 0,
        "publishStatus": 1,
        "createTime": "2019-07-17 00:00:00",
        "updateTime": "2019-07-17 00:00:00"
      }
    ]
  }
}
```

------

### 2.4. SKU相关

#### 2.4.1. 查询spu的所有sku信息

请求地址：/pms/sku/spu/{spuId}

请求方式：GET

请求参数：

| 请求参数名 | 参数说明 | 值类型 | 是否必须     |
| ---------- | -------- | ------ | ------------ |
| spuId      | spuId    | long   | 是，路径变量 |

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": [
    {
      "id": 1,
      "spuId": 1,
      "name": "华为白色128g",
      "categoryId": null,
      "brandId": null,
      "defaultImg": null,
      "title": null,
      "subtitle": null,
      "price": 1999,
      "weight": null
    },
    {
      "id": 2,
      "spuId": 1,
      "name": "华为黑色128g",
      "categoryId": null,
      "brandId": null,
      "defaultImg": null,
      "title": null,
      "subtitle": null,
      "price": 1999,
      "weight": null
    }
  ]
}
```

---

#### 2.4.2. 获取某个sku的库存信息

请求地址：/wms/waresku/sku/{skuId}

请求方式：GET

请求参数：

| 请求参数名 | 参数说明 | 值类型 | 是否必须 |
| ---------- | -------- | ------ | -------- |
| skuId      | skuId    | long   | 是       |

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": [
    {
      "id": 3,
      "skuId": 2,
      //skuId
      "wareId": 2,
      //所在仓库id
      "stock": 10,
      //库存数量
      "skuName": null,
      //sku的名字
      "stockLocked": 0,
      //锁定的库存
      "sales": 0
    },
    {
      "id": 4,
      "skuId": 2,
      "wareId": 1,
      "stock": 20,
      "skuName": null,
      "stockLocked": 0,
      "sales": 0
    }
  ]
}
```

---

#### 2.4.3. 新增商品

请求地址：/pms/spu/save

请求方式：POST

请求参数：

```json
{
  "spuName": "string",
  //商品名字
  "brandId": 0,
  //品牌id
  "catalogId": 0,
  //分类id
  "publishStatus": 0,
  //发布状态
  "spuDescription": "string",
  //spu描述
  "spuImages": [
    "string"
  ],
  //spu图片
  "baseAttrs": [
    //spu的基本属性
    {
      "attrId": 0,
      //属性id
      "attrName": "string",
      //属性名
      "valueSelected": [
        "string"
      ]
      //属性值
    }
  ],
  "skus": [
    //sku信息
    {
      "name": "",
      //sku名字
      "title": "",
      //sku标题
      "subtitle": "",
      //sku副标题
      "weight": 0,
      //sku重量
      "price": 0,
      //商品价格
      "images": [
        "string"
      ],
      //sku图片
      "saleAttrs": [
        //销售属性组合
        {
          "attrId": 0,
          //属性id
          "attrValue": "string"
          //属性值
        }
      ],
      "buyBounds": 0,
      //赠送的购物积分 
      "growBounds": 0,
      //赠送的成长积分
      "work": [
        0,
        1,
        1,
        0
      ],
      //积分生效情况
      "fullCount": 0,
      //满几件
      "discount": 0,
      //打几折
      "ladderAddOther": 0,
      //阶梯价格是否可以与其他优惠叠加
      "fullPrice": 0,
      //满多少
      "reducePrice": 0,
      //减多少
      "fullAddOther": 0
      //满减是否可以叠加其他优惠
    }
  ]
}
```

正确响应：

```json
{
  "code": 0,
  "msg": "success",
  "data": ""
}
```

---

## 3. 订单系统

## 4. 库存系统

## 5. 用户系统

## 6. 营销系统



