package DTO;

public class Employee {
    private int employeeId;
    private int userId;
    private int positionId;

    public Employee(){}
    public Employee(int employeeId, int userId, int positionId) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.positionId = positionId;
    }

    public Employee(Employee d) {
        this.employeeId = d.employeeId;
        this.userId = d.userId;
        this.positionId = d.positionId;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getPositionId() { return positionId; }
    public void setPositionId(int positionId) { this.positionId = positionId; }
}
