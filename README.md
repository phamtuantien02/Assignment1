# Assignment1
To Compile through CMDPROMPT 
 - Type javac PrimeNumber.java
 - Type java PrimeNumber
This should compile the program and run the highest 10^8 and check for the primes within that number.

Documentation

The correctness of the program was tested with smaller numbers such as 30 and when the values that were predicted to show up did I just continued with my programing. The implemention that I used was the sieve of eratosthenes method and the multithreading that was used was to increase how fast the program ran. The only problem that I faced during implementation was that the sequential ran a little faster on my system than the multithreading approach. This was still negable as they would run slowest at around 3 seconds but this was very rare as I think that the time this ran this slow were that the cores were bad. The program behaved as expected when testing values of bigger/smaller then the highest test case of 10^8. When running 10^7 the program was about 10x slower. 
