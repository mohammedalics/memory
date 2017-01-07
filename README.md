# Introduction
An in‐memory database to store employee data. The program should accept commands (see Specifications table below) from terminal (command lines), perform tasks (add/update/delete/print/quit), and print the output to the console.

## Commands
```javascript
add <employee id>‐<employee name>-<designation>‐<monthly salary>
```
* Add a new employee to the DB
* print success or failure message with total employee count
* Perform basic validations

```javascript
del <employee id>
```
* Remove the employee with the supplied ID from DB
* print success or failure message with total employee count
* Perform basic validations

```javascript
update <employee id>‐<NAME/DESIG/SALARY><New Value>
```
* Update the employee data
* success or failure message with new employee details
* Perform basic validations

```javascript
print <employee id>
```
* Prints employee details to the console
* Print employee details to the console
* Perform basic validations

## Eaxamples:
 
```javascript
add 1001‐Ali‐Java Programmer‐10000
```
* output: Employee 'Ali' added successfully. Total no of employees = 1

```javascript
del 1002
```
* output: Employee '1002' not found

```javascript
add 1002‐Ahmed‐IT Manager‐22000
```
* output: Employee 'Ahmed' added successfully. Total no of employees = 2

```javascript
add 1003‐Fouad‐HR Officer‐20000
```
* output: Employee 'Fouad' added successfully. Total no of employees = 3

```javascript
update 1002‐SALARY‐25000
```
* output: Employee '1002' updated. Name: Ahmed, Designation: IT Manager, Salary: 25000

```javascript
print 1001
```
* output: Ali, Designation Java Programmer, Salary: 10000

```javascript
printall ASC
```
* output:
Ahmed : IT Manager
Ali : Java Programmer
Fouad : HR Officer

```javascript
Quit
```
* output:The application will exit.
