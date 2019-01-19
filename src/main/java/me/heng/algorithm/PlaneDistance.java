package me.heng.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR: wangdi
 * DATE: 2019-01-06
 * TIME: 22:08
 */
public class PlaneDistance {

    /**
     * 油箱最多走Max = 10000
     * 去程：[1, 2000] [2, 5000].
     * 回程：[3, 5000] [4, 2000] [5, 8000]
     * 问飞机最多可以走哪几条路？不一定能走满Max，可以是最靠近Max的数。
     * @param go
     * @param back
     * @return
     */
    public static List<Integer[]> getDistances(List<Integer[]> go,List<Integer[]> back){
        List<Integer[]> res = new ArrayList<>();

        for(int i = 0;i<go.size();i++){
            int id = go.get(i)[0];
            int goDistance = go.get(i)[1];
            for(int b =0;b<back.size();b++){
                int idback = back.get(b)[0];
                int backDistance = back.get(b)[1];
                if(goDistance+backDistance<=10000) {
                    res.add(new Integer[]{id,idback});
                }
            }
        }



        return res;
    }


    public static void main(String[] args) {
        List<Integer[]> go = new ArrayList<>();
        go.add(new Integer[]{1,2000});
        go.add(new Integer[]{2,5000});
        List<Integer[]> back = new ArrayList<>();
        back.add(new Integer[]{3,5000});
        back.add(new Integer[]{4,2000});
        back.add(new Integer[]{5,8000});
        List<Integer[]> res = getDistances(go,back);

        System.out.println(JSONObject.toJSONString(res));

    }
}
