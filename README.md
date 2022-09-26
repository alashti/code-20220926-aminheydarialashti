## BMI calculator
A thread pool based program for calculating BMI value and 
the corresponding category and health risk.

### Input/Output
The structure of input and output of the system can be found in 
datastructure package: Person(input) and Report(output). 
The input json should be a list of Persons' information like
height, weight, gender. 

`[{"Gender": "Male", "HeightCm": 171, "WeightKg": 96 },{ "Gender": "Male", "HeightCm": 161, "WeightKg": 85 }]`

And the output will contain the three following
parameters: BMI value, BMI category, and the related health risk. Moreover, 
the total number of over weight people in the input will be added
to the output. 

`{"overWeightPeople":0,"bmiData":[{"Gender":"Male","HeightCm":171,"WeightKg":96,"bmi":32.8,"bmiCategory":"MODERATELY_OBESE","healthRisk":"Medium risk"},{"Gender":"Male","HeightCm":161,"WeightKg":85,"bmi":32.7,"bmiCategory":"MODERATELY_OBESE","healthRisk":"Medium risk"}}`

### BMI value Interpreter
The BmiInterpreter is responsible to interpret the calculated BMI value 
and convert it to the BMI category and the health risk. An Enum with 
three properties are used to represent BMI categories and their properties. 

### BMI calculator
This class proposes the method for calculating BMI value based on 
height and weight of a person, i.e. `BMI(kg/m2) = mass(kg) / height(m)2`

Three different methods tested, but the two which were working most 
properly are remained in the class. A load test is added in the test 
class of the calculator, and the test result is as below: 
<table>
<tr><td>Method</td><td>Execution Time Average</td></tr>
<tr><td>StringFormat</td><td>700-800ms</td></tr>
<tr><td>Arithmetic</td><td>12-15ms</td></tr>
</table>

### Controller
BmiSplitter is the controller of the service. It is reponsible to 
deserialize, partition, and send each part of the input data to a 
a single worker thread from thread-pool. Each thread is responsible 
to add the requested BMI-related properties to the input and 
return them back to the controller(BMISplitter). 

A load test is implemented for the controller too. The response time 
for an input size of one million records is about 2500 ms. 

### Build
Follow the underlying steps:

1. `git clone github.com/alashti/code-20220926-aminheydarialashti`
2. `mvn clean install`
3. add following dependency to a project:
```xml
<dependency>
  <groupId>ir.alashti</groupId>
  <artifactId>bmicalculator</artifactId>
  <version>1.0.0</version>
</dependency>
```
4. To send a json input to the code please use BmiSplitter. But if 
you need the BMI calculator solely please use BmiCalculator.
   
* **NOTE:** check implemented tests for more in detail usage of the code.  