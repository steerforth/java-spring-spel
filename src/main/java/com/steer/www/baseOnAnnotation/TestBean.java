package com.steer.www.baseOnAnnotation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("testBean")
public class TestBean {
    private Map<String,String> map;
    private List<String> list;

    public TestBean() {
        map = new HashMap<String, String>();
        map.put("MapA", "This is A");
        map.put("MapB", "This is B");
        map.put("MapC", "This is C");

        list = new ArrayList<String>();
        list.add("ListA");
        list.add("ListB");
        list.add("ListC");
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
