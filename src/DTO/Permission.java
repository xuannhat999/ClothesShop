package DTO;

public class Permission {
    private int roleId;
    private int featureId;
    private int actionId;

    public Permission(){}
    public Permission(int roleId, int featureId, int actionId) {
        this.roleId = roleId;
        this.featureId = featureId;
        this.actionId = actionId;
    }
    public Permission(Permission d) {
        this.roleId = d.roleId;
        this.featureId = d.featureId;
        this.actionId = d.actionId;
    }

    public int getRoleId() { return roleId; }
    public void setRoleId(int roleId) { this.roleId = roleId; }
    public int getFeatureId() { return featureId; }
    public void setFeatureId(int featureId) { this.featureId = featureId; }
    public int getActionId() { return actionId; }
    public void setActionId(int actionId) { this.actionId = actionId; }
}
