package org.simble.member.dao.mapper.gen;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.simble.member.dao.po.User;
import org.simble.member.dao.po.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User lockByPrimaryKey(@Param("id") String id);

    List<User> lockByExample(UserExample example);
}