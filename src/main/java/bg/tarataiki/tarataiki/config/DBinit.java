package bg.tarataiki.tarataiki.config;

import bg.tarataiki.tarataiki.model.entity.BrandEntity;
import bg.tarataiki.tarataiki.model.entity.CategoryEnum;
import bg.tarataiki.tarataiki.model.entity.ModelEntity;
import bg.tarataiki.tarataiki.model.entity.UserEntity;
import bg.tarataiki.tarataiki.repostiroy.BrandRepository;
import bg.tarataiki.tarataiki.repostiroy.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBinit implements CommandLineRunner {


    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBinit(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args)  {
       initializeBrandAndModels();
       initializeFirstUser();

    }

    private void initializeBrandAndModels(){
        if (brandRepository.count() ==0) {
            BrandEntity ford = new BrandEntity().setName("Ford");

            ModelEntity fiesta = new ModelEntity().setBrand(ford)
                    .setName("Fiesta").setStartYear(1976)
                    .setImageUrl("https://automedia.investor.bg/media/files/resized/uploadedfiles/640x0/366/c8da9ce37010580c1c9953f7ddeb3366-ford-fiesta-2022-1024-01.jpg")
                    .setCategory(CategoryEnum.CAR);

            ModelEntity escort = new ModelEntity().setBrand(ford)
                    .setName("Escort").setStartYear(1968).setEndYear(2000)
                    .setImageUrl("https://cdn4.focus.bg/fakti/photos/16x9/a88/prodava-se-nai-specialnia-ford-escort-1.jpg")
                    .setCategory(CategoryEnum.CAR);

            ford.setModels(List.of(fiesta, escort));
            brandRepository.saveAndFlush(ford);
        }
    }
    private void initializeFirstUser(){
        if(userRepository.count() == 0){
            UserEntity user = new UserEntity();
            user.setActive(false).setUsername("admin").setFirstName("root").setLastName("root").setAge(1)
                            .setPassword(passwordEncoder.encode("password"));
            userRepository.save(user);


        }
    }
}
