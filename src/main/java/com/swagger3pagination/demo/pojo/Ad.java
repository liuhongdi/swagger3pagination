package com.swagger3pagination.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("广告模型")
public class Ad {
    //提示信息，通常供报错时使用
    @ApiModelProperty("标题")
    private String title;
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //提示信息，通常供报错时使用
    @ApiModelProperty("图片url")
    private String imgurl;
    public String getImgurl() {
        return this.imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

}
