package com.blog.controller;

import com.blog.model.Tag;
import com.blog.service.TagService;
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
 * @Description: 标签方法
 * @Author: 沈俊仁
 * @Date: 2020.01
*/
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "w/tag/list", method = RequestMethod.POST)
    /**
     * @Description todo 查询标签信息
     * @param paramMap  页码，显示行数
     * @return com.blog.util.Response
    */
    public Response getList(@RequestBody ParamMap paramMap) {
        List<Tag> list=null;
        list=tagService.selectList(paramMap);
        Response response=Response.newResponse();
        response.put("tagList",list);
        return response;
    };

    @RequestMapping(value = "a/tag/add", method = RequestMethod.POST)
    /**
     * @Description todo 添加标签信息
     * @param tag
     * @return com.blog.util.Response
    */
    public Response insert(@RequestBody Tag tag) {
        String time=String.valueOf(new Date().getTime());
        tag.setTagId("tag"+time);
        tag.setUpdateTime(time);
        tag.setCreateTime(time);
        try{
            if(tagService.insert(tag)!=1) {
                throw new NullPointerException();
            }
        }catch (NullPointerException e){
            return Response.newResponse().put("code",666).put("message","标签添加失败");
        }
        return Response.newResponse();
    };

    @RequestMapping(value = "a/tag/modify", method = RequestMethod.POST)
    /**
     * @Description todo 修改标签
     * @param tag
     * @return com.blog.util.Response
    */ 
    public Response update(@RequestBody Tag tag) {
        try{
            switch (tagService.update(tag)){
                case -1:
                    throw new SQLException();
                case 0:
                    throw new NullPointerException();
            }
        }catch (SQLException e){
            LogUtils.debug(this.getClass().getName()+"update");
            return Response.newResponse().put("code",666).put("message","标签修改失败,数据错误");
        }catch (NullPointerException e){
            return Response.newResponse().put("code",666).put("message","标签修改失败，未找到该分类");
        }
        return Response.newResponse();
    };

    @RequestMapping(value = "a/tag/delete", method = RequestMethod.POST)
    /**
     * @Description todo 删除标签
     * @param tag
     * @return com.blog.util.Response
    */ 
    public Response delete(@RequestBody Tag tag) {
        tag.setStatus((short) 1);
        try{
            switch (tagService.update(tag)){
                case -1:
                    throw new SQLException();
                case 0:
                    throw new NullPointerException();
            }

        }catch (SQLException e){
            LogUtils.debug(this.getClass().getName()+"update");
            return Response.newResponse().put("code",666).put("message","标签删除失败,数据错误");
        }catch (NullPointerException e){
            return Response.newResponse().put("code",666).put("message","标签删除失败，未找到该分类");
        }
        return Response.newResponse();
    };
}
