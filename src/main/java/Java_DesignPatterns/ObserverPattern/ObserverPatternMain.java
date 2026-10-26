package Java_DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

interface Subject {
    void registerObserver(Observer observer);
    void notifyObservers();
}

class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}

class NewsReader implements Observer {
    private final String name;

    NewsReader(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

public class ObserverPatternMain {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.registerObserver(new NewsReader("Mihir"));
        agency.registerObserver(new NewsReader("Asha"));

        agency.setNews("The new Java lesson is available.");
    }
}
