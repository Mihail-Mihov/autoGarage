package bg.tarataiki.tarataiki.service.impl;

import bg.tarataiki.tarataiki.model.serviceModels.UserLoginServiceModel;
import bg.tarataiki.tarataiki.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
