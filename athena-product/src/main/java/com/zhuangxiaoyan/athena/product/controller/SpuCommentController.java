package com.zhuangxiaoyan.athena.product.controller;

import com.zhuangxiaoyan.athena.product.entity.SpuCommentEntity;
import com.zhuangxiaoyan.athena.product.service.SpuCommentService;
import com.zhuangxiaoyan.common.utils.PageUtils;
import com.zhuangxiaoyan.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 商品评价
 *
 * @author xjl
 * @email 18279148786@163.com
 * @date 2022-03-08 22:51:37
 */
@RestController
@RequestMapping("product/spucomment")
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("product:spucomment:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = spuCommentService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("product:spucomment:info")
    public R info(@PathVariable("id") Long id) {
        SpuCommentEntity spuComment = spuCommentService.getById(id);

        return R.ok().put("spuComment", spuComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("product:spucomment:save")
    public R save(@RequestBody SpuCommentEntity spuComment) {
        spuCommentService.save(spuComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("product:spucomment:update")
    public R update(@RequestBody SpuCommentEntity spuComment) {
        spuCommentService.updateById(spuComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("product:spucomment:delete")
    public R delete(@RequestBody Long[] ids) {
        spuCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
