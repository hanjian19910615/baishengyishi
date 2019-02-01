package com.zf.demo4jsp.controller.FrontEnd;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.MessageLists;
import com.zf.demo4jsp.entity.Slideshow;

import com.zf.demo4jsp.entity.myEntity.EvaluateUser;
import com.zf.demo4jsp.entity.myEntity.yishiOrderEvaluate;
import com.zf.demo4jsp.entity.yishiOrder;
import com.zf.demo4jsp.mapper.SlideshowMapper;

import com.zf.demo4jsp.mapper.myMapper.EvaluateUserMapper;
import com.zf.demo4jsp.mapper.myMapper.yishiOrderEvaluateMapper;
import com.zf.demo4jsp.mapper.yishiOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * app普通用户端订单接口
 *
 * @return
 */
@Controller
public class FrontEndYiShiHomeController {

    @Autowired
    private SlideshowMapper slideshowMapper;

    @Autowired
    private yishiOrderEvaluateMapper yishiOrderevaluateMapper;

    @Autowired
    private EvaluateUserMapper evaluateUserMapper;



    /**
    * app首页易师前五排行
    * @return
    * @Param
    */
    @RequestMapping("/yishiStarLevel")
    public ModelAndView yishiStarLevel(){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<yishiOrderEvaluate> yishiStarLevel=yishiOrderevaluateMapper.selectyisiStarLevelRanking();
        if(yishiStarLevel.size()>0){
            mv.addObject("code","0");
            mv.addObject("data",yishiStarLevel);
        }else{
            mv.addObject("error","1");
        }
        return mv;

    }

    /**
     * app首页易师轮播图
     * @return
     * @Param
     */
    @RequestMapping("/yishiSlideshow")
    public ModelAndView yishiSlideshow(String imagetype){
        //imagetype="1";
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<Slideshow> slideshows=slideshowMapper.selectSlideshowByType(imagetype);
        if(slideshows.size()>0){
            mv.addObject("code","0");
            mv.addObject("data",slideshows);
        }else{
            mv.addObject("error","1");
        }
        return mv;

    }

    /**
     * app首页易师全部排行
     * @return
     * @Param
     */
    @RequestMapping("/selectyishiRanking")
    public ModelAndView selectyishiRanking(String pageNum){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if (pageNum != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), 10);
        } else {
            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        List<yishiOrderEvaluate> MessageLists = yishiOrderevaluateMapper.selectyisiRanking();//查询全部数据 参数：username模糊查询
        PageInfo<yishiOrderEvaluate> MessageListsPageInfo = new PageInfo<>(MessageLists);//得到分页的结果对象
        List<yishiOrderEvaluate> pageList = MessageListsPageInfo.getList();//得到分页中的person条目对象
        mv.addObject("data", pageList);//用户信息
        mv.addObject("code","0");
        return mv;
    }
    /**
     * app首页易师订单前五排行
     * @return
     * @Param
     */
    @RequestMapping("/selectyisiOrderNumberRanking")
    public ModelAndView selectyisiOrderNumberRanking(){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<yishiOrderEvaluate> yishiStarLevel=yishiOrderevaluateMapper.selectyisiOrderNumberRanking();
        if(yishiStarLevel.size()>0){
            mv.addObject("code","0");
            mv.addObject("data",yishiStarLevel);
        }else{
            mv.addObject("error","1");
        }
        return mv;

    }

    /**
     * app首页评论
     * @return
     * @Param
     */

    @RequestMapping("/selectEvaluateUser")
    public ModelAndView selectEvaluateUser(String pageNum){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if (pageNum != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), 10);
        } else {
            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        List<EvaluateUser> MessageLists = evaluateUserMapper.selectEvaluateUser();//查询全部数据 参数：username模糊查询
        PageInfo<EvaluateUser> MessageListsPageInfo = new PageInfo<>(MessageLists);//得到分页的结果对象
        List<EvaluateUser> pageList = MessageListsPageInfo.getList();//得到分页中的person条目对象
        mv.addObject("data", pageList);//用户信息
        mv.addObject("code","0");
        return mv;
    }
}
