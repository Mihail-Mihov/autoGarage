package bg.tarataiki.tarataiki.service;

import bg.tarataiki.tarataiki.model.serviceModels.UserLoginServiceModel;

public interface UserService {

    boolean login(UserLoginServiceModel userLoginServiceModel);

}
