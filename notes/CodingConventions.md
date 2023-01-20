# Coding Conventions
## Resources
1. [Official Kotlin Conventions](https://kotlinlang.org/docs/coding-conventions.html)


### Directory Structure
- `org.example.kotlin` under root directory
- `org.example.kotlin.a.b` in `a/b` folder
### Source Files
- use `.kt` extension
- camel Case starting with Caps
### Class Layout
1. property declarations and init blocks
2. secondary constructors
3. method declarations
4. companion object
### Nameing rules
- package names in camel case `org.example.kotlin.myProject`
- classes and Objects camel case starting with caps `CustomClass` or `CustomObject`
- function names camel case no underscore `customFunction`
- tests can use method names with spaces `@Test fun 'method name' () {...}`
- constants all caps with underscore `MAX_COUNT`
- variabls are camel case `thisVariable`
- references use camel case starting with caps `ObjectReference: Comperator<Object>`
- prefixed `_` can be used to differentiate public and private variables with the same name but different functionality
### Colon
- Space before colon `:` when:
  - seperating type and supertype
  - after an object
  - delegating to constructor
- Always put a space after `:`
### Arguments
- less than 3 params can stay on same line
- 3 or more should be split to their own line
### Modifiers
- In the following order
  ```
  public / protected / private / internal
  expect / actual
  final / open / abstract / sealed / const
  external
  override
  lateinit
  tailrec
  vararg
  suspend
  inner
  enum / annotation / fun // as a modifier in `fun interface`
  companion
  inline / value
  infix
  operator
  data
  ```
### Functions
- prefer expression body for single expressions
  - good `fun foo() = 1`
  - bad `fun foo() { return 1 }`
  - use named arguments when calling a function if they have the same type
### Infix Function
- declare infix only when 2 objects play similar role
- do not declare infix if it mutates the receiver
### Factory Functions
- don't give factory functions the same name of the class
  ```
  class Foo {
    companion objcet {
        fun Foo() {...} // Bad
        fun buildFoo() {...} // Good
    }
  }
  ```
### Scope Functions
- provide for functions to execut blocks `let`, `run`, `with`, `apply`, and `also`
- [see](https://kotlinlang.org/docs/scope-functions.html) 
### Trailing Commas
- yes
### Semicolons
- no
### Immutability
- `val` over `var` if not changed after initialized
- immutable collection interfaces when not mutated
### Type Aliases
- use when functional type or type with type parameters that is used multiple times:
  - `typealias MouseClickHandler = (Any, MouseEvent) -> Unit`
  - `typealias PersonIndex = Map<String, Person>`
### Conditionals
- use `when()` over `if()` with more than 2 conditions
- prefer expression form
  - `return if (x) foo() else bar()`
### Loops
- use `until` when looping on open ranges `for (i in 0 until n) { /*...*/ }` not `for (i in 0..n - 1) { /*...*/ }`