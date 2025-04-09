package DTO;

public class Action {
    private int action_id;
    private String action_name;
    public Action(){

    }
    public Action(int actionId,String actionName)
    {
        this.action_id=actionId;
        this.action_name = actionName;
    }
    public Action(Action d)
    {
        this.action_id=d.action_id;
        this.action_name=d.action_name;
    }
    public int getActionID()
    {
        return action_id;
    }
    public String getActionName()
    {
        return action_name;
    }

}
