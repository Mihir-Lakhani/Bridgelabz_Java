/*
7. Singly Linked List: Social Media Friend Connections
Problem Statement: Each user node stores User ID, Name, Age, and a List of Friend IDs.
Tasks:
1. Add a friend connection between two users.
2. Remove a friend connection.
3. Find mutual friends between two users.
4. Display all friends of a specific user.
5. Search for a user by Name or User ID.
6. Count the number of friends for each user.
Hint: Use a singly linked list of users and a nested linked list of friend IDs.
Friendships in this program are mutual: both users store each other's ID.
 */

package Java_LinkedLists.PracticeProblems.SinglyLinkedList;

public class SocialMediaFriendConnections {

    private static class Friend {
        private final String friendId;
        private Friend next;

        Friend(String friendId) {
            this.friendId = friendId;
        }
    }

    private static class User {
        private final String userId;
        private final String name;
        private final int age;
        private Friend friends;
        private User next;

        User(String userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
        }

        void displayDetails() {
            System.out.printf("ID: %s | Name: %s | Age: %d%n", userId, name, age);
        }
    }

    private static User head;

    private static User findUser(String userId) {
        User current = head;
        while (current != null) {
            if (current.userId.equals(userId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    static void addUser(String userId, String name, int age) {
        if (userId == null || userId.isBlank() || name == null || name.isBlank() || age < 0) {
            System.out.println("Enter a non-empty ID and name, and a non-negative age");
            return;
        }
        if (findUser(userId) != null) {
            System.out.println("User ID already exists: " + userId);
            return;
        }
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
            return;
        }
        User current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newUser;
    }

    private static boolean hasFriend(User user, String friendId) {
        Friend current = user.friends;
        while (current != null) {
            if (current.friendId.equals(friendId)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static void addFriendId(User user, String friendId) {
        Friend newFriend = new Friend(friendId);
        newFriend.next = user.friends;
        user.friends = newFriend;
    }

    static void addConnection(String firstId, String secondId) {
        User first = findUser(firstId);
        User second = findUser(secondId);
        if (first == null || second == null) {
            System.out.println("One or both users were not found");
            return;
        }
        if (first == second) {
            System.out.println("A user cannot add themselves as a friend");
            return;
        }
        if (hasFriend(first, secondId)) {
            System.out.println("These users are already friends");
            return;
        }

        // Store each user's ID in the other user's friend list.
        addFriendId(first, secondId);
        addFriendId(second, firstId);
        System.out.println("Connected " + first.name + " and " + second.name);
    }

    private static void removeFriendId(User user, String friendId) {
        if (user.friends == null) {
            return;
        }
        if (user.friends.friendId.equals(friendId)) {
            user.friends = user.friends.next;
            return;
        }
        Friend current = user.friends;
        while (current.next != null && !current.next.friendId.equals(friendId)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    static void removeConnection(String firstId, String secondId) {
        User first = findUser(firstId);
        User second = findUser(secondId);
        if (first == null || second == null) {
            System.out.println("One or both users were not found");
            return;
        }
        if (!hasFriend(first, secondId)) {
            System.out.println("These users are not friends");
            return;
        }
        removeFriendId(first, secondId);
        removeFriendId(second, firstId);
        System.out.println("Removed connection between " + first.name + " and " + second.name);
    }

    static void displayMutualFriends(String firstId, String secondId) {
        User first = findUser(firstId);
        User second = findUser(secondId);
        if (first == null || second == null) {
            System.out.println("One or both users were not found");
            return;
        }
        System.out.println("Mutual friends of " + first.name + " and " + second.name + ":");
        boolean found = false;
        Friend current = first.friends;
        while (current != null) {
            if (hasFriend(second, current.friendId)) {
                findUser(current.friendId).displayDetails();
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No mutual friends");
        }
    }

    static void displayFriends(String userId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found: " + userId);
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        if (user.friends == null) {
            System.out.println("No friends yet");
            return;
        }
        Friend current = user.friends;
        while (current != null) {
            findUser(current.friendId).displayDetails();
            current = current.next;
        }
    }

    static void searchById(String userId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found: " + userId);
        } else {
            user.displayDetails();
        }
    }

    static void searchByName(String name) {
        boolean found = false;
        User current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                current.displayDetails();
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("User not found: " + name);
        }
    }

    private static int countFriends(User user) {
        int count = 0;
        Friend current = user.friends;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    static void displayFriendCounts() {
        if (head == null) {
            System.out.println("User list is empty");
            return;
        }
        User current = head;
        while (current != null) {
            System.out.printf("%s (%s): %d friends%n",
                    current.name, current.userId, countFriends(current));
            current = current.next;
        }
    }

    public static void main(String[] args) {
        addUser("U101", "Mihir", 21);
        addUser("U102", "Shrey", 20);
        addUser("U103", "Rishika", 21);
        addUser("U104", "Harsh", 22);
        addUser("U105", "Aarav", 20);

        System.out.println("=== Add Connections ===");
        addConnection("U101", "U102");
        addConnection("U101", "U103");
        addConnection("U101", "U104");
        addConnection("U102", "U103");
        addConnection("U102", "U104");

        System.out.println("\n=== Mutual Friends ===");
        displayMutualFriends("U101", "U102");

        System.out.println("\n=== Mihir's Friends ===");
        displayFriends("U101");

        System.out.println("\n=== Search by ID and Name ===");
        searchById("U103");
        searchByName("shrey");

        System.out.println("\n=== Friend Counts ===");
        displayFriendCounts();

        System.out.println("\n=== Remove a Connection ===");
        removeConnection("U101", "U104");
        displayFriends("U101");
        displayFriends("U104");
        displayFriendCounts();

        System.out.println("\n=== Duplicate, Self, and Missing Connections ===");
        addConnection("U101", "U102");
        addConnection("U101", "U101");
        addConnection("U101", "U999");
    }
}
