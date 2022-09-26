package bg.tarataiki.tarataiki.web;

import bg.tarataiki.tarataiki.model.binding.UserLoginBindingModel;
import bg.tarataiki.tarataiki.model.serviceModels.UserLoginServiceModel;
import bg.tarataiki.tarataiki.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/users/login") // v clientnumber trqbva da bade postmaping s parameter
    // za da se izprati tazi informaciq
    public String login(UserLoginBindingModel userLoginBindingModel){
        boolean loginSuccessful = userService.login(new UserLoginServiceModel()
               .setUsername(userLoginBindingModel.getUsername())
                .setRawPassword(userLoginBindingModel.getPassword()));
        return "redirect:/index";
    }
}
