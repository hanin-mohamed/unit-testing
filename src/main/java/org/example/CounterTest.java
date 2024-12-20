package org.example;
public class CounterTest {
    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        testRunner.execute("Initial Value", () -> {
            Counter counter = new Counter();
            int actualResult = counter.count(5);
            if (actualResult != 5)
                throw new RuntimeException("Test1-result should be 5!");
        });

        testRunner.execute("Initial Value#2 ", () -> {
            Counter counter = new Counter();
            int actualResult = counter.count(5);
            if (actualResult != 5)
                throw new RuntimeException("Test1-result should be 5!");
        });
        testRunner.execute("count Within Limit", () -> {
            // Arrange
            Counter counter = new Counter();
            counter.count(5);
            // Act
            int actualResult = counter.count(2);
            // Assert
            if (actualResult != 7)
                throw new RuntimeException(" result should be 7!");
        });

        testRunner.execute("Exceed Limit", () -> {
            // Arrange
            Counter counter = new Counter();
            counter.count(5);
            // Act
            int actualResult = counter.count(7);
            // Assert
            if (actualResult != 2)
                throw new RuntimeException("Test2 exceed limit - result should be 2!");
        });
        testRunner.finish();
    }
}
