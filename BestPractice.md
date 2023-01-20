# Best Practice
## Resources
- [Unity-Technology Guid](https://unity-technologies.github.io/kotlin-guide/)
- [Kotlin Require Block](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html)
- [Kotlin Check Block](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/check.html)
- [Sealed Classes](https://phauer.com/2019/sealed-classes-exceptions-kotlin/)
- [Sequence Chaining](https://blog.kotlin-academy.com/effective-kotlin-use-sequence-for-bigger-collections-with-more-than-one-processing-step-649a15bb4bf)
- [Logging](https://github.com/MicroUtils/kotlin-logging)


### Readability
- keep in mind concise doesn't mean readable
### Safety
- imutability and null safety!
### Parameter and State Validation
- use 'require block' for validating parameter values
  - [see](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/require.html)
- use 'check block' for state validation
  - [see](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/check.html)
### Data Classes
-all parameters from the primary constructor will be declared as properties
- `equals()`, `hashcode()`, `copy()`, `toString()` (and componentN() (for destructuring)) functions will be generated
- example: data class User(val name: String, var age: Int) is a complete data class implementation
### Companion Objects
- these should replace all static variables and functions
- use to define factorys and serialization functions related to data class
### Return Values
- avoid returning null prefer throwing exceptions
  - Sealed classes are a better alternative to exceptions [Sealed Classes](https://phauer.com/2019/sealed-classes-exceptions-kotlin/)
- prefer immutable
- prefer custom objects over `Pair` and `Triple`
### Chaining
- collections have stream and collect integration by default
- when chaining a non-trivial number methods in a collection, declare as a sequence
  - [see](https://blog.kotlin-academy.com/effective-kotlin-use-sequence-for-bigger-collections-with-more-than-one-processing-step-649a15bb4bf)
### Logging
- [see](https://github.com/MicroUtils/kotlin-logging)
