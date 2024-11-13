package repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryNumberRepositoryImpl implements NumberRepository {
    private List<Integer> numbers = new ArrayList<>();

    @Override
    public void add(int number) {
        numbers.add(number);
        Collections.sort(numbers); // Сортируем после добавления
    }

    @Override
    public int[] getAll() {
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public void update(int oldNumber, int newNumber) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == oldNumber) {
                numbers.set(i, newNumber);
            }
        }
        Collections.sort(numbers); // Сортируем после обновления
    }

    @Override
    public void delete(int number) {
        numbers.remove(Integer.valueOf(number));
        Collections.sort(numbers); // Сортируем после удаления
    }
}
