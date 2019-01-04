package service;

import dao.mysql.CigaretteRepository;
import entity.Cigarette;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by mihail on 12/9/18.
 */
@Service
public class CigaretteService {

    @Autowired
    private CigaretteRepository cigaretteRepository;

    /**
     * Avoid when user smoke cigarette
     */
    public Cigarette updateOnSmoke(User user) {
        Cigarette cigarette = user.getCigarette();
        cigarette.setLastSmokeTime(LocalDateTime.now());

        /**
         *  in this case todo main service of site
         */

        cigarette.setAllCigarettesSmoke(cigarette.getAllCigarettesSmoke() + 1);
        return cigaretteRepository.update(cigarette);
    }

    public Cigarette getById(long id) {
        return cigaretteRepository.getById(id);
    }

    public String getMessageFromRepository() {
        return cigaretteRepository.getThrowableMessage();
    }
}
