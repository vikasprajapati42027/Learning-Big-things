# test2: Model, View, Controller + Parent/Child + Lambda

## Structure

| Class            | Role |
|------------------|------|
| **Model**        | Holds data (message, count). No UI. |
| **View**         | Displays data. Accepts **lambda** for *what to show* and *what to do on click*. |
| **Controller**   | **Parent**. Has Model + View. Calls View with lambdas that read/update Model. |
| **ChildController** | **Child** of Controller. Overrides `refreshView()`, adds `handleReset()`, uses lambdas. |

## Lambda usage

1. **View.display(Supplier<String> contentSupplier)**  
   Controller passes a lambda that supplies the string to show, e.g.  
   `view.display(() -> model.getMessage() + " (count=" + model.getCount() + ")");`  
   So the *view* just calls `contentSupplier.get()`; the *controller* decides the content via lambda.

2. **View.onButtonClick(Runnable action)**  
   Controller passes a lambda for the action, e.g.  
   `view.onButtonClick(() -> { model.incrementCount(); model.setMessage("Clicked!"); });`  
   So the view runs `action.run()`; the controller defines the behavior via lambda.

3. **ChildController** extends Controller and uses the same View + lambda style for its own messages and reset behavior.

## Run

From project root:

```bash
javac java_version/Java8-version/lambda/test2/*.java
java -cp . java_version.Java8_version.lambda.test2.Main
```
