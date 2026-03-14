# Java 8 – test51 to test100 (Model + List data, Q&A)

## Model package (getter/setter + list data)

- **model.Student** – id, name, grade, marks, department (getters/setters)
- **model.Employee** – id, name, department, salary, age (getters/setters)
- **model.Department** – id, name, location, list of employees (getters/setters)
- **model.ModelData** – getStudentList(), getEmployeeList(), getDepartmentList() and setters to replace lists

All tests use `ModelData data = new ModelData();` and `data.getStudentList()`, `data.getEmployeeList()`, `data.getDepartmentList()`.

---

## Question & Answer summary

| Test | Question | Answer (idea) |
|------|----------|----------------|
| 51 | Filter students grade A | filter(s -> "A".equals(s.getGrade())) |
| 52 | Filter employees salary > 60k | filter(e -> e.getSalary() > 60000) |
| 53 | Filter departments by location | filter(d -> "Building-A".equals(d.getLocation())) |
| 54 | Sum of student marks | mapToInt(Student::getMarks).sum() |
| 55 | Total salary by department | groupingBy + summingDouble |
| 56 | Average marks | mapToInt(Student::getMarks).average() |
| 57 | Count employees per department | groupingBy + counting |
| 58 | Group students by department | groupingBy(Student::getDepartment) |
| 59 | 10% salary increment (new list) | map to new Employee with salary*1.1 |
| 60 | +5 bonus marks (new list) | map to new Student with marks+5 |
| 61 | In-place 10% raise | forEach(e -> e.setSalary(e.getSalary()*1.1)) |
| 62 | Filter marks>=80, set list in model | collect then setStudentList(filtered) |
| 63 | Max salary | map(Employee::getSalary).max(Double::compareTo) |
| 64 | Student names only | map(Student::getName).collect(toList()) |
| 65 | Average salary per department | groupingBy + averagingDouble |
| 66 | Sort by marks desc, update model | sorted(reversed), setStudentList |
| 67 | Partition IT vs non-IT | partitioningBy(e -> "IT".equals(e.getDepartment())) |
| 68 | Department names to uppercase | map to new Department with getName().toUpperCase() |
| 69 | Count students per grade | groupingBy(Student::getGrade, counting()) |
| 70 | First HR employee | filter(HR).findFirst() |
| 71 | +10 marks only for grade C | map: if grade C then new Student(..., marks+10) |
| 72 | Top 3 by salary | sorted(reversed).limit(3) |
| 73 | Join student names | map(Student::getName).collect(joining(", ")) |
| 74 | Dept -> list of names | groupingBy + mapping(Employee::getName, toList()) |
| 75 | CS students sorted by name | filter(CS).sorted(comparing(Student::getName)) |
| 76 | Highest-paid in IT | filter(IT).max(comparing(Employee::getSalary)).map(getName) |
| 77 | Distinct locations | map(Department::getLocation).distinct() |
| 78 | Marks>=90 set grade A | map: if marks>=90 new Student(..., "A", ...) |
| 79 | Name to salary map | toMap(Employee::getName, Employee::getSalary, merge) |
| 80 | Summary statistics for marks | summarizingInt(Student::getMarks) |
| 81 | Second highest salary | sorted(reversed).skip(1).findFirst() |
| 82 | Distinct student departments | map(getDepartment).distinct() |
| 83 | Age>30 and salary>55k | filter(age>30 && salary>55000) |
| 84 | Sum marks per department | groupingBy + summingInt(Student::getMarks) |
| 85 | HR +5% salary (new list) | map: if HR then new Employee(..., salary*1.05) |
| 86 | Any student with marks 95 | filter(marks==95).findAny() |
| 87 | Min salary per department | groupingBy + minBy(comparing(Employee::getSalary)) |
| 88 | Marks between 70 and 90 | filter(marks>=70 && marks<=90) |
| 89 | Sort employees by name, update model | sorted(comparing(Name)), setEmployeeList |
| 90 | Average marks per department | groupingBy + averagingDouble(Student::getMarks) |
| 91 | IT employee names | filter(IT).map(Employee::getName) |
| 92 | Student with min marks | min(Comparator.comparing(Student::getMarks)) |
| 93 | All departments location="Main" | map to new Department(..., "Main") |
| 94 | Department with max total salary | groupingBy+summingDouble, then max(comparingByValue) |
| 95 | Skip first 2 students | skip(2).collect(toList()) |
| 96 | All salary > 50k? | allMatch(e -> e.getSalary() > 50000) |
| 97 | Any marks >= 95? | anyMatch(s -> s.getMarks() >= 95) |
| 98 | Age +1 for all (new list) | map to new Employee(..., getAge()+1) |
| 99 | Group by dept, sort each by marks desc | groupingBy + collectingAndThen(toList, sort) |
| 100 | Recap: filter grade A names, total/avg salary, set list to IT only | filter, map, join; sum/average; setEmployeeList |

---

## Compile & run (from project root)

```bash
javac java_version/Java8-version/lambda/model/*.java java_version/Java8-version/lambda/test51/Main.java
java -cp . java_version.Java8_version.lambda.test51.Main
```

Replace `test51` with test52 … test100 as needed.
