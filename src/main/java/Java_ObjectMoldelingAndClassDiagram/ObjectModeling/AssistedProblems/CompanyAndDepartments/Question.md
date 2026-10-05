#### Problem 3: Company and Departments (Composition)

- **Description**: A `Company` has several `Department` objects, and each department contains `Employee` objects. Model this using composition, where deleting a company should also delete all departments and employees.
- **Tasks**:
  - Define a `Company` class that contains multiple `Department` objects.
  - Define an `Employee` class within each `Department`.
  - Show the composition relationship by ensuring that when a `Company` object is deleted, all associated `Department` and `Employee` objects are also removed.

#### Implementation note

The company creates its departments, and each department creates its own employee objects. The employee class is nested inside `Department`. Owned objects and their lists are not returned to callers.

`deleteCompany()` models deletion by clearing employees from every department, clearing the department list, and preventing additions to the deleted company. Java has no explicit object-deletion operation: unreachable objects become eligible for garbage collection. The company object itself remains reachable through `c1` so the example can display its deleted state.
