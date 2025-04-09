package BUS;

import java.util.List;

import DAO.PermissionDAO;
import DTO.Permission;
public class PermissionBUS {
    private PermissionDAO permissiondao = new PermissionDAO();
    public PermissionBUS() {
        
    }
    public List<Permission> getPermissionFromRoleId(int roleid)
    {
        return permissiondao.getPermissionFromRoleId(roleid);
    }
}
