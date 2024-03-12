public class Administrator implements Comparable<Administrator>{
    private String staffId;
    private String name;

    // Constructor
    public Administrator(String staffId, String name) {
        this.staffId = staffId;
        this.name = name;
    }

    // Getters and Setters
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//toString() method
  
  
    @Override
    public String toString() {
        return "Administrator{" +
                "staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Administrator arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
  // Methods for account and system management
}
