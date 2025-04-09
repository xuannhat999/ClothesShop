package DTO;

import java.math.BigDecimal;

public class Position {
        private int positionId;
        private String positionName;
        private BigDecimal salary;
    
        public Position(){}
        public Position(int positionId, String positionName, BigDecimal salary) {
            this.positionId = positionId;
            this.positionName = positionName;
            this.salary = salary;
        }
    
        public Position(Position d) {
            this.positionId = d.positionId;
            this.positionName = d.positionName;
            this.salary = d.salary;
        }
    
        public int getPositionId() { return positionId; }
        public void setPositionId(int positionId) { this.positionId = positionId; }
        public String getPositionName() { return positionName; }
        public void setPositionName(String positionName) { this.positionName = positionName; }
        public BigDecimal getSalary() { return salary; }
        public void setSalary(BigDecimal salary) { this.salary = salary; }
    }
