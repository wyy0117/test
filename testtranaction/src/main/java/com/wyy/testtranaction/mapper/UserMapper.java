package com.wyy.testtranaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyy.testtranaction.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Date: 2021/9/2
 * @Author: wyy
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
