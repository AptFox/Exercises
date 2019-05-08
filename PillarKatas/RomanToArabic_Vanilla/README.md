### Goal
For this project we would like you to design a program to work with Roman numerals - converting Roman numeral to their arabic number equivalent.

### Description
The Romans wrote their numbers using letters; specifically the letters "I, V, X, L, C, D, and M." 
* **I** == 1
* **V** == 5
* **X** == 10
* **L** == 50
* **C** == 100
* **D** == 500
* **M** == 1000

There are certain rules that Roman Numerals follow which must be observed.

* Roman numerals are read left-to-right.
* There is no concept of the Arabic zero placeholder
* The symbols **I**, **X**, **C**, and **M** can be repeated at most 3 times in a row. 
* **V**, **L**, and **D** can never be repeated.
* As arabic numbers can be split into their constituent parts (1066 becomes 1 0 6 6), so too can Roman numerals.  1066 becomes **MLXVI**, or **M** (1000) **LX** (60) and **VI** (6)).
* The symbols (**I**, **X**, and **C**) can only be subtracted from the 2 next higher values.  For example,
  * **IV** and **IX** -- (usage of **I** in subtraction rule)
  * **XL** and **XC** -- (usage of **X** in subtraction rule)
  * **CD** and **CM** -- (usage of **C** in subtraction rule)
  * The symbols (**V**, **L**, and **D**) can *never* be subtracted.
* Only one subtraction can be made per numeral (**XC** is allowed, **XXC** is not).
