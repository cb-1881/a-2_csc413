public class Teller {
    private String tellerId;
    private String name;
    private String branchId;

    // Constructors
    public Teller() {
        
    }

    public Teller(String tellerId, String name, String branchId) {
        this.tellerId = tellerId;
        this.name = name;
        this.branchId = branchId;
    }

    // Getters and setters
    public String getTellerId() {
        return tellerId;
    }

    public void setTellerId(String tellerId) {
        this.tellerId = tellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
}

