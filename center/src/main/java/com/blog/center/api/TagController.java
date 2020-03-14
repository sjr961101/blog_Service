package com.blog.center.api;


import com.blog.center.service.TagService;
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

//    @RequestMapping(value = "w/tag/list", method = RequestMethod.POST)
//    /**
//     * @Description todo 查询标签信息
//     * @param paramMap  页码，显示行数
//     * @return com.blog.util.Response
//    */
//    public Response getList(@RequestBody ParamMap paramMap) {
//        List<Tag> list=null;
//        list=tagService.selectList(paramMap);
//        if(list != null){
//            return Response.setResponse("tagList",list);
//        }
//        return Response.failResponse("查询失败");
//    };
//
//    @RequestMapping(value = "a/tag/add", method = RequestMethod.POST)
//    /**
//     * @Description todo 添加标签信息
//     * @param tag
//     * @return com.blog.util.Response
//    */
//    public Response insert(@RequestBody Tag tag) {
//        String time=String.valueOf(new Date().getTime());
//        tag.setTagId("tag"+time);
//        tag.setUpdateTime(time);
//        tag.setCreateTime(time);
//        try{
//            if(tagService.insert(tag)!=1) {
//                throw new NullPointerException();
//            }
//        }catch (NullPointerException e){
//            return Response.failResponse("标签添加失败");
//        }
//        return Response.okResponse();
//    };
//
//    @RequestMapping(value = "a/tag/modify", method = RequestMethod.POST)
//    /**
//     * @Description todo 修改标签
//     * @param tag
//     * @return com.blog.util.Response
//    */
//    public Response update(@RequestBody Tag tag) {
//        try{
//            switch (tagService.update(tag)){
//                case -1:
//                    throw new SQLException();
//                case 0:
//                    throw new NullPointerException();
//            }
//        }catch (SQLException e){
//            LogUtils.debug(this.getClass().getName()+"update");
//            return Response.failResponse("标签修改失败,数据错误");
//        }catch (NullPointerException e){
//            return Response.failResponse("标签修改失败，未找到该分类");
//        }
//        return Response.okResponse();
//    };
//
//    @RequestMapping(value = "a/tag/delete", method = RequestMethod.POST)
//    /**
//     * @Description todo 删除标签
//     * @param tag
//     * @return com.blog.util.Response
//    */
//    public Response delete(@RequestBody Tag tag) {
//        tag.setStatus((short) 1);
//        tag.setUpdateTime(String.valueOf(new Date().getTime()));
//        try{
//            switch (tagService.delete(tag)){
//                case -1:
//                    throw new SQLException();
//                case 0:
//                    throw new NullPointerException();
//            }
//
//        }catch (SQLException e){
//            LogUtils.debug(this.getClass().getName()+"update");
//            return Response.failResponse("标签删除失败,数据错误");
//        }catch (NullPointerException e){
//            return Response.failResponse("标签删除失败，未找到该分类");
//        }
//        return Response.okResponse();
//    };
}
