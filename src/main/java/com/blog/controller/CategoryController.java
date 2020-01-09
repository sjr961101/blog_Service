package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.Category;
import com.blog.service.CategoryService;
import com.blog.util.ParamMap;
import com.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "a/category/list", method = RequestMethod.POST)
    public Response insert(@RequestBody Category category) {
        category.setCreateTime(String.valueOf(new Date().getTime()));
        try{
            if(categoryService.insert(category)!=1) {
                throw new NullPointerException();
            }
        }catch (NullPointerException e){
            return Response.newResponse().put("code",666).put("message","发布失败");
        }
        return Response.newResponse();
    };
}
