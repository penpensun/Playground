package org.peng.web;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.ResponseBody;

public class TreeItems{
  private String name;
  private String[] children;
  private ArrayList itemList;
  public TreeItems(String[] arr, ArrayList<String> itemList, String name){
    this.children  = arr;
    this.itemList = itemList;
    this.name = name;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String[] getChildren() {
    return children;
  }

  public void setChildren(String[] items){
    this.children = items;
  }

  public ArrayList<String> getItemList() {
    return itemList;
  }

  public void setItemList(ArrayList<String> itemList){
    this.itemList = itemList;
  }

}