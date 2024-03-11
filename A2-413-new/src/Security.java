public class Security {
    private String securityId;
    private String name;
    private String level; //  represent clearance level for other accounts

    // Constructors
    public Security() {

    }

    public Security(String securityId, String name, String level) {
        this.securityId = securityId;
        this.name = name;
        this.level = level;
    }

    // Getters and setters
    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

