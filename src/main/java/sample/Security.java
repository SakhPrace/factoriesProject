package sample;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sample.entities.FactoryEntity;
import sample.entities.TransporterEntity;
import sample.services.FactoryServiceInterface;
import sample.services.TransporterServiceInterface;

public class Security {

    public boolean passwordCheckForFactory(FactoryServiceInterface factoryService, String username, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        FactoryEntity factoryEntity = factoryService.findEntityByName(username);
        return bCryptPasswordEncoder.matches(password, factoryEntity.getPassword());
    }

    public boolean passwordCheckForTransporter(TransporterServiceInterface transporterService, String username, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        TransporterEntity transporterEntity = transporterService.findEntityByName(username);
        return bCryptPasswordEncoder.matches(password, transporterEntity.getPassword());
    }
}
