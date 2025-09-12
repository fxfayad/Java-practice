class University {
    String name;
    String address;
    int estdYear;
    int rank;

    // Constructor with all attributes
    University(String name, String address, int estdYear, int rank) {
        this.name = name;
        this.address = address;
        this.estdYear = estdYear;
        this.rank = rank;
    }

    // Constructor with name, address, estdYear
    University(String name, String address, int estdYear) {
        this.name = name;
        this.address = address;
        this.estdYear = estdYear;
    }

    // Getter methods
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public int getEstdYear() {
        return estdYear;
    }
    public int getRank() {
        return rank;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEstdYear(int estdYear) {
        this.estdYear = estdYear;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    // Method to display university info
    public void display() {
        System.out.println("University Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Established Year: " + estdYear);
        System.out.println("Rank: " + rank);
        System.out.println("--------------------------");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Using constructor with all attributes
        University u1 = new University("Premier University", "Chattogram", 2002, 1);
        u1.display();

        // Using constructor with name, address, estdYear
        University u2 = new University("Another University", "Dhaka", 1995);
        u2.setRank(5); // set rank later using setter
        u2.display();
    }
}
