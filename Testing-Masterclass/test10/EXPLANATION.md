# Test 10: ArchUnit — Enforcing Architecture Rules via Tests

## Simple Explanation
ArchUnit lets you write tests that enforce architectural rules.
If a developer violates the rule → the test fails!

## Example Rules
```java
@AnalyzeClasses(packages = "com.example")
class ArchitectureTest {

    // Rule 1: Controllers must not call Repositories directly
    @ArchTest
    static final ArchRule no_controller_to_repo = noClasses()
        .that().resideInAPackage("..controller..")
        .should().dependOnClassesThat().resideInAPackage("..repository..");

    // Rule 2: Services should not use Spring @Autowired field injection
    @ArchTest
    static final ArchRule no_field_injection = noFields()
        .that().areDeclaredInClassesThat().resideInAPackage("..service..")
        .should().beAnnotatedWith(Autowired.class);

    // Rule 3: All public service methods should be @Transactional
    @ArchTest
    static final ArchRule services_are_transactional = methods()
        .that().arePublic()
        .and().areDeclaredInClassesThat().resideInAPackage("..service..")
        .should().beAnnotatedWith(Transactional.class);
}
```

## Why This is Powerful
Over time, developers break architectural rules by accident.
ArchUnit makes these rules AUTOMATED and tested — violations are caught in CI!
