package BUS;

import DAO.UserDAO;
import DTO.User;

public class UserBUS {
    UserDAO userDAO = new UserDAO();
    public UserBUS() {
        
    }
    public User loginCheck(String username, String password) {
        for(User i : userDAO.getAllUser()) {
            if(i.getUsername().equals(username) && i.getPassword().equals(password)) {
                return i;
            }
        }
        return null;
    }
    public User getUserFromId(int id)
    {
        return userDAO.getUserFromId(id);
    }
}
