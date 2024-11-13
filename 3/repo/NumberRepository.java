package repo;

public interface NumberRepository {
    void add(int number);               // Create
    int[] getAll();                     // Read
    void update(int oldNumber, int newNumber); // Update
    void delete(int number);            // Delete
}