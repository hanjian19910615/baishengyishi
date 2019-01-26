package com.zf.demo4jsp.controller.FrontEnd;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.HotAsk;
import com.zf.demo4jsp.mapper.HotAskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import java.util.List;


/**
 * app热门测评接口
 *
 * @return
 */
@Controller
public class FrontEndHotAskController {

    @Autowired
    private HotAskMapper hotAskMapper;

    /**
     * 查询热门测评
     * @return
     */
    @RequestMapping("/selectByHotAsk")
    public ModelAndView selectByHotAsk(String pageNum) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if( pageNum.equals("0")){
            PageHelper.startPage(1 , 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }else{
            PageHelper.startPage(Integer.parseInt(pageNum) , 10);
        }
        List<HotAsk> hotAsksList = hotAskMapper.selectByAll();//根据手机号进行数据匹配
        PageInfo<HotAsk> hotAsksPageInfo = new PageInfo<>(hotAsksList);//得到分页的结果对象
        List<HotAsk> pageList = hotAsksPageInfo.getList();//得到分页中的person条目对象
        mv.addObject("pages",hotAsksPageInfo);//分页里面的数据 在前台展示
        mv.addObject("hotAsks",pageList);//用户信息
        mv.addObject("count",hotAsksList.size());//用户信息
        return mv;
    }
}
