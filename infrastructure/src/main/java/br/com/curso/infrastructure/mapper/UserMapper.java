package br.com.curso.infrastructure.mapper;

import br.com.curso.core.domain.TaxNumber;
import br.com.curso.core.domain.User;
import br.com.curso.infrastructure.dto.request.CreateUserRequest;
import br.com.curso.infrastructure.entity.UserEntity;
import br.com.curso.usecase.CreateUserUseCase;
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

    public User toUser(CreateUserRequest request) throws Exception {
        return new User(
            request.email(),
                request.password(),
               new TaxNumber(request.taxNumber()),
                request.fullName(),
                request.type()
        );
    }
}
