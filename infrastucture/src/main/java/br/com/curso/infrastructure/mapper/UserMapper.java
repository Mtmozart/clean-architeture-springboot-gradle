package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.User;
import br.com.curso.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getTaxNumber().getValue(),
                user.getFullname(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
    }
}
