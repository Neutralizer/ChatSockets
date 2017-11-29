package dispatcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
	

	public List<User> getAllUsers() {
		final User u1 = new User("Jake", "127.268.0.1");
		final User u2 = new User("Blake", "127.268.0.2");

		final List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);

		return list;
	}

}
