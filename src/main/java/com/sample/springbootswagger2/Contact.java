package com.sample.springbootswagger2;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.ModelAttribute;

@ApiModel(description = "Details about the contact")
public class Contact {

    @ApiModelProperty(notes= "The unique id of the contact")
    private String id;
    @ApiModelProperty(notes = "The person's name")
    private String name;
    @ApiModelProperty(value = "The person's contact number")
    private String phoneNum;

    public Contact(String id, String name, String phoneNum) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
