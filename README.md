# base-function-calculator
A program that calculates the result of a given function. Results are stored in a cache with LRU replacement policy. 

- A linked list is used for the cache mechanism. The new values (that were not calculated before) are always attached to the head of the list and the values at the end of the list naturally becomes the oldest. When a cache lookup happens, list is searched from the head to the tail, resulting the newer values to be found easier than older values.
- Cache size is assumed to be set by user using setCacheSize function before any operation. The last element on list (tail of the list) will be deleted if the cache reaches maximum capacity defined by the user.
- Consecutive lookups for a value causes the priority of it to increase in the cache. The value will be swapped with the value before it in the linked list, if it already does not have the highest priority. See comments for further details.
