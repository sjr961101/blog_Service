package com.blog.controller;

import com.blog.model.Article;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "w/category/list", method = RequestMethod.POST)
    public Response getList(@RequestBody ParamMap paramMap) {
        List<Category> list=null;
        list=categoryService.selectList(paramMap);
        Response response=Response.newResponse();
        response.put("categoryList",list);
        return response;
    };

    @RequestMapping(value = "a/category/add", method = RequestMethod.POST)
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
            return Response.newResponse().put("code",666).put("message","发布失败");
        }
        return Response.newResponse();
    };

    @RequestMapping(value = "a/category/modify", method = RequestMethod.POST)
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
            return Response.newResponse().put("code",666).put("message","分类修改失败,数据错误");
        }catch (NullPointerException e){
            return Response.newResponse().put("code",666).put("message","分类修改失败，未找到该分类");
        }
        return Response.newResponse();
    };

    @RequestMapping(value = "a/category/delete", method = RequestMethod.POST)
    public Response delete(@RequestBody Category category) {
        category.setStatus((short) 1);
        try{
            switch (categoryService.updateById(category)){
                case -1:
                    throw new SQLException();
                case 0:
                    throw new NullPointerException();
            }

        }catch (SQLException e){
            LogUtils.debug(this.getClass().getName()+"update");
            return Response.newResponse().put("code",666).put("message","分类删除失败,数据错误");
        }catch (NullPointerException e){
            return Response.newResponse().put("code",666).put("message","分类删除失败，未找到该分类");
        }
        return Response.newResponse();
    };
}
