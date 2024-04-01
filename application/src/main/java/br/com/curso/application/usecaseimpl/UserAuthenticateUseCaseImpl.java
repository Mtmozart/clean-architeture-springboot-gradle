package br.com.curso.application.usecaseimpl;

import br.com.curso.application.geteway.UserAuthenticateGeteway;
import br.com.curso.core.exception.AuthenticateException;
import br.com.curso.core.exception.enums.ErrorCodeEnum;
import br.com.curso.usecase.UserAuthenticateUseCase;

public class UserAuthenticateUseCaseImpl implements UserAuthenticateUseCase {
    private UserAuthenticateGeteway userAuthenticateGeteway;

    public UserAuthenticateUseCaseImpl(UserAuthenticateGeteway userAuthenticateGeteway) {
        this.userAuthenticateGeteway = userAuthenticateGeteway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticateException {
        if(!userAuthenticateGeteway.authenticate(username,password)){
            throw new AuthenticateException(ErrorCodeEnum.ATH0001.getMessage(), ErrorCodeEnum.ATH0001.getCode());
        }
        return true;
    }
}
