package com.zf.demo4jsp.controller.FrontEnd;

import com.zf.demo4jsp.entity.Coupon;
import com.zf.demo4jsp.entity.Evaluate;
import com.zf.demo4jsp.entity.UserInfo;
import com.zf.demo4jsp.mapper.CouponMapper;
import com.zf.demo4jsp.mapper.EvaluateMapper;
import com.zf.demo4jsp.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

//评价
@Controller
public class FrontEndCouponController {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * app端优惠券
     * @return
     * @Param Order record
     */
    @RequestMapping("/selectCouponByUserId")
    public ModelAndView selectCouponByUserId(String userId ) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Coupon coupon= couponMapper.selectByUserId(userId);
        if(coupon!=null){
                mv.addObject("couponSuccess","1");
                mv.addObject("amount",coupon.getAmount());
            }
        else{
            mv.addObject("couponError","0");
        }
        return mv;
    }


}
