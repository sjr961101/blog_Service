package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.CategoryService;
import com.blog.util.LogUtils;
import com.blog.util.ParamMap;
import com.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
/**
 * @Description: 分类方法
 * @Author: 沈俊仁
 * @Date:  2020.01
*/
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "w/category/list", method = RequestMethod.POST)
    /**
     * @Description todo 查询分类
     * @param paramMap
     * @return com.blog.util.Response
    */
    public Response getList(@RequestBody ParamMap paramMap) {
        List<Category> list=null;
        list=categoryService.selectList(paramMap);
        if(list!=null){
            return Response.setResponse("categoryList",list);
        }
        //返回内容
        return Response.failResponse("查询分类失败");
    };

    @RequestMapping(value = "a/category/add", method = RequestMethod.POST)
    /**
     * @Description todo 添加分类
     * @param category
     * @return com.blog.util.Response
    */
    public Response insert(@RequestBody Category category) {
        String time=String.valueOf(new Date().getTime());
        category.setCategoryId("category"+time);
        category.setCreateTime(time);
        category.setUpdateTime(time);
        try{
            if(categoryService.insert(category)!=1) {
                throw new NullPointerException();
            }
        }catch (NullPointerException e){
            return Response.failResponse("添加分类失败");
        }
        return Response.okResponse();
    };

    @RequestMapping(value = "a/category/modify", method = RequestMethod.POST)
    /**
     * @Description todo 修改分类
     * @param category
     * @return com.blog.util.Response
    */
    public Response update(@RequestBody Category category) {
        try{
            switch (categoryService.updateById(category)){
                case -1:
                    throw new SQLException();
                case 0:
                    throw new NullPointerException();
            }

        }catch (SQLException e){
            LogUtils.debug(this.getClass().getName()+"update");
            return Response.failResponse("分类修改失败,数据错误");
        }catch (NullPointerException e){
            return Response.failResponse("分类修改失败，未找到该分类");
        }
        return Response.okResponse();
    };

    @RequestMapping(value = "a/category/delete", method = RequestMethod.POST)
    /**
     * @Description TODO 删除分类
     * @param category
     * @return com.blog.util.Response
    */
    public Response delete(@RequestBody Category category) {
        category.setStatus((short) 1);
        category.setUpdateTime(String.valueOf(new Date().getTime()));
        try{
            // 第一次删除将分类状态变为删除状态，第二次删除则删掉记录
            switch (categoryService.deleteCategory(category)){
                case -1:
                    throw new SQLException();
                case 0:
                    throw new NullPointerException();
            }
        }catch (SQLException e){
            LogUtils.debug(this.getClass().getName()+"update");
            return Response.failResponse("分类删除失败,数据错误");
        }catch (NullPointerException e){
            return Response.failResponse("分类删除失败，未找到该分类");
        }
        return Response.okResponse();
    };
}
