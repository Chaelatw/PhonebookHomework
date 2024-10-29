# PhonebookHomework
Collections
- 
-A collection is an object that holds zero, one, or many other objects
    called elements of the collections

Collection of Collections
-

|       | Collections |       |         
|-------|-------------|-------|
| Lists | Sets        | Queue |
|       | SortedSet   | Deque |

| Maps      |
|-----------|
| SortedMap |

List collection
    -a collection that has ordering of elements, and each element has a given index
Sets
    -has uniqueness as a key property
Queue/double-ended queue/Deque interfaces
    -have properties around the way in which the elements are added and removed from the collection

| Interfaces                         | Implementation              |
|------------------------------------|-----------------------------|
| Multiple data structures           | Specific data structures    |
| Functional characteristics         | Performance characteristics |
| Prefer as variable type            | Concrete and instantiable   |
| Often has a popular implementation |                             |
    

|             | Collection    |                |   |
|-------------|---------------|----------------|---|
| **LIST**        | **SET**       | **QUEUE**      |   |
| -ArrayList  | -HashSet      | -PriorityQueue |   |
| -LinkedList | **SORTEDSET** | **DEQUE**      |   |
|             | -TreeSet      | -LinkedList    |   |
|              |                | -ArrayDeque    |       |

| **MAP**       |
|---------------|
| -HashMap      |
| **SORTEDMAP** |
| -TreeMap      |


Are your elements keyed?
If yes:
    Order is important?
        No: **Map**
        Yes: **Sorted Map**
If no:
    Elements must be unique?
        If Yes:
            Order is Important?
                No: **Set**
                Yes: **SortedSet**

Insertion order matter?
    Yes and doesn't have to be unique:
            **Deque**
    Otherwise:
            **List**



Iterable 
- Iterator
- Collection

**Set of Operations**

- _size()_: get the number of elements in the collection
- _isEmpty()_: true if size() == 0, false otherwise
- _add()_: ensure that an element is in the collection
- _addAll()_: add all the elements of the argument collections to this collection
- _remove(element)_: remove the element from this collection
- _removeAll(collection)_: to this collection
- _retainAll(collection)_: remove all the elements of this collection not in the argument collection
- _contains(element)_: true if the element is in the collection, false otherwise
- _containsAll(collection)_: true if all the elements of the argument collection are in this collection
- _clear()_: remove all the elements from this collection


# Lists

Lists
    - collections with iteration order

-Each element has an index.
An index is an int representing its position in the List. We can modify Lists using indices.

    void add(int index, E e);
    E get(int index);
    E remove(int index);
    E set(int index, E element);
    boolean addAll(int index, Collection c);

-You can look up indices
    
    int indexOf(Object o);
    int LastIndexOf(Object o);
if it's not in the list, they will return as -1 in the index.

-Sublists are views over ranges of lists.
-Modifying the view modifies the list.

    List subList(int fromIndex, int toIndex);

-Sorting

    list.sort(Comparator<? Super E> comprarator)

- Factory Methods
- List Static Factory Methods
- Creates Unmodifiable List instances
- Overloads for 0-10 arguments
- Varargs constructor for >10 arguments
- Creates an unmodifiable copy of an existing collection


    List<E> of()
    List<E> of(E e1)
    List<E> of(E e1, E e2)
    List<E> of(E ... elements)
    List<E> copyOf(Collection<E>)

# Implementations
- Interfaces: defines behavior
- Implementations determine performance

- ArrayList:
    - Good general purpose implementation
    - Use as default
    - CPU Cache sympathetic
  
- LinkedLIst:
    - Worse performance in most cases
    - Use when adding elements at start
    - Or when adding/remove a lot

- Empty ArrayList : null
- Growing ArrayList : double strategy
- Avoid:
  - Vector
  - Stack


## Storing Key/Value Pairs: Maps

Map MPI
- Adding and replacing
  - put for a single value, putAll for another Map
  - Null keys and values are implementation specific

          V put(K key, V value)
          void putAll(Map<? extends K, ? extends V> values)


- V: get(Object key);
  - Looking up elements
- boolean: containsKey(Object key);
  - Separate contain methods for key and value
- boolean: containsValue(Object value);
  - Objects allow more flexible generic contracts

Removing:
    
    V remove(Object key)

Querying Size:
    
    int size()
    boolean isEmpty()

Immutable Map Factories - Individual key/value pairs
    
    Map.Entry<String, Integer> entry = 
        Map.entry("Richard", 38);

Up to 10 value specific overload Factories
    
    Map<String, Integer> personToAge =
        Map.of("Richard", 38);

For > 10 varargs factory takes entry objects

    personToAge = Map.ofEntries(
        Map.entry("Richard", 38));

Immutable Copies of an existing Map

    Map<String, Integer> copy =
        Map.copyOf(personToAge);

Collection and Maps
- Map is the only collections that don't extend or implement the Collection interface

Advanced Operations
-
Altering and Removing

- replace(key, value): update a single value
- replaceAll(BiFunction<K,V,V>): Replace elements using a function
- remove(key, value): Remove a key only if it has a value

Updating
-
- getOrDefault
- computeIfAbsent
- putIfAbsent
- computeIfPresent
- compute
- merge

forEach: Convenient callback iteration

Implementations
-
General Purpose Implementations:
- HashMap: Good general purpose implementation
    - Good general purpose implementation
    - Uses the .hashCode() method
    - Maintains an array of buckets
    - rehash(hash) % bucket_count
    - Buckets are linked lists to accommodate collisions
    - Buckets can be trees
    - The number of buckets increases with more elements
- TreeMap: Defines sort order and adds functionality
    - Comparator: Key elements have a sort order
    - Red/Black Tree: A balanced binary tree
    - Navigable & Sorted: Provides functionality that HashMap doesn't

Special Purpose Implementations
-
LinkedHashMap : First Special Purpose Map implementation
- When: Useful for implementing Size based caches
- Maintains Order: Either Insertion or Access
- removeEldestEntry: Subclass and Override method in order to control cache

| IdentityHashMap           | HashMap                          |
|---------------------------|----------------------------------|
| _System.identityHashCode()_ | object.equals() & obj.hashCode() |
| Use for Serialisation     | Use normally                     |
| Faster & Lower Memory     | Avoids coupling Map to Keys      |
| Low Collission Likelihood |                                  |
| Violates Map Contract     |                                  |

WeakHashMap
- Useful for a Memory Bounded Cache
- Keys have weak references, can be collected if nothing else references them
- Entries can be removed after the key is collected

EnumMap
- Keys are Enums
  - Faster and Low memory usage
- Bitset Implementation
  - Only a single long if < 64 elements


# Sets
Sets are collections of distinct elements. There are no duplicates.

Hashcode/Equals Contract
- One way of implication

        object.equals(other)
                ->
        object.hashCode() == other.hashCode()

Equality
- It can be reference based or value based. 
- Reference based just needs to inherit equals from Object.
- Value based requires a custom equals method.

Combine hashcode information from each field
IDE can auto-generate
        
    result = 31 * result + obj.hashCode();
    // Arrays
    Arrays.hashCode()

Objects.has()(Java7+)

    //Primitives (Java 8+)
    Long.hashCode(longValue)

ALWAYS use the same fields as equals()

    //Old Primitives
    (int) (1 ^ (1 >>> 32))
    Float.floatToIntBits(f);


HashSet
-
Based upon HasMap
- Uses the hashCode() and looks up location

Good general purpose implementation
- Use by default

TreeSet
-
Based upon TreeMap
- Red/Black binary tree with defined sort order

Provides Extra Features
- Implements SortedSet and NavigableSet

LinkedHashSet
-
When:
- Copying Set to modify
- Deduping List or Queue

Maintains Order
- Only Insertion

Overhead:
-Slower than HashSet, less memory than TreeSet

EnumSet
-
Keys are Enums
- faster and low memory usage

Bitset Implementation
- only a single long if < 64 elements


SortedSet and NavigableSet
-
SortedSet
- defines an order
- no indexes, but subset views possible

        E first();
        E last();
        
        SortedSet tailSet(E from Element);
        SortedSet headSet(E to Element);
        SortedSet subSet(E from ELement, E to Element);
 
NavigableSet
- Extends SortedSet
- Provides ways to move through the order

        E lower(E e)
        E higher(E e);
        
        E floor(E e);
        E cieling(E e);

        E pollFirst();
        E pollLast();
