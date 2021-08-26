package controleng.northwind.business.concretes;

import controleng.northwind.business.abstracts.UserService;
import controleng.northwind.core.dataAccess.UserDao;
import controleng.northwind.core.entities.User;
import controleng.northwind.core.utilities.results.DataResult;
import controleng.northwind.core.utilities.results.Result;
import controleng.northwind.core.utilities.results.SuccessDataResult;
import controleng.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class UserManager implements UserService {
    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı getirildi.");
    }
}
