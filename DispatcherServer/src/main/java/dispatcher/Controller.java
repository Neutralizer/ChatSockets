package dispatcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class Controller {

		@Autowired
		private UserServiceImpl userService;
		
		@RequestMapping(value = "/clients", method = RequestMethod.GET)
		public List<User> printWelcome() {
			List<User> allUsers = userService.getAllUsers(); 
			
			return allUsers;
		}
}
