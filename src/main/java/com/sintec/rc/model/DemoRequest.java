package com.sintec.rc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

public class DemoRequest {
  
  //@JsonIgnore
  @ApiModelProperty(required = true)
  private int id;
  
  @ApiModelProperty(required = true)
  private String name;
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
