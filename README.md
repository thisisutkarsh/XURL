# XURL

XURL is a utility that can be used to generate and retrieve short URLs when we don’t want to use the original longer URLs.

During the course of this project-

1. Created a short url library with required methods.
2. Implemented register method to take a long URL and return a shorter URL.
3. Implemented a method to lookup the long URL by providing the short URL.
4. Implemented hit count to track number of long URL lookups.
5. Tested this implementation with test cases.

## Scope of Work

1. Create a concrete class which implements a short URL interface class provided. It contains all the methods that can be used to create long URL to short URL mappings.
2. Implement a method to take a long URL as input, generate a random 9 character short URL and return it. Also maintain this mapping using a hash map for quick retrieval.
3. Implement a method to take a long URL and a custom short URL as input and register that mapping.
4. Error handling to make sure each long URL maps to only one short URL and vice versa.
5. Implement a method to lookup short URL for a given long URL, from the mapping created.
6. Implement a method to delete the mapping based on a long URL.
7. Implement a counter to keep track of the hit count for each long URL - which tells us how many times a particular long URL has been looked up.
8. Test these methods using test cases.
