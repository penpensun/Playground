package org.peng.web;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class TreeViewController {
  @RequestMapping(value="/treeview", method=RequestMethod.GET)
  public TreeItems getTreeItems() {
    String[] arr = {"item1","item2","item3","item4","item5"};
    return new TreeItems(arr);
  }
    
}