Ben Formosa
Student No. 11429074

ICT322 Assessment 1

Manifest:
README.txt				- this file
src/BaseAccount.java	- superclass representing a bank account
src/SavingsAccount.java	- class representing a Savings account
src/ChequeAccount.java	- class representing a Chequeing account
src/TestAccounts.java	- testing suite for BaseAccount and subclasses
src/CreditLimit.java	- interface that supports storing a credit limit
src/Interest.java		- interface that supports adding interest
src/Withdrawable.java	- interface that supports withdrawals


Building and Running
*Build javadoc:
		javadoc -d doc src/*
*Compile
		mkdir bin
		javac -classpath bin -sourcepath src -d bin src/*.java
*Run
		java -classpath bin TestAccounts
		
Explanation:
Implementing Comparable requires defining the compareTo method. To do this for BaseAccount, I used String.compareTo with the owner's name as an argument. If the names are the same, the accounts will be sorted by acctnumber.
Implementing Comparable allows using using Arrays.sort() to sort the list of accounts in TestAccounts. Arrays.sorts() uses the compareTo() method to determine the 'natural' order of the objects.

Eclipse is able to generate the equals method based on the variables in that class. The generated method checks if the objects are the same instance, if one is null, if they are the same class ((A)a instanceof B is true if A is a subclass of B), then all the variables are compared.

SavingsAccount.addInterest simply checks if the rate given is not negative, then increases the balance accordingly.
Deposit and withdraw check for correct input, then adjust the balance.

I defined the transaction charge as a static to keep the value in one location only.
Deposit and withdraw are similar to SavingsAccount's, but deduct the transaction charge.

TestAccounts loops over the provided list of accounts several times, checking the accounts and then performing the operations as specified.
TestAccounts requires determining what features the Account supports. The assingnment definition suggests using the instanceof operator.
I decided that something like 'object instaceof Class' didn't make sense, when what I really wanted to know was the features available to that object, such as withdrawal. 
Java interfaces would give me this functionality. I created some simple interfaces, most just defining one method. Then I can implement those interfaces in each class if they should contain that method.
