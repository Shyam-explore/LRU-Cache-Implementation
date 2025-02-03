# LRU-Cache-Implementation
This project demonstrates your expertise in Data Structures &amp; Algorithms (DSA) and Object-Oriented Programming (OOPs) by implementing an LRU (Least Recently Used) Cache using a Doubly Linked List and a HashMap

📜 CACHE_INTRO
Caching is a technique to store frequently accessed data in a fast-access storage layer.
It speeds up data retrieval by reducing redundant computations and database queries.

Why is caching needed?
- Improves performance and reduces latency.
- Minimizes the load on databases and APIs.
- Enhances user experience by making applications faster.

Types of caching:
1. In-memory caching (Redis, Memcached)
2. CPU caches (L1, L2, L3)
3. Application-level caching (CDNs, local storage)


📜 IN_MEMORY_CACHE
In-memory caching stores data in RAM for fast access.

Redis:
- Open-source, key-value store.
- Supports persistence & replication.
- Used in real-time applications.

Memcached:
- High-performance, distributed caching system.
- Works only in RAM, no persistence.
- Used for session storage and web caching.

Redis vs Memcached:
- Redis supports data persistence; Memcached does not.
- Redis supports complex data types; Memcached only key-value pairs.

  
📜 CACHE_MEMORY
Cache memory is a high-speed storage layer in a computer system that stores frequently accessed data.

Levels of Cache:
- L1 Cache: Fastest, closest to the CPU.
- L2 Cache: Larger, shared between CPU cores.
- L3 Cache: Largest, shared among all cores.

Benefits:
- Reduces CPU access time.
- Speeds up execution of frequently used instructions.
- Improves overall system performance.

  
📜 REPLACEMENT_STRATEGIES
Cache replacement strategies determine how old data is removed when the cache is full.

1. FIFO (First-In, First-Out)
   - Removes the oldest item first.
   - Simple, but not efficient.

2. LRU (Least Recently Used)
   - Removes the least recently accessed item.
   - Used in real-world applications (like your LRU Cache).

3. LFU (Least Frequently Used)
   - Removes the least accessed item.
   - Useful for recommendation systems.

4. Random Replacement
   - Randomly removes an item.
   - Used in hardware caching.
