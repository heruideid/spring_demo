package com.notorious.entity;

import java.util.HashMap;
import java.util.Map;

public class StaticFactory {
    static Map<Long,Car> map;
    static {
        map=new HashMap<Long, Car>();
        map.put(1L,new Car(1L,"奔驰"));
        map.put(2L,new Car(2L,"宝马"));
    }

    public static Car getCar(long id){
        return map.get(id);
    }
}
