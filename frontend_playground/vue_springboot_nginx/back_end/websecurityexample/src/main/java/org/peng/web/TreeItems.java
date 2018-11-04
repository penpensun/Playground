package org.peng.web;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class TreeItems{
  ArrayList<String> items;
  public TreeItems(String[] arr){
    this.items = new ArrayList<>(Arrays.asList(arr));
  }  
}