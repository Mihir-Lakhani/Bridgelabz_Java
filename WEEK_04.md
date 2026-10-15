# Week 04 - Generics, Collections, Lambda Expressions and Streams

All work belongs to the existing `feature/collections-streams` branch. Every program uses Java 8-compatible APIs and has a runnable `main()` (except the shared model/service classes).

The four assignment PDFs in `Desktop/BridgeLabz/week 4` provide the assignment requirements. The practical problems below come from the separate syllabus list. These are simple console exercises without Maven, external libraries or a framework.

## Run

In IntelliJ, open a program and run its `main()`. For the Streams project, run `AddressBookMain`.

From PowerShell at the project root:

```powershell
$sources = Get-ChildItem src/main/java -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac --release 8 -Xlint:-options -d out $sources
java -cp out Java_Collections.List.ReverseAList
java -cp out Java_LambdaExpressions.UserRegistration
java -cp out Java_Streams.AddressBookSystem.AddressBookMain
```

Use `--interactive` as a program argument for console registration or the full Address Book menu:

```powershell
java -cp out Java_LambdaExpressions.UserRegistration --interactive
java -cp out Java_Streams.AddressBookSystem.AddressBookMain --interactive
```

`WordFrequencyCounter` reads the included sample text from the project root by default. An optional first argument supplies another file path.

## Generics - 5 assignments

Folder: `src/main/java/Java_Generics`.

1. [Smart warehouse](src/main/java/Java_Generics/SmartWarehouseManagementSystem.java): existing bounded storage, typed retrieval and wildcard display retained.
2. [Dynamic marketplace](src/main/java/Java_Generics/DynamcOnlineMarketPlace.java): existing filename retained; category bounds, generic discounts and a mixed catalog. Numerical price ranges are demo choices because the source supplies none. `isInPriceRange()` checks a product; discounts reject invalid percentages/prices. Products are added directly with `catalog.add(...)`, as requested.
3. [University courses](src/main/java/Java_Generics/MultiLevelUniversityCourseManagementSystem.java): existing list-based `Course<T>` design retained; department labels, evaluation types and wildcard display.
4. [Personalized meals](src/main/java/Java_Generics/PersonalizedMealPlanner.java): Vegetarian, Vegan, Keto and High-Protein categories with a generic validation/generation method. Validation checks a nonblank name and nonempty, nonblank ingredients; no nutritional rules are supplied by the assignment. The generated plan preserves its specific type.
5. [Resume screening](src/main/java/Java_Generics/AIDrivenResumeScreeningSystem.java): bounded resumes, generic processing and mixed-role wildcard display. The skill comparison is a labelled deterministic demonstration, not an AI model or hiring recommendation.

## Collections - 25 assignments

Folder: `src/main/java/Java_Collections`.

### List

1. [Reverse a List](src/main/java/Java_Collections/List/ReverseAList.java): both ArrayList and LinkedList, without built-in reverse. The LinkedList version uses two iterators, avoiding O(n²) indexed access.
2. [Frequency of Elements](src/main/java/Java_Collections/List/FrequencyOfElements.java).
3. [Rotate Elements](src/main/java/Java_Collections/List/RotateElementsInAList.java): left rotation, matching the supplied example; negative positions rotate right.
4. [Remove Duplicates Preserving Order](src/main/java/Java_Collections/List/RemoveDuplicatesPreservingOrder.java).
5. [Nth Element from End](src/main/java/Java_Collections/List/NthElementFromEnd.java): two forward iterators, without calculating size; invalid N returns null. Java's LinkedList is doubly linked internally despite the question's wording.

### Set

1. [Check Equal Sets](src/main/java/Java_Collections/Set/CheckEqualSets.java).
2. [Union and Intersection](src/main/java/Java_Collections/Set/UnionAndIntersection.java).
3. [Symmetric Difference](src/main/java/Java_Collections/Set/SymmetricDifference.java).
4. [Convert Set to Sorted List](src/main/java/Java_Collections/Set/ConvertSetToSortedList.java).
5. [Check Subset](src/main/java/Java_Collections/Set/CheckSubset.java).
6. [Insurance Policy Management](src/main/java/Java_Collections/Set/InsurancePolicyManagementSystem.java): HashSet, LinkedHashSet and an expiry-ordered TreeSet; duplicate policy numbers, coverage/30-day filters, removal and an elapsed-time demonstration. Duplicate numbers retain the first policy. The TreeSet is a secondary index of canonical records, ordered by expiry then number so equal dates retain separate policies. Timings vary and are not a rigorous benchmark; expected hash operations are O(1), tree operations O(log n), and name/number scans remain O(n).

### Queue

1. [Reverse a Queue](src/main/java/Java_Collections/Queue/ReverseAQueue.java): FIFO queue operations only; O(n²) time, O(n) helper storage.
2. [Generate Binary Numbers](src/main/java/Java_Collections/Queue/GenerateBinaryNumbers.java): begins with 1; N <= 0 returns an empty list.
3. [Hospital Triage](src/main/java/Java_Collections/Queue/HospitalTriageSystem.java): supplied severity values determine priority; arrival breaks ties.
4. [Stack Using Two Queues](src/main/java/Java_Collections/Queue/StackUsingTwoQueues.java): O(n) push, O(1) pop/top; empty pop/top return null.
5. [Circular Buffer](src/main/java/Java_Collections/Queue/CircularBufferSimulation.java): fixed array capacity, overwrite oldest when full; empty removal returns null; capacity must be positive.

### Map

1. [Word Frequency Counter](src/main/java/Java_Collections/Map/WordFrequencyCounter.java), with [sample input](src/main/java/Java_Collections/Map/WordFrequencySample.txt). UTF-8 input, case-insensitive counts; punctuation acts as a word boundary. HashMap stores counts, a TreeMap copy makes display predictable.
2. [Invert a Map](src/main/java/Java_Collections/Map/InvertAMap.java): returns `Map<V, List<K>>`, which is required to retain duplicate original values.
3. [Key with Highest Value](src/main/java/Java_Collections/Map/KeyWithHighestValue.java): first encountered key wins ties; empty map returns null; keys and values are non-null.
4. [Merge Two Maps](src/main/java/Java_Collections/Map/MergeTwoMaps.java): sum common values; inputs stay unchanged.
5. [Group Employees by Department](src/main/java/Java_Collections/Map/GroupEmployeesByDepartment.java).
6. [Insurance Policy Management](src/main/java/Java_Collections/Map/InsurancePolicyManagementSystem.java): HashMap lookup, LinkedHashMap insertion order and `TreeMap<LocalDate, List<Policy>>`; retrieve by number/holder, filter upcoming expiry and remove expired policies. Updating a number replaces its details in every index. Both insurance assignments include today through today + 30 days; expiry before today is expired.
7. [Voting System](src/main/java/Java_Collections/Map/VotingSystem.java): alphabetical result order; LinkedHashMap records each candidate's first-vote order, not a history of every individual vote.
8. [Shopping Cart](src/main/java/Java_Collections/Map/ShoppingCart.java): product lookup, addition order and grouped price order. Re-adding a product replaces its price; quantities are not part of this question.
9. [Banking System](src/main/java/Java_Collections/Map/BankingSystem.java): FIFO withdrawals, missing/invalid/insufficient-balance rejection and grouped balance order. Money is stored in integer cents in this and the shopping program; this is a single-threaded exercise.

Both insurance exercises reuse [Policy](src/main/java/Java_Collections/Models/Policy.java), whose identity is its immutable policy number.

## Lambda assignment - UC13

[UserRegistration](src/main/java/Java_LambdaExpressions/UserRegistration.java) uses `Predicate<String>` lambdas for first name, last name, email, mobile and password, based on UC1-UC8 validation rules. It includes valid/invalid examples and console entry.

Names use ASCII letters; email follows the source's classroom shape; mobile has country code, one space and 10 digits. Passwords require at least 8 characters, an uppercase letter, a digit and exactly one special character. The demo excludes whitespace/non-ASCII characters; lowercase is not required. UC9's separately referenced email sample file was not included, so no claim is made about those unavailable samples. Earlier JUnit/custom-exception UCs are not added as Week 04 tasks.

## Streams assignments - UC7-UC12

Folder: [Java_Streams/AddressBookSystem](src/main/java/Java_Streams/AddressBookSystem).

- [Contact](src/main/java/Java_Streams/AddressBookSystem/Contact.java): all required fields, name-based equals/hashCode and complete toString. Identity uses trimmed, case-normalized first and last names. Zip stays a String to retain leading zeros.
- [AddressBook](src/main/java/Java_Streams/AddressBookSystem/AddressBook.java): UC7 duplicate prevention with `anyMatch`; add/find/edit/delete support. The same person can exist in different books.
- [AddressBookService](src/main/java/Java_Streams/AddressBookSystem/AddressBookService.java): UC8 `searchByCity`/`searchByState`; UC9 `personsByCity`/`personsByState`; UC10 `countByCity`/`countByState`; UC11 `sortByName`; UC12 separate `sortByCity`, `sortByState`, `sortByZip` functions. Stream grouping retains all contacts. Dictionaries are rebuilt from current data after edits/deletions.
- [AddressBookMain](src/main/java/Java_Streams/AddressBookSystem/AddressBookMain.java): labelled UC demonstrations and an optional console menu, including UC11 console book selection and name sorting. Minimal UC1-UC6 support provides multiple named books, entry, edit and delete.

Book names are unique and case-sensitive. Place grouping/search is case-insensitive. Name sorting uses first name then last; sorting returns a new list. Zip sorting is lexicographic, appropriate for the fixed-width digit examples; no international postal ordering rule was supplied.

## Separately listed practical problems - all 20

Six exact overlaps reuse the assignment implementations above instead of duplicating code:

1. Remove duplicates: List/RemoveDuplicatesPreservingOrder.
2. Find duplicates: [FindDuplicateElements](src/main/java/Java_Collections/PracticeProblems/FindDuplicateElements.java).
3. Frequencies: List/FrequencyOfElements.
4. First non-repeated: [FirstNonRepeatedElement](src/main/java/Java_Collections/PracticeProblems/FirstNonRepeatedElement.java).
5. Common list elements: [CommonElementsBetweenLists](src/main/java/Java_Collections/PracticeProblems/CommonElementsBetweenLists.java).
6. Set union/intersection: Set/UnionAndIntersection.
7. Sort custom objects: [SortCustomObjects](src/main/java/Java_Collections/PracticeProblems/SortCustomObjects.java).
8. Sort map by keys: [SortMapByKeys](src/main/java/Java_Collections/PracticeProblems/SortMapByKeys.java).
9. Sort map by values: [SortMapByValues](src/main/java/Java_Collections/PracticeProblems/SortMapByValues.java).
10. Highest/lowest values: [HighestAndLowestValues](src/main/java/Java_Collections/PracticeProblems/HighestAndLowestValues.java).
11. Kth largest: [KthLargestElement](src/main/java/Java_Collections/PracticeProblems/KthLargestElement.java), counting repeated occurrences.
12. Group elements: Map/GroupEmployeesByDepartment.
13. Word counts: Map/WordFrequencyCounter.
14. Queue using deque: [QueueUsingDeque](src/main/java/Java_Collections/PracticeProblems/QueueUsingDeque.java).
15. Stack using deque: [StackUsingDeque](src/main/java/Java_Collections/PracticeProblems/StackUsingDeque.java).
16. Duplicate words: [DuplicateWordsInAString](src/main/java/Java_Collections/PracticeProblems/DuplicateWordsInAString.java).
17. Remove nulls: [RemoveNullValues](src/main/java/Java_Collections/PracticeProblems/RemoveNullValues.java).
18. Merge maps: Map/MergeTwoMaps.
19. Most frequent: [MostFrequentElement](src/main/java/Java_Collections/PracticeProblems/MostFrequentElement.java), first-encountered winner on ties.
20. LRU cache: [LRUCacheUsingLinkedHashMap](src/main/java/Java_Collections/PracticeProblems/LRUCacheUsingLinkedHashMap.java), using access order and eldest-entry eviction.

Practical demos state their assumptions in the code: first non-repeated/most-frequent strings are non-null, natural-order maps/collections require comparable non-null keys/elements, and queue/deque examples reject null. All examples are single-threaded unless explicitly stated otherwise.
