package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value ="OrderMapper")
public interface OrderMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectOrderAll(String orderName);
    //app端
    List<Order> selectOrderByUserIdAll(@Param("userId") String userId, @Param("paymentStatus")String paymentStatus);
    //统计已支付未解决订单
    int selectCountOrderBySolutionState(String userId);
    //统计未支付订单
    int selectCountOrderBypaymentStatus(String paymentStatus);

    Order selectOrderByorderNumber(String ordernumber);
    //支付成功修改订单号状态
    int updateOrederPaymentstatus(Order record);
}