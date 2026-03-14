# Test 6: BDD with Cucumber (Gherkin)

## Simple Explanation
BDD (Behavior-Driven Development) writes tests in plain English
that both developers and non-technical stakeholders can understand.

## Gherkin Syntax
```gherkin
Feature: User Login

  Scenario: Successful login with valid credentials
    Given  a user with username "vikas" and password "pass123" exists
    When   the user logs in with username "vikas" and password "pass123"
    Then   the response status should be 200
    And    the response should contain a JWT token

  Scenario: Failed login with wrong password
    Given  a user with username "vikas" exists
    When   the user logs in with password "wrong"
    Then   the response status should be 401
```

## Step Definitions (Java)
```java
@Given("a user with username {string} and password {string} exists")
public void givenUser(String username, String password) {
    userRepo.save(new User(username, encoder.encode(password)));
}

@When("the user logs in with username {string} and password {string}")
public void whenLogin(String username, String password) {
    response = mockMvc.perform(post("/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"username\":\"" + username + "\"}"));
}

@Then("the response status should be {int}")
public void thenStatus(int status) throws Exception {
    response.andExpect(status().is(status));
}
```

## Value: Non-technical people write scenarios, devs implement them!
