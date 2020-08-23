package com.swagger3pagination.demo.controller;

import com.swagger3pagination.demo.pojo.Goods;
import com.swagger3pagination.demo.pojo.Ad;
import com.swagger3pagination.demo.result.PageResult;
import com.swagger3pagination.demo.result.PaginationResult;
import com.swagger3pagination.demo.result.RestResult;
import com.swagger3pagination.demo.result.RowResult;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Api(tags = "首页信息管理")
@Controller
@RequestMapping("/home")
public class HomeController {

    @Operation(summary = "首页详情")
    @GetMapping("/home")
    @ResponseBody
    public RestResult<PageResult<RowResult<Goods,Ad>>> home() {

        RestResult res = new RestResult();

        List<Goods> rowList = new ArrayList();
        Goods goodsone = new Goods();
        goodsone.setGoodsId(3L);
        goodsone.setGoodsName("电子书");
        goodsone.setSubject("学python,学ai");
        goodsone.setPrice(new BigDecimal(60));
        goodsone.setStock(10);
        rowList.add(goodsone);

        Goods goodstwo = new Goods();
        goodstwo.setGoodsId(4L);
        goodstwo.setGoodsName("蓝牙音箱");
        goodstwo.setSubject("便携式音质优异");
        goodstwo.setPrice(new BigDecimal(1200.00));
        goodstwo.setStock(30);
        rowList.add(goodstwo);

        RowResult oneRow = new RowResult();
        oneRow.setListGoods(rowList);
        oneRow.setRowType("goods");


        List<Ad> rowList2 = new ArrayList();
        Ad adone = new Ad();
        adone.setTitle("保温杯");
        adone.setImgurl("http://a.com/1.jpg");
        rowList2.add(adone);

        Ad adtwo = new Ad();
        adtwo.setTitle("茶具");
        adtwo.setImgurl("http://a.com/2.jpg");
        rowList2.add(adtwo);

        RowResult twoRow = new RowResult();
        twoRow.setListAd(rowList2);
        twoRow.setRowType("ad");



        List<RowResult> pageList = new ArrayList();
        pageList.add(oneRow);
        pageList.add(twoRow);

        PageResult<List<RowResult>> pres= new PageResult();
        pres.setList(pageList);


        PaginationResult pares = new PaginationResult();
        pares.setTotal(10);
        pares.setCurrentPage(3);

        pres.setPagination(pares);

        return res.success(pres);
    }

}