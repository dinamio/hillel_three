package service;

import dao.ModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eugen on 12/12/18.
 */
@Component
public class ModelService {

    @Autowired
    private ModelDao modelDao;

    public void useDao() {
        modelDao.printSmth();
    }
}
