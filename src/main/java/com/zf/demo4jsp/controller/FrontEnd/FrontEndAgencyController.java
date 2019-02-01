package com.zf.demo4jsp.controller.FrontEnd;

import com.zf.demo4jsp.entity.Agency;
import com.zf.demo4jsp.mapper.AgencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Date;

/**
 * app代理接口
 *
 * @return
 */
@Controller
public class FrontEndAgencyController {

    @Autowired
    private AgencyMapper agencyMapper;

    /**
     * app端添加代理
     * @return
     * @Param Order record
     */
    @RequestMapping("/addAgency")
    public ModelAndView addAgency(String industry,String name,String understanding,
                                  String wechat,String phone,
                                  String idCardfrontImg,String idCardfrontContrary,String address){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Agency agency = new Agency();
        agency.setIndustry(industry);
        agency.setName(name);
        agency.setUnderstanding(understanding);
        agency.setWechat(wechat);
        agency.setPhone(phone);
        agency.setIdcardfrontimg(idCardfrontImg);
        agency.setAddress(address);
        agency.setCreatetime(new Date());
        agency.setIdcardfrontcontrary(idCardfrontContrary);
       int count = agencyMapper.insert(agency);//添加代理数据
       if(count==1){//表示成功
           mv.addObject("agencySuccess","1");
       }else{//表示失败
           mv.addObject("agencyError","0");
       }
        return mv;//返回到用户管理页面
    }

}
