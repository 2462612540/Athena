package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.ProductAttrValueEntity;
import com.zhuangxiaoyan.athena.product.service.ProductAttrValueService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * spu属性值
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-08 22:51:37
 */
@RestController
@RequestMapping("product/productattrvalue")
public class ProductAttrValueController {
    @Autowired
    private ProductAttrValueService productAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:productattrvalue:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = productAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("product:productattrvalue:info")
    public R info(@PathVariable("id") Long id) {
        ProductAttrValueEntity productAttrValue = productAttrValueService.getById(id);

        return R.ok().put("productAttrValue", productAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:productattrvalue:save")
    public R save(@RequestBody ProductAttrValueEntity productAttrValue) {
        productAttrValueService.save(productAttrValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:productattrvalue:update")
    public R update(@RequestBody ProductAttrValueEntity productAttrValue) {
        productAttrValueService.updateById(productAttrValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:productattrvalue:delete")
    public R delete(@RequestBody Long[] ids) {
        productAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
