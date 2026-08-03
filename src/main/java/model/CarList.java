package model;

import sorting.comparator.CarComparedField;
import sorting.strategy.SortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CarList extends ArrayList<Car> {

    public void sort(SortStrategy<Car> strategy, CarComparedField carField) {
        strategy.sort(this, carField);
    }

    public int countOccurrences(Car target) throws ExecutionException, InterruptedException {

        int threadCount = 4;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        List<Future<Integer>> futures = new ArrayList<>();

        int chunkSize = (size() + threadCount - 1) / threadCount;

        for (int i = 0; i < threadCount; i++) {

            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, size());

            if (start >= size()) {

                break;
            }

            futures.add(executor.submit(() -> {

                int count = 0;

                for (int j = start; j < end; j++) {

                    if (get(j).equals(target)) {

                        count++;
                    }
                }

                return count;
            }));
        }

        int result = 0;

        for (Future<Integer> future : futures) {

            result += future.get();
        }

        executor.shutdown();

        return result;
    }
}
