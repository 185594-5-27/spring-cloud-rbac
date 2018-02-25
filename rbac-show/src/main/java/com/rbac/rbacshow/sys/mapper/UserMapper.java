package com.rbac.rbacshow.sys.mapper;

import com.rbac.rbacshow.sys.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    com.base.entity.User userToBase(User user);

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
