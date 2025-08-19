# MyList - Generic Dynamic Array Implementation

A custom generic list implementation in Java that provides dynamic array functionality without using Java's built-in Collection classes.

## Features

- **Generic Type Support**: Works with any data type (`Integer`, `String`, `Double`, custom objects, etc.)
- **Dynamic Resizing**: Automatically doubles capacity when needed
- **Memory Efficient**: Starts with default capacity of 10
- **Full CRUD Operations**: Create, Read, Update, Delete operations
- **Array-like Interface**: Familiar methods similar to ArrayList

## Class Structure

```java
public class MyList<T> {
    private T[] array;      // Internal array storage
    private int size;       // Current number of elements
    private int capacity;   // Total array capacity
}
```

## Constructors

- `MyList()` - Creates list with default capacity of 10
- `MyList(int capacity)` - Creates list with specified initial capacity

## Core Methods

| Method | Description |
|--------|-------------|
| `add(T data)` | Adds element to the end of list |
| `get(int index)` | Returns element at specified index |
| `set(int index, T data)` | Replaces element at specified index |
| `remove(int index)` | Removes element and shifts remaining elements left |
| `size()` | Returns number of elements in list |
| `getCapacity()` | Returns total capacity of internal array |

## Utility Methods

| Method | Description |
|--------|-------------|
| `indexOf(T data)` | Returns first index of element (-1 if not found) |
| `lastIndexOf(T data)` | Returns last index of element (-1 if not found) |
| `contains(T data)` | Checks if element exists in list |
| `isEmpty()` | Checks if list is empty |
| `clear()` | Removes all elements and resets to default capacity |
| `toArray()` | Converts list to Object array |
| `subList(int start, int finish)` | Returns new list with elements from start to finish |
| `toString()` | Returns string representation of list |

## Usage Examples

### Basic Operations
```java
MyList<Integer> numbers = new MyList<>();
numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println("Size: " + numbers.size());        // Output: Size: 3
System.out.println("Element at index 1: " + numbers.get(1)); // Output: Element at index 1: 20
System.out.println(numbers.toString());               // Output: [10,20,30]
```

### Different Data Types
```java
MyList<String> names = new MyList<>();
names.add("Alice");
names.add("Bob");

MyList<Double> scores = new MyList<>();
scores.add(85.5);
scores.add(92.0);
```

### Advanced Operations
```java
MyList<Integer> list = new MyList<>();
list.add(10);
list.add(20);
list.add(30);
list.add(20);

System.out.println("First occurrence of 20: " + list.indexOf(20));     // Output: 1
System.out.println("Last occurrence of 20: " + list.lastIndexOf(20));  // Output: 3
System.out.println("Contains 25: " + list.contains(25));               // Output: false

MyList<Integer> subList = list.subList(1, 2);  // Creates [20,30]
```

## Key Features Explained

### Dynamic Resizing
- Starts with capacity of 10
- When full, automatically doubles capacity (10 → 20 → 40 → 80...)
- No manual memory management required

### Type Safety
- Compile-time type checking prevents adding wrong data types
- No casting required when retrieving elements
- Eliminates `ClassCastException` runtime errors

### Null Handling
- Supports `null` values
- Safe comparison methods prevent `NullPointerException`
- Returns `null` for invalid operations (out-of-bounds access)

## File Structure

```
├── MyList.java    # Main generic list implementation
└── Test.java      # Test class demonstrating functionality
```

## Running the Code

```bash
# Compile
javac *.java

# Run tests
java Test
```

## Technical Notes

- Uses `@SuppressWarnings("unchecked")` for safe generic array creation
- Implements left-shift operation for element removal
- Memory efficient with automatic capacity management
- No external dependencies - pure Java implementation
