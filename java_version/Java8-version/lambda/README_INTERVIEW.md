# Java 8 Lambda – Interview Q&A (test26–test50)

## Domain data (used in test27–test50)

- **Student**: id, name, grade, marks, department  
- **Employee**: id, name, department, salary, age  
- **Department**: id, name, location  

Data is provided by `java_version.Java8_version.lambda.data.DataProvider`.

---

## test26 – Hirist-style (remove duplicates, partition, second highest, etc.)

## test27 – Student: grade A, sort by name  
## test28 – Employee: all names, filter salary > 60k  
## test29 – Group employees by department  
## test30 – Max / second highest salary  
## test31 – Students marks >= 80, sort by marks desc  
## test32 – Join employee names with delimiter  
## test33 – Count employees per department  
## test34 – Highest-paid employee per department  
## test35 – Total salary per department  
## test36 – Partition by high/low salary  
## test37 – Sort by department then salary desc  
## test38 – First employee in IT (Optional)  
## test39 – Distinct departments  
## test40 – Students by department, sorted by marks  
## test41 – Names of students with marks > 85  
## test42 – Average salary per department  
## test43 – Name contains 'a' and salary > 55k  
## test44 – Group students by grade  
## test45 – Department with most employees  
## test46 – Map name to salary (toMap)  
## test47 – Group by department then salary range  
## test48 – Top 3 by salary  
## test49 – Departments with at least one employee > 70k  
## test50 – Recap: highest-paid in IT, CS students by marks, count by dept  

---

## Compile & run (from project root)

Compile data and one test:

```bash
javac java_version/Java8-version/lambda/data/*.java java_version/Java8-version/lambda/test27/Main.java
java -cp . java_version.Java8_version.lambda.test27.Main
```

Replace `test27` with test28 … test50 as needed.
