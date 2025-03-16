package kcredit.tech.chnl.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<User> selectUserPage(@Param("pg") Page<User> page, @Param("su") SearchUser searchUser);
}
