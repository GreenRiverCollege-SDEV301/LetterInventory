# LetterInventory

### Description
This repository holds my submission to an assignment for SDEV301 Systems Programming at Green River College. The purpose of this assignment was to become familiar with the memory impact of using bytes, shorts, and ints via creating methods for `LetterInventory`.

`LetterInventory` is a class that has two constructors - one that takes in no arguments, and one that takes in a String argument. The class keeps track of private inventory, a short[] that keeps track of how many letter counts a string has (case-insensitive).

Each letter should correspond to an index (i.e. a -> 0, b -> 1, c -> 2, d -> 3, and so on).


For example:
- "WashingtonState" would result in `[2,0,0,0,1,0,1,1,1,0,0,0,0,2,1,0,0,0,2,3,0,0,1,0,0,0]`, which wouuld print out as `[aaeghinnosstttw]`.

### How to Run the Project
This code can be run as-is with the IntelliJ IDEA IDE from Jetbrains, as long as [Java has been installed](https://www.oracle.com/java/technologies/downloads/) locally.
