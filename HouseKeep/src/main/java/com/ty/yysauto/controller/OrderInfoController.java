package com.ty.yysauto.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.xpath.internal.objects.XObject;
import com.ty.yysauto.dao.OrderInfoMapper;
import com.ty.yysauto.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderInfoController {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @RequestMapping(value = "/selcount",method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Integer> selcount() throws IOException {
        QueryWrapper<OrderInfo> backlogWrapper = new QueryWrapper<>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowdate = sdf.format(date);
        backlogWrapper.eq("firsttime",nowdate).eq("firststatus",0).or(i->i.eq("secondtime",nowdate).eq("secondstatus",0)).or(i->i.eq("thirdtime",nowdate).eq("thirdstatus",0)).or(i->i.eq("fourthtime",nowdate).eq("fourthstatus",0));

        QueryWrapper<OrderInfo> collectionWrapper = new QueryWrapper<>();
        Map<String,Object> filtermap = new HashMap<String, Object>();
        filtermap.put("firststatus","1");
        filtermap.put("secondstatus","1");
        filtermap.put("thirdstatus","1");
        filtermap.put("fourthstatus","1");
        filtermap.put("orderstatus","0");
        collectionWrapper.allEq(filtermap,true);

        QueryWrapper<OrderInfo> finishWrapper = new QueryWrapper<>();
        finishWrapper.eq("orderstatus","1");

        Integer backlogcount = orderInfoMapper.selectCount(backlogWrapper);
        Integer allcount = orderInfoMapper.selectCount(null);
        Integer collectioncount = orderInfoMapper.selectCount(collectionWrapper);
        Integer finishcount = orderInfoMapper.selectCount(finishWrapper);

        Map<String,Integer> map =new  HashMap<String,Integer>();
        map.put("backlogcount",backlogcount);
        map.put("allcount",allcount);
        map.put("collectioncount",collectioncount);
        map.put("finishcount",finishcount);
        return map;
    }



    @RequestMapping(value = "/selorderinfo",method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> selorderinfo(HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {
        QueryWrapper<OrderInfo> Wrapper = new QueryWrapper<>();
        List<OrderInfo> orderinfoList = new ArrayList<OrderInfo>();
        Integer orderinfoCount = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowdate = sdf.format(date);
        String type = request.getParameter("type") == null ? "" : request.getParameter("type");
        if (type.equals("backlog")){
            Wrapper.eq("firsttime",nowdate).eq("firststatus",0).or(i->i.eq("secondtime",nowdate).eq("secondstatus",0)).or(i->i.eq("thirdtime",nowdate).eq("thirdstatus",0)).or(i->i.eq("fourthtime",nowdate).eq("fourthstatus",0));
            orderinfoList = orderInfoMapper.selectList(Wrapper);
//            for (OrderInfo orIn : orderinfoList){
//                orIn.setFirsttime(sdf.parse(orIn.getFirsttime().toString()));
//                System.out.println(orIn.getFirsttime());
//            }
            orderinfoCount = orderinfoList.size();
        }else if(type.equals("all")){
            orderinfoList = orderInfoMapper.selectList(null);
            orderinfoCount = orderinfoList.size();
        }else if(type.equals("collection")){
            Map<String,Object> filtermap = new HashMap<String, Object>();
            filtermap.put("firststatus","1");
            filtermap.put("secondstatus","1");
            filtermap.put("thirdstatus","1");
            filtermap.put("fourthstatus","1");
            filtermap.put("orderstatus","0");
            Wrapper.allEq(filtermap,true);
            orderinfoList = orderInfoMapper.selectList(Wrapper);
            orderinfoCount = orderinfoList.size();
        }else if(type.equals("finish")){
            Wrapper.eq("orderstatus",1);
            orderinfoList = orderInfoMapper.selectList(Wrapper);
            orderinfoCount = orderinfoList.size();
        }
        Map<String,Object> map =new  HashMap<String,Object>();
        map.put("code",200);
        map.put("msg","查询成功");
        map.put("count",orderinfoCount);
        map.put("data",orderinfoList);
        System.out.println(map);
        return map;
    }

//    @RequestMapping(value = "/user/{key}",method = {RequestMethod.GET})
//    @ResponseBody
//    public String selone(@PathVariable("key") String username) throws IOException {
//        String result;
//        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.in("name",username);
//        User onlyUser = orderInfoMapper.selectOne(queryWrapper);
//        result = onlyUser.getEndtime();
//        return "[[\""+result+"\"]]";
//    }
//
//    @RequestMapping(value = "/deleteusers",method = {RequestMethod.POST})
//    @ResponseBody
//    public boolean deleteUsers(@RequestParam String userid){
//        boolean re;
//        int renum = orderInfoMapper.deleteById(userid);
//
//        if (renum!=0){
//            re = true;
//        }else {
//            re = false;
//        }
//        return re;
//    }
//
//    @RequestMapping(value = "/save",method = {RequestMethod.POST})
//    @ResponseBody
//    public boolean save(HttpServletResponse response, HttpServletRequest request){
//        boolean re;
//        int renum = 0;
//        User user = new User();
//        String userid = request.getParameter("id") == null ? "" : request.getParameter("id");
//        String username = request.getParameter("username") == null ? "" : request.getParameter("username");
//        String endtime = request.getParameter("endtime") == null ? "" : request.getParameter("endtime");
//        String endtimes = endtime.replace("-","").replace(" ","").replace(":","");
//        if (username!="" && endtime!=""){
//            user.setId(userid);
//            user.setUsername(username);
//            user.setEndtime(endtimes);
//            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//            queryWrapper.in("id",userid);
//            Integer selmun = orderInfoMapper.selectCount(queryWrapper);
//            if (selmun==0){
//                renum = orderInfoMapper.insert(user);
//            }else {
//                renum = orderInfoMapper.updateById(user);
//            }
//        }
//
//        if (renum!=0){
//            re = true;
//        }else {
//            re = false;
//        }
//        return re;
//    }
}
