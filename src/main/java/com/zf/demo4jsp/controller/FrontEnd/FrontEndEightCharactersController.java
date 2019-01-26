package com.zf.demo4jsp.controller.FrontEnd;

import com.zf.demo4jsp.entity.EightCharacters;
import com.zf.demo4jsp.mapper.EightCharactersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;


@Controller
public class FrontEndEightCharactersController {

    @Autowired
    private EightCharactersMapper eightCharactersMapper;

    /**
     * app端用户添加订单接口
     *
     * @return
     * @Param Order record
     */
    @RequestMapping("/addEightCharacters")
    public ModelAndView addEightCharacters( String name,String userId ,String sex,String birthHour,String address,String times) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        EightCharacters eightCharacters = new EightCharacters();
        eightCharacters.setName(name);
        eightCharacters.setSex(sex);
        eightCharacters.setBirthhour(birthHour);
        eightCharacters.setAddress(address);
        eightCharacters.setUserid(userId);
        eightCharacters.setTimes(times);
        int count = eightCharactersMapper.insert(eightCharacters);
        if(count==1){
            mv.addObject("success","1");
        }else{
            mv.addObject("error","0");
        }
        return mv;
    }

    /**
     * app端查全部
     *
     * @return
     * @Param Order record
     */
    @RequestMapping("/selectEightcharactersByUserIdAll")
    public ModelAndView selectEightcharactersByUserIdAll(String userId) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<EightCharacters> eightCharacters = eightCharactersMapper.selectEightcharactersByUserIdAll(userId);
        if(eightCharacters!=null){
            mv.addObject("eightCharacters",eightCharacters);
        }else{
            mv.addObject("error","0");
        }
        return mv;
    }
    /**
     * app端查单条信息
     *
     * @return
     * @Param String userId
     */
    @RequestMapping("/delEightcharacters")
    public ModelAndView delEightcharacters(Integer id) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        EightCharacters eightcharacters = eightCharactersMapper.selectByPrimaryKey(id);//查询全部数据
        if (eightcharacters != null) {//判断数据
            int count = eightCharactersMapper.deleteByPrimaryKey(id);//(假删除)删除订单 修改订单状态为0
            if (count == 1) {
                mv.addObject("delSuccess", "1");
            } else {
                mv.addObject("delError", "0");
            }
        }
        return mv;
    }
    /**
     * app端删除
     *
     * @return
     * @Param String userId
     */
    @RequestMapping("/selectEightcharactersById")
    public ModelAndView selectEightcharactersById(Integer id) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        EightCharacters eightcharacters = eightCharactersMapper.selectByPrimaryKey(id);//查询全部数据
        if (eightcharacters != null) {//判断数据
            mv.addObject("eightcharacters", eightcharacters);
            }else {
                mv.addObject("delError", "0");
            }
        return mv;
    }
    /**
     * 修改
     *
     * @return
     * @Param String userId
     */
    @RequestMapping("/updteEightcharacters")
    public ModelAndView updteEightcharacters(Integer id,String name,String sex,String birthHour,String address,String times) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        EightCharacters eightcharacters = eightCharactersMapper.selectByPrimaryKey(id);//查询全部数据
        if (eightcharacters != null) {//判断数据
            EightCharacters eightCharacters = new EightCharacters();
            eightCharacters.setName(name);
            eightCharacters.setSex(sex);
            eightCharacters.setBirthhour(birthHour);
            eightCharacters.setAddress(address);
            eightCharacters.setTimes(times);
            eightCharacters.setId(id);
            int count = eightCharactersMapper.updateByPrimaryKeySelective(eightCharacters);//(假删除)删除订单 修改订单状态为0
            if (count == 1) {
                mv.addObject("updateSuccess", "1");
            } else {
                mv.addObject("updateError", "0");
            }
        }
        return mv;
    }


}
