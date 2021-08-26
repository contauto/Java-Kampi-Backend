package controleng.northwind.business.abstracts;

import controleng.northwind.core.entities.User;
import controleng.northwind.core.utilities.results.DataResult;
import controleng.northwind.core.utilities.results.Result;
import org.springframework.stereotype.Service;


public interface UserService {
    Result add(User user);

    DataResult<User> findByEmail(String email);
}
