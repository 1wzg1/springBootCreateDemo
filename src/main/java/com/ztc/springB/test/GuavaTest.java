package com.ztc.springB.test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.ztc.springB.bean.User;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GuavaTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        //分割集合为小的集合
        /*List<List<String>> lists = Lists.partition(list, 1);
        lists.forEach(e->{
            e.forEach(l->{
                System.out.println(l);
            });
        });*/
        //按照分隔符分割
        //String join = Joiner.on(",").join(list);
        //multimap用法：处理Map<K,Collection<V>>集合
        List<User> userList = Lists.newArrayList();
        for(int i=0;i<5;i++){
            User user = new User();
            user.setUsername(i+"");
            user.setId(i+"");
            user.setCreate_time(new Date());
            user.setName(i+"");
            userList.add(user);
        }
        Multimap<String, User> multimap = ArrayListMultimap.create();
        userList.forEach(e->{
            multimap.put(e.getId(),e);
        });
        //获取所有key
        System.out.println(multimap.keySet());
        //获取指定key
        Collection<User> users = multimap.get("1");
        users.forEach(e->{
            System.out.println(e);
        });
        //将multimap转化为map
        Map<String, Collection<User>> stringCollectionMap = multimap.asMap();


    }
}
