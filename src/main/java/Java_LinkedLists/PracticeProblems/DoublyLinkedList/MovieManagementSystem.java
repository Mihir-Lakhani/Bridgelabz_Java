/*
2. Doubly Linked List: Movie Management System

Operations:
1. Add a movie at the beginning, end, or a specific position.
2. Remove a movie by title.
3. Search by director or rating.
4. Display movies in forward and reverse order.
5. Update a movie's rating by title.
*/

package Java_LinkedLists.PracticeProblems.DoublyLinkedList;

public class MovieManagementSystem {

    private class Movie {
        private String title;
        private String director;
        private int releaseYear;
        private int rating;

        Movie prev;
        Movie next;

        Movie(String title, String director, int releaseYear, int rating) {
            this.title = title;
            this.director = director;
            this.releaseYear = releaseYear;
            this.rating = rating;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        void displayMovie() {
            System.out.println("===============================");
            System.out.println("Title: " + title);
            System.out.println("Director: " + director);
            System.out.println("Release Year: " + releaseYear);
            System.out.println("Rating: " + rating);
            System.out.println("===============================");
        }
    }

    private Movie head;
    private Movie tail;

    // Initializes a fresh list containing one movie.
    void start(String title, String director, int releaseYear, int rating) {
        head = new Movie(title, director, releaseYear, rating);
        tail = head;
    }

    void addBeginning(String title, String director,
                      int releaseYear, int rating) {

        Movie newMovie = new Movie(title, director, releaseYear, rating);
        newMovie.next = head;

        if (head == null) {
            tail = newMovie;
        } else {
            head.prev = newMovie;
        }

        head = newMovie;
    }

    void addEnd(String title, String director,
                int releaseYear, int rating) {

        Movie newMovie = new Movie(title, director, releaseYear, rating);

        if (tail == null) {
            head = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
        }

        tail = newMovie;
    }

    // Inserts AT the given zero-based index.
    void addMid(String title, String director,
                int releaseYear, int rating, int index) {

        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            addBeginning(title, director, releaseYear, rating);
            return;
        }

        // Find the node immediately before the insertion position.
        Movie current = head;

        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Index is beyond the list");
            return;
        }

        Movie newMovie = new Movie(title, director, releaseYear, rating);

        newMovie.next = current.next;
        newMovie.prev = current;

        if (current.next == null) {
            tail = newMovie;
        } else {
            current.next.prev = newMovie;
        }

        current.next = newMovie;
    }

    void remove(String title) {
        if (head == null) {
            System.out.println("Movie list is empty");
            return;
        }

        Movie current = head;

        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("No movie found with title: " + title);
            return;
        }

        // Update the previous node's next pointer, or move head.
        if (current.prev == null) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        // Update the following node's prev pointer, or move tail.
        if (current.next == null) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }

        current.next = null;
        current.prev = null;

        System.out.println("Removed movie: " + title);
    }

    void newRating(String title, int rating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                current.setRating(rating);
                System.out.println(
                        "Updated rating for " + title + " to " + rating
                );
                return;
            }

            current = current.next;
        }

        System.out.println("No movie found with title: " + title);
    }

    void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                current.displayMovie();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    void searchByRating(int rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.getRating() == rating) {
                current.displayMovie();
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    void displayForward() {
        if (head == null) {
            System.out.println("Movie list is empty");
            return;
        }

        Movie current = head;

        while (current != null) {
            current.displayMovie();
            current = current.next;
        }
    }

    void displayReverse() {
        if (tail == null) {
            System.out.println("Movie list is empty");
            return;
        }

        Movie current = tail;

        while (current != null) {
            current.displayMovie();
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem movies = new MovieManagementSystem();

        movies.start("Inception", "Christopher Nolan", 2010, 9);
        movies.addBeginning("3 Idiots", "Rajkumar Hirani", 2009, 9);
        movies.addEnd("Interstellar", "Christopher Nolan", 2014, 9);
        movies.addEnd("Dangal", "Nitesh Tiwari", 2016, 8);

        movies.addMid(
                "The Dark Knight", "Christopher Nolan", 2008, 9, 2
        );

        System.out.println("=== Forward Order ===");
        movies.displayForward();

        System.out.println("\n=== Reverse Order ===");
        movies.displayReverse();

        System.out.println("\n=== Search by Director ===");
        movies.searchByDirector("Christopher Nolan");

        System.out.println("\n=== Search by Rating: 8 ===");
        movies.searchByRating(8);

        System.out.println("\n=== Update Dangal's Rating ===");
        movies.newRating("Dangal", 10);
        movies.searchByRating(10);

        System.out.println("\n=== Remove a Middle Movie ===");
        movies.remove("The Dark Knight");

        System.out.println("\n=== Remove the First Movie ===");
        movies.remove("3 Idiots");

        System.out.println("\n=== Remove the Last Movie ===");
        movies.remove("Dangal");

        System.out.println("\n=== Remaining Movies: Forward ===");
        movies.displayForward();

        System.out.println("\n=== Remaining Movies: Reverse ===");
        movies.displayReverse();

        System.out.println("\n=== Remove a Missing Movie ===");
        movies.remove("Unknown Movie");
    }
}