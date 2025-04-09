package BUS;

import DAO.FeatureDAO;
import DTO.Feature;
import java.util.List;

public class FeatureBUS {
    private FeatureDAO featuredao = new FeatureDAO();
    public FeatureBUS() {
        
    }
    public List<Feature> getFeatureFromRoleId(int roleid)
    {
        return featuredao.getFeatureFromRoleId(roleid);
    }
    public Feature getFeatureById(int id)
    {
        return featuredao.getFeatureById(id);
    }
}
