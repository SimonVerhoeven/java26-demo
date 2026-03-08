package dev.simonverhoeven.java26demo.finalized.core;

import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

/// JEP 525: Structured Concurrency (Sixth Preview)

public class StructuredConcurrency {

    public GarderobeSelectionInput composeGarderobeSelectionInput(String userId) throws InterruptedException {
        try (final var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<Person> personTask =
                    scope.fork(() -> findPerson(userId));
            Supplier<Weather> weatherTask =
                    scope.fork(this::fetchWeather);
            Supplier<Activity> activityTask =
                    scope.fork(() -> findActivity(userId));

            scope.join();
            scope.throwIfFailed();

            final var person = personTask.get();
            final var weather = weatherTask.get();
            final var activity = activityTask.get();

            return new GarderobeSelectionInput(person, weather, activity);
        }
    }

    Person findPerson(String id) throws InterruptedException {
        Thread.sleep(2000L);
        return null;}
    Weather fetchWeather() throws InterruptedException {
        Thread.sleep(5000L);
        return null;}
    Activity findActivity(String id) throws InterruptedException {
        Thread.sleep(3000L);
        return null;
    }

    class Person {}
    class Weather {}
    class Activity {}
    public record GarderobeSelectionInput(Person person, Weather weather, Activity activity){}
}
