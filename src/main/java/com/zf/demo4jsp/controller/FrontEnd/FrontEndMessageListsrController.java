package com.zf.demo4jsp.controller.FrontEnd;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.MessageLists;
import com.zf.demo4jsp.entity.UserInfo;
import com.zf.demo4jsp.mapper.MessageListsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * app易师消息列表
 *
 * @return
 */
@Controller
public class FrontEndMessageListsrController {

    @Autowired
    private MessageListsMapper messageListsMapper;

    /**
     * app系统消息统计未读
     * @return
     * @Param Order record
     */
    @RequestMapping("/messageListsr")
    public ModelAndView messageListsr(){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());

        List<MessageLists> messageLists = messageListsMapper.selectMessageListsByState();
        if(messageLists.size()>0){
            mv.addObject("code","0");
            mv.addObject("data",messageLists);
        }else{
            mv.addObject("error","1");
        }

        return mv;//返回到用户管理页面
    }

    /**
     * app系统消息查询全部未读
     * @return
     * @Param Order record
     */
    @RequestMapping("/messageListsrAll")
    public ModelAndView messageListsrAll( String pageNum){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if (pageNum != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), 10);
        } else {
            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        List<MessageLists> MessageLists = messageListsMapper.selectMessageListsByAll();//查询全部数据 参数：username模糊查询
        PageInfo<MessageLists> MessageListsPageInfo = new PageInfo<>(MessageLists);//得到分页的结果对象
        List<MessageLists> pageList = MessageListsPageInfo.getList();//得到分页中的person条目对象
        //mv.addObject("pages", MessageLists);//分页里面的数据 在前台展示
        mv.addObject("data", pageList);//用户信息
        mv.addObject("code","0");
        return mv;//返回到用户管理页面
    }

    /**
     * app系统消息修改
     * @return
     * @Param Order record
     */
    @RequestMapping("/updateMessageListsr")
    public ModelAndView updateMessageListsr( String messageListsrStr){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        messageListsrStr="1-2";
        int count=0;
        MessageLists messageLists = new MessageLists();
        String[] array= messageListsrStr.split("-");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            messageLists.setState("1");
            messageLists.setId(Integer.parseInt(array[i]));
             count =messageListsMapper.updateByPrimaryKeySelective(messageLists);
            if(count==1){
                mv.addObject("code","0");
            }else{
                mv.addObject("error","1");
            }

        }


//        if (pageNum != null) {
//            PageHelper.startPage(Integer.parseInt(pageNum), 10);
//        } else {
//            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
//        }
//        List<MessageLists> MessageLists = messageListsMapper.selectMessageListsByAll();//查询全部数据 参数：username模糊查询
//        PageInfo<MessageLists> MessageListsPageInfo = new PageInfo<>(MessageLists);//得到分页的结果对象
//        List<MessageLists> pageList = MessageListsPageInfo.getList();//得到分页中的person条目对象
//        //mv.addObject("pages", MessageLists);//分页里面的数据 在前台展示
//        mv.addObject("data", pageList);//用户信息
//        mv.addObject("code","0");
        return mv;//返回到用户管理页面
    }
}
