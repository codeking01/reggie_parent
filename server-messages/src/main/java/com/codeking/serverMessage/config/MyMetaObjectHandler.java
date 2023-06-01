package com.codeking.serverMessage.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //使用mp实现一个添加操作，这个方法会执行
    @Override
    public void insertFill(MetaObject metaObject) {
        //设置属性值，通过名字,第二个参数就是属性值，因为在这里只用获取时间，所以new一个date即可
        //第三个参数和方法中的参数一样，叫元数据，就比如说一张表里面的表名，字段，都是元数据
        this.setFieldValByName("sentTime", LocalDateTime.now(), metaObject);
    }

    //使用mp实现一个修改操作，这个方法会执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
