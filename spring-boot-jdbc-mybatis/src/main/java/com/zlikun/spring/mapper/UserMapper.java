package com.zlikun.spring.mapper;

import com.zlikun.spring.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-20 09:53
 */
@Repository
public interface UserMapper {

    @Select("SELECT * FROM TBL_USER WHERE ID = #{userId}")
    User get(long userId);

    /**
     * 分页查询数据
     * @param start 分页起始位置
     * @param limit 分页长度
     * @return
     */
    List<User> list(@Param("start") int start, @Param("limit") int limit);

}
