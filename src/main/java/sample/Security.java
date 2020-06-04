package sample;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sample.entities.FactoryEntity;
import sample.entities.TransportOperatorEntity;
import sample.services.FactoryServiceInterface;
import sample.services.TransportOperatorServiceInterface;

public class Security {

    public boolean passwordCheckForFactory(FactoryServiceInterface factoryService, String username, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        FactoryEntity factoryEntity = factoryService.findEntityByName(username);
        return bCryptPasswordEncoder.matches(password, factoryEntity.getPassword());
    }

    public boolean passwordCheckForTransporter(TransportOperatorServiceInterface transportOperatorService, String username, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        TransportOperatorEntity transportOperatorEntity = transportOperatorService.findEntityByName(username);
        return bCryptPasswordEncoder.matches(password, transportOperatorEntity.getPassword());
    }
}
