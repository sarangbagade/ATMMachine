**Design an ATM Machine**

This is an inhouse ATM Machine for a Bank. Implement the following functionalities :
- Cash Withdrawal 
: Amount validation before dispensing cash 
- Modifying a Card Pin
   : User must provide a new pin and the pin should get changed to this value. 
- Display Mini statement : Show last 5 transactions. 
- Check Account Balance : Show the current balance of the card.


   **Requirements**:

- User should have ability to cancel a transaction at an given moment
- User must enter the card and correct pin for authentication in all cases.
- ATM should validate the card and pin.
   
Evaluation criteria :-

- Modularity of Code
- Reusability
- Extensibility 
- Test cases & Correctness

**About this Repo**:
- this is spring boot repo, but i havent used any of its feature because of
cyclic dependency between atm machine states
- code is implemented using state and singleton pattern
- It also makes use of Abstract factory pattern
- I have read design patterns in "Head first design patterns" by Eric Freeman and Elisabeth Robson.