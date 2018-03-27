# JAVASCRIPT

## APIs
* Browser APIs
    - `DOM APIs` - manipulate HTML, CSS, crea
    - `Geolocation APIs`
    - `Canvas` and `WebGL` - create animated 2D and 3D graphics
    - Audio & Video APIs - `HTMLMediaElement` and `WebRTC` - Allow you to do really interesting things with multimedia, such as play audio and video right in a web page, or grab video from your web camera and display it on someone else's computer (try our simple
* Server side APIs
    - Node

## General
* Javascript uses:
    - Pass by value for primitives
    - Call by sharing for mutable objects ie. arrays, objects. It can mutate an object but CANNOT reassign it.
    - Not pass by reference ie. It does let you assign over the object passed. For eg.
    ```javascript
    var obj = { key: 'val' };

    function modify(val) {
        val = null
    }

    modify(obj);
    console.log(obj) // 'obj' is yet { key: 'val' }
    ```
* The `for...of` statement creates a loop Iterating over iterable objects (including Array, Map, Set, arguments object and so on), invoking a custom iteration hook with statements to be executed for the value of each distinct property. While `for...in` iterates over property names, `for...of` iterates over property values
    ``` javascript
    var arr = [3, 5, 7];
    arr.foo = 'hello';

    for (var i in arr) {
    console.log(i); // logs "0", "1", "2", "foo"
    }

    for (var i of arr) {
    console.log(i); // logs 3, 5, 7
    }
    ```
* `Object.freeze(o)` - Does neither allow to add new properties or modify existing properties.
* `Object.seal(o)` - Does not allow you to add new properties BUT allows modifying existing properties.
* `Object.defineProperty()` - Use this to add new properties to an object with configurations such as writable(read-onlyness)
* Callback functions
    - sdfsdf
* `'use strict';` <TO_BE_COMPLETED>
    - Strict mode applies to entire scripts or to individual functions. It doesn't apply to block statements enclosed in {} brace
    - Strict mode changes both syntax and runtime behavior. Changes generally fall into these categories.
    - *Converting mistakes into errors*
        + prevents automatic `this` coercien
        + makes it safer to use `eval`
        + makes it impossible to accidentally create global variables
        + makes attempts to delete undeletable properties throw for eg. `delete Object.prototype`
        + requires that all properties named in an object literal be unique. This is no longer the case in ECMAScript 2015
        + requires that function parameter names be unique. In normal code the last duplicated argument hides previous identically-named arguments.
        + a strict mode in ECMAScript 5 forbids octal syntax
        + strict mode in ECMAScript 2015 forbids setting properties on primitive values.
* Types of garbage collections
    - Reference counting algorithm (Found in IE 6 and 7)
        + This algorithm reduces the definition of "an object is not needed anymore" to "an object has no other object referencing to it". An object is considered garbage collectible if there is zero reference pointing at this object
        + Cycles are an issue here since cycles have references to each other.
    - Mark and sweep garbage.
        + This algorithm reduces the definition of "an object is not needed anymore" to "an object is unreachable".
        + This algorithm assumes the knowledge of a set of objects called roots (In JavaScript, the root is the global object). Periodically, the garbage-collector will start from these roots, find all objects that are referenced from these roots, then all objects referenced from these, etc. Starting from the roots, the garbage collector will thus find all reachable objects and collect all non-reachable objects.
* [Memory leak patterns in Javascript](https://www.ibm.com/developerworks/web/library/wa-memleak/wa-memleak-pdf.pdf)

## Objects
* Literal vs constructor way of creating it.
* `get` and `set`
* ES2015
    ```javascript
    var obj = {
        foo() {},
        bar() {}
    };
    ```
## Keywords
* `let` - Block scoped
* `const` - Block scoped but values cannot be changed.
    + For objects, The object itself cannot be changed, but its properties can be.
* `var` - Function scoped.
    ```javascript
    // myVarVariable *is* visible out here 

    for (var myVarVariable = 0; myVarVariable < 5; myVarVariable++) { 
        // myVarVariable is visible to the whole function 
    }

    // myVarVariable *is* visible out here
    ```
* `switch` - comparison occurs using the `===` operator

## Types
* `null`
    + `typeof null === 'object'` - This is `true`
    + indicates a deliberate non-value
    + It has only one possible value ie. null.
* `undefined`
    + value of type undefined that indicates an uninitialized value, that is, a value hasn't even been assigned yet
    + `void 0 === undefined` - returns true
* All primitive types are IMMUTABLE (`String`, `Number`, `Boolean`, `null`, `Undefined`, `Symbol`)
* Strings
    - Strings are the common denominator of a lot of APIs (input fields, local storage values, XMLHttpRequest responses when using responseText, etc.)
    - `indexOf` - find if a substring exists
    - `slice` - get a part
    - `replace` - replace part of string
    - `split` - split a string based on a char or regex
* Numbers
    - There is no specific type for integers
    - Has 3 symbolic values: `+Infinity`, `-Infinity`, `NaN`
    - `NaN === NaN` will return `false`
    - Floating point numbers are double precision 64-bit
    - `Number.MAX_VALUE` and `Number.MIN_VALUE`
* Arrays
    - Running a `for...in` loop on an array that does not have elements assigned will return none of the arrays elements. `for...in` not preferred for arrays because `for...in` statement will return the name of your user-defined properties in addition to the numeric indexes. Thus it is better to use a traditional `for` loop with a numeric index when iterating over arrays or Array's `forEach(fn)` method or using `for...of` loop
    - If you supply a non-integer value to the array operator, a property will be created in the object representing the array, instead of an array element.
        ```javascript
        var arr = [];
        arr['some'] = 'thing' // Creates a property on arr
        ```
    - You can also assign to the length property. Writing a value that is shorter than the number of stored items truncates the array;
        ```javascript
        var cats = ['Dusty', 'Misty', 'Twiggy'];
        cats.length = 2;
        console.log(cats); // logs "Dusty, Misty" - Twiggy has been removed
        cats.length = 3;
        console.log(cats); // ['Dusty', 'Misty', undefined]
        ```
    - The function passed to `forEach()` is executed once for every item in the array, with the array item passed as the argument to the function. Unassigned values are not iterated in a `forEach()` loop. Note that the elements of array that are omitted when the array is defined are not listed when iterating by `forEach()`, but are listed when undefined has been manually assigned to the element.
    - Methods
        + `arr1.concat(arr2)` returns new array joining the two
        + `join(delimiter = ',')` joins all elements of an array into a string.
        + `push(elem)`, `pop()` - at the end
        + `unshift(elem)`, `shift(elem)` - at the beginning
        + `slice(i, j)` - returns a new array from `i` to `j-1`
        + `splice(index, count_to_remove, addElement1, addElement2, ...)`
        + `reverse()`
        + `sort(comparatorCallback, thisObj)` optional args
        + `indexOf(searchElement[, fromIndex])` searches the array for searchElement
        + `lastIndexOf(searchElement[, fromIndex])` works like indexOf, but starts at the end and searches backwards.
        + `forEach(callback[, thisObject])` returns undefined.
        + `map(callback[, thisObject])` returns a new array of the return value from executing callback on every array item
        + `filter(callback[, thisObject])` returns a new array containing the items for which callback returned true
        + `every(callback[, thisObject])` returns true if callback returns true for every item in the array.
            ```javascript
            var a1 = [1, 2, 3];
            a1.every((val) => typeof val === 'number'); // logs true
            var a2 = [1, '2', 3];
            a2.every((val) => typeof val === 'number'); // logs false
            ```
        + `some(callback[, thisObject])` returns true if callback returns true for at least one item in the array.
        + `reduce(callback[, initialValue])` applies `callback(firstValue, secondValue)` to reduce the list of items down to a single value and returns that value.
        + `reduceRight(callback[, initialValue])` works like reduce(), but starts with the last element.
        + reduce and reduceRight are the least obvious of the iterative array methods. They should be used for algorithms that combine two values recursively in order to reduce a sequence down to a single value.
    - An array is the return value of `RegExp.exec()`, `String.match()`, and `String.split()`
    - **Array-like objects** (behave like arrays, but do not share all of the methods)
        + `NodeList`
        + `document.getElementsByTagName()`
        + `arguments` - The arguments object available inside the body of a function provides a length attribute but does not implement the forEach() method. This can be resolved by calling Array prototype methods like this
            ```javascript
            Array.prototype.forEach.call(arguments, (val) => { /* do something */ })
            ```
    - Typed Arrays
        + array-like objects and provide a mechanism for accessing raw binary data since there are times when it would be helpful for JavaScript code to be able to quickly and easily manipulate raw binary data in typed arrays. [More details here](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Typed_arrays)
    - Other examples
        ```javascript
        var arr = new Array(42) // Creates an array of length 42
        var arr = Array(42); // Creates an array of length 42
        var arr = Array(9.3); // RangeError

        var arr = [] // Creates an empty array
        var arr = [42] // Creates an array with one number element 42
        ```
* Functions
    - Functions are regular objects with the additional capability of being `callable`.
    - Primitive parameters (such as a number) are passed to functions by value
    - Non-primitive parameters (arrays, user defined objects) are passed as references
    - Function expressions - `var x = function () {}`
    - In Javascript, everything is function scoped. (`let` introduced in ES6 now also allows block scope)
    - A function can refer to and call itself using:
        1. the function's name
        2. `arguments.callee`
        3. an in-scope variable that refers to the function
    - Constructor vs Declaration vs Expression
        ```javascript
        var multiply = new Function('x', 'y', 'return x * y'); // Using constructor
        ```
    - [Closures (aka Nested functions)](https://stackoverflow.com/questions/111102/how-do-javascript-closures-work)
        + JavaScript allows for the nesting of functions and grants the inner function full access to all the variables and functions defined inside the outer function (and all other variables and functions that the outer function has access to).
        + Nested function can "inherit" the arguments and variables of its containing function. In other words, the inner function contains the scope of the outer function.
        + The inner function can use the arguments and variables of the outer function.
        + A closure must preserve the arguments and variables in all scopes it REFERENCES.
        + Since each call to the containing function provides potentially different arguments, a new closure is created for each call to outside containing function.
            ```javascript
            function outside(x) {
                function inside(y) {
                    return x + y;
                }
                return inside;
            }
            fn_inside = outside(3); // Fn that adds 3 to whatever
            result = fn_inside(5); // returns 8

            result1 = outside(3)(5); // returns
            ```
        + This is not different from storing references in other objects, but is often less obvious because one does not set the references directly and cannot inspect them.
        + The closures can contain multiple scopes; they recursively contain the scope of the functions containing it. This is called **scope chaining**.
        + When there is a name conflict, inner scopes take precedence; so the inner-most scope takes the highest precedence, while the outer-most scope takes the lowest. This is the **scope chain**. The first on the chain is the inner-most scope, and the last is the outer-most scope.
        + A closure is created when the inner function is somehow made available to any scope outside the outer function. Look at this example
        ```javascript
        var pet = function(name) {   // The outer function defines a variable called "name"
            var getName = function() {
                return name;             // The inner function has access to the "name" variable of the outer 
                                        //function
            }
            return getName;            // Return the inner function, thereby exposing it to outer scopes
        }
        myPet = pet('Vivie');
        
        myPet();   
        ```
        + The inner variables of the inner functions act as safe stores for the outer arguments and variables. They hold "persistent" and "encapsulated" data for the inner functions to work with. The functions do not even have to be assigned to a variable, or have a name.
        ```javascript
        var getCode = (function() {
            var apiCode = '0]Eal(eh&2';    // A code we do not want outsiders to be able to modify...
            
            return function() {
                return apiCode;
            };
        }());

        getCode();    // Returns the apiCode
        ```
        + Other uses
            - Emulating private methods with closures
        + Pitfalls
            - Creating closures in loops: A common mistake
            - If an enclosed function defines a variable with the same name as the name of a variable in the outer scope, there is no way to refer to the variable in the outer scope again.
            ```javascript
            var createPet = function(name) {  // The outer function defines a variable called "name".
                return {
                    setName: function(name) {    // The enclosed function also defines a variable called "name".
                    name = name;               // How do we access the "name" defined by the outer function?
                    }
                }
            }
            ```
    - The `arugments` object
        + The arguments variable is "array-like", but not an array. It is array-like in that it has a numbered index and a length property. However, it does not possess all of the array-manipulation methods.
            - `arguments`: An array-like object containing the arguments passed to the currently executing function.
            - `arguments.callee` : The currently executing function.
            - `arguments.caller` : The function that invoked the currently executing function.
            - `arguments.length`: The number of arguments passed to the function.
    - Function parameters
        + Default parametes (ES2015)
        ```javascript
        function multiply(a, b = 1) {
            return a * b;
        }

        multiply(5); // 5
        ```
        + Rest parameters (ES2015)
        ```javascript
        function multiply(multiplier, ...theArgs) {
            return theArgs.map(x => multiplier * x);
        }

        var arr = multiply(2, 1, 2, 3);
        console.log(arr); // [2, 4, 6]
        ```
        + Arrow functions
            - Lexically binds the `this` value.
            - Arrow functions are always anonymous.
            - Until arrow functions, every new function defined its own `this` value
                * a new object in case of a constructor
                * `undefined` in strict mode function calls
                * the context object if the function is called as an "object method", etc.
            - In ES3/5, this was fixed by assigning the value in `this` to a variable that could be closed over.
            ```javascript
            function Person() {
            var self = this; // Some choose `that` instead of `self`. 
                            // Choose one and be consistent.
                self.age = 0;

                setInterval(function growUp() {
                    // The callback refers to the `self` variable of which
                    // the value is the expected object.
                    self.age++;
                }, 1000);
            }
            ```
            - Pitfalls
                * Use non-arrow functions for methods that will be called using the `object.method()` syntax. Those are the functions that will receive a meaningful this value from their caller.
                * Use arrow functions for everything else.
## Operators
- `==` vs `===`
    + Javascript automatically does type coercien with `==`
        ```javascript
        123 == '123' // true
        123 === '123' // false
        ```
    + Use `===` if you wish to also check for types
    + `false, 0, "", NaN, null`, and `undefined` all become false.
- `**` Power operator 
- `-` Negation
- `+` attempts to convert operand to number
- Destructuring
```javascript
    var foo = ['one', 'two', 'three'];

    // without destructuring
    var one   = foo[0];
    var two   = foo[1];
    var three = foo[2];

    // with destructuring
    var [one, two, three] = foo;
```
- Rest vs Spread
    + Rest - When using rest arguments, you are collapsing all remaining arguments of a function into one array. represent an indefinite number of arguments as an array (real array not array-like)
    + Spread - When using spread, you are expanding a single variable into more
- `delete` operator deletes an object, an object's property, or an element at a specified index in an array.
    * You can use the `delete` operator to delete variables declared implicitly but not those declared with the `var` statement.
    * When you delete an array element, **the array length is not affected**.
- `typeof`
    * All constructor functions while instantiated with `new` keyword will always be typeof `object` for eg. `new String('sdf')`
    * But there is a exception in case of Function constructor of Javascript
        ```javascript
        var func = new Function();

        typeof func; // It will return 'function'
        ```
    * `class` and `function` have `typeof === 'function'`

## [Events](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Building_blocks/Events)
    
- Can be handled in 2 ways:
    + DOM object's event handler properties ie. `.onclick`, `.ondblclick`, etc.. 
        - less options
        - cannot remove handlers
        - has wider cross browser support
    + Using `addEventListener()` and `removeEventListener()`
        - more powerful
        - can add multiple listeners to the same element
        - can remove listeners
        - only supported back upto IE 9
- Get the DOM object - Add handler fn to the event property for eg.
    ```javascript
    var btn = document.querySelector('button');

    function bgChange() {
        var rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
        document.body.style.backgroundColor = rndCol;
    }

    btn.onclick = bgChange;
    ```
- Dont use inline handlers inside the HTML. For eg.
    ```html
    <button onclick="bgChange()">Press me</button>
    ```
    They are considered bad practice. It might seem easy to use an event handler attribute if you are just doing something really quick, but they very quickly become unmanageable and inefficient. For a start, it is not a good idea to mix up your HTML and your JavaScript
- New [DOM Level 2](https://www.w3.org/TR/DOM-Level-2-Events/) Events API:
    + `addEventListener(event, handlerFn)`
    + `removeEventListener(event, handlerFn)`
    + This mechanism has some advantages over the older mechanisms ie. `DOMObject.onclick(handlerFn)` etc. discussed earlier. For a start, there is a counterpart function, removeEventListener(), which removes a previously added listener. 
    + Second, you can also register multiple handlers for the same listener. Both functions would now run when the element is clicked.
        ```javascript
        myElement.addEventListener('click', functionA);
        myElement.addEventListener('click', functionB);
        ```
- The event object
    + Sometimes inside an event handler function, you might see a parameter specified with a name such as event, evt, or simply e
    + It is automatically passed to event handlers to provide extra features and information
    + The `target` property of the `event` object is always a reference to the element that the event has just occurred upon
    + Sometimes, you'll come across a situation where you want to stop an event doing what it does by default. Use `e.preventDefault()` for this.
    + Event bubbling and capture.
        - When an event is fired on an element that has parent elements (e.g. the `<video>` in our case), modern browsers run two different phases — the capturing phase and the bubbling phase. In the capturing phase:
            + The browser checks to see if the element's outer-most ancestor (`<html>`) has an onclick event handler registered on it in the capturing phase, and runs it if so.
            + Then it moves on to the next element inside `<html>` and does the same thing, then the next one, and so on until it reaches the element that was actually clicked on.
        - In the bubbling phase, the exact opposite occurs:
            + The browser checks to see if the element that was actually clicked on has an onclick event handler registered on it in the bubbling phase, and runs it if so.
            + Then it moves on to the next immediate ancestor element and does the same thing, then the next one, and so on until it reaches the `<html>` element.
        - By default, events are in bubbling phase. It can be set to capturing phase by setting last argument of `addEventListener()` to `true`
    + Stopping the bubbling using `e.stopPropagation()`
    + Event delegation.
        - Delegate event handling to any one of the ancestors instead of the current element. For eg, can be used when we have a large number of `<li>` that handler a click event 
            + 
    + See also:
        - [Event order](http://www.quirksmode.org/js/events_order.html) (discussion of capturing and bubbling) — an excellently detailed piece by Peter-Paul Koch.
        - [Event accessing](http://www.quirksmode.org/js/events_access.html) (discussion of the event object) — another excellently detailed piece by Peter-Paul Koch.
        - [Event reference](https://developer.mozilla.org/en-US/docs/Web/Events)

## Objects
* Creation
    - Using object literals
    - Using constructor function
    - Using the `Object()` constructor
    - Using the `Object.create()` method
* Prototypes
    - Mechanism by which JavaScript objects inherit features from one another.
    - Prototype
        + **Prototype chain** - Each object has a prototype object, which acts as a template object that it inherits methods and properties from. An object's prototype object may also have a prototype object, which it inherits methods and properties from, and so on.
        + `prototype` property can be used to add methods to existing constructors
        + The properties and methods are defined on the `prototype` property on the Objects' constructor functions, NOT the object instances themselves.
        + Object instances have `__proto__` object which is derived from the `prototype` property on the constructor
        +  **It's important to understand that there is a distinction between an object's `prototype` (which is available via `Object.getPrototypeOf(obj)`, or via the deprecated `__proto__` property) and the `prototype` property on constructor functions. The former is the property on each instance, and the latter is the property on the constructor. That is, `Object.getPrototypeOf(new Foobar()) `refers to the same object as `Foobar.prototype`*
    - `Object.create(obj)` attaches obj as the prototype of the new object.
    - The `constructor` property
        + constructor function has a prototype property
        + The prototype of a constructor has a `constructor` property
        + This constructor property points to the original constructor function.
        +  available to all the instance objects created using the original constructor function.
        + A clever trick is that you can put parentheses onto the end of the constructor property (containing any required parameters) to create another object instance from that constructor.
            ```javascript
            function Person(name) {
                this.name = name;
            }

            let x = new Person('ABC') // Creates a new Person object
            let y = new x.constructor('DEF') // Also creates a new Person object
            ```
    - Modifying prototypes
        + Adding methods to prototype
        + Common practice is to add properties to the constructor function and methods to the prototype
            ```javascript
            function Person(name) {
                this.name = name;
            }
            
            Person.prototype.sayHello = function() {
                alert('My name is ' + this.name);
            }
            ```
* Prototypal Inheritance
    - Different ways to create objects and the resulting prototype chain
        1. Objects created with syntax constructs (literals, arrays, functions)
        2. With a constructor - A "constructor" in JavaScript is "just" a function that happens to be called with the `new` operator.
        3. With `Object.create` - Calling this method creates a new object. The prototype of this object is the first argument of the function
        4. With the `class` keyword
    - Performance
        + The lookup time for properties that are high up on the prototype chain can have a negative impact on the performance.
        + Additionally, trying to access nonexistent properties will always traverse the full prototype chain
    - To check whether an object has a property defined on itself and not somewhere on its prototype chain, it is necessary to use the `hasOwnProperty` method. *Note: It is not enough to check whether a property is undefined. The property might very well exist, but its value just happens to be set to undefined.*
    - `prototype and Object.getPrototypeOf`
        + Functions have a special property called prototype. This special property works with the JavaScript `new` operator. The reference to the prototype object is copied to the internal [[Prototype]] property of the new instance.
        + For example, when you do `var a1 = new A()`, JavaScript (after creating the object in memory and before running function `A()` with this defined to it) sets `a1.[[Prototype]] = A.prototype`. When you then access properties of the instance, JavaScript first checks whether they exist on that object directly, and if not, it looks in `[[Prototype]]`.
        + This means that all the stuff you define in `prototype` is effectively shared by all instances, and you can even later change parts of `prototype` and have the changes appear in all existing instances, if you wanted to.
        + In short, `prototype` is for types/classes, while `Object.getPrototypeOf()` is the same for instances.
    - Steps to create a `ChildClass` from a `SuperClass` and Setting `ChildClass`' `prototype` and constructor reference
        1. Call the super class' constructor function from the `ChildClass`' constructor function using `call(this, ...)`. This allows us to pass the current `this` object to put `SuperClass` properties on.
        2. Set properties/methods to `ChildClass`' prototype (if any)
        3. Set the `SuperClass`' prototype as the `ChildClass`' prototype's prototype.
        4. Set the `ChildClass.constructor` to the `ChildClass` function itself. eg. 
        ```javascript
        // Super class
        function Person(first, last, age, gender, interests) {
            this.name = {
                first, // A short hand for first: first
                last
            };
        }

        // Super class prototype methods.
        Person.prototype.greeting = function() {
            alert('Hi! I\'m ' + this.name.first + '.');
        };

        // Child class
        function Teacher(first, last, age, gender, interests, subject) {
            // Step 1
            Person.call(this, first, last, age, gender, interests);

            this.subject = subject;
        }

        // Step 2
        Teacher.prototype.welcomeStudents = function () {
            alert('Hello Students, my name is ' + this.name.first + ' ' + this.name.last)
        }

        // Step 3
        subClass.prototype = Object.create(parentClass.prototype);
        
        // Step 4
        subClass.prototype.constructor = subClass
        ```
    - Inheriting from a constructor with no parameters - `call(this)` inside constructor function of the subclass.
    - sharing of functionality between objects is often called *delegation*



## Important functions:
* `func.bind(thisArg, args)`
    - Creating a bound function
        ```javascript
        fn.bind(this)
        ```
    - Partially applied functions. The next simplest use of bind() is to make a function with pre-specified initial arguments.
        ```javascript
        function list() {
            return Array.prototype.slice.call(arguments);
        }

        var list1 = list(1, 2, 3); // [1, 2, 3]

        // Create a function with a preset leading argument
        var leadingThirtysevenList = list.bind(null, 37);

        var list2 = leadingThirtysevenList(); 
        // [37]

        var list3 = leadingThirtysevenList(1, 2, 3);
        // [37, 1, 2, 3]
        ```
    - With `setTimeout` - you may explicitly bind this to the callback function
    - Bound functions used as constructors
        ```javascript
        function Point(x, y) {
            this.x = x;
            this.y = y;
        }
        var YAxisPoint = Point.bind(emptyObj, 0/*x*/);
        var axisPoint = new YAxisPoint(5);
        axisPoint.toString(); // '0,5'
        ```
    - Creating shortcuts
        ```javascript
        var slice = Array.prototype.slice;

        // ...

        slice.apply(arguments);
        ```
        ```javascript
        // same as "slice" in the previous example
        var unboundSlice = Array.prototype.slice;
        var slice = Function.prototype.apply.bind(unboundSlice);

        // ...

        slice(arguments);
        ```
* `func.apply(thisArg, [argsArray])`
    - You can assign a different `this` object when calling an existing function. `this` refers to the current object, the calling object.
    - With `apply`, you can write a method once and then inherit it in another object, without having to rewrite the method for the new object.
    - `apply` is very similar to `call()`, except for the type of arguments it supports. You use an arguments array instead of a list of arguments (parameters)
    - Since ECMAScript 5th Edition you can also use any kind of object which is array-like, so in practice this means it's going to have a property length and integer properties in the range (0..length-1)
    - Using apply to chain constructors
    - **Using apply and built-in functions**
        ```javascript
        Math.max.apply(null, numbers); 
        ```
    - If your value array might grow into the tens of thousands (since Javascript argument list is limited to 65536, use a hybrid strategy: apply your function to chunks of the array at a time:
    ```javascript
    function minOfArray(arr) {
        var min = Infinity;
        var QUANTUM = 32768;

        for (var i = 0, len = arr.length; i < len; i += QUANTUM) {
            var submin = Math.min.apply(null, 
                                        arr.slice(i, Math.min(i+QUANTUM, len)));
            min = Math.min(submin, min);
        }

        return min;
    }

    var min = minOfArray([5, 6, 2, 3, 7]);
    ```
* `function.call(thisArg, arg1, arg2, ...)`
    - Using call to chain constructors for an object
        ```javascript
        function Product(name, price) {
            this.name = name;
            this.price = price;
        }

        function Food(name, price) {
            Product.call(this, name, price);
            this.category = 'food';
        }

        function Toy(name, price) {
            Product.call(this, name, price);
            this.category = 'toy';
        }

        var cheese = new Food('feta', 5);
        var fun = new Toy('robot', 40);
        ```
    - Using call to invoke an anonymous function
    - Using call to invoke a function and specifying the context for 'this'
    - Using call to invoke a function and without specifying the first argument
        ```javascript
        var sData = 'Wisen';
                
        function display(){
            console.log('sData value is %s ', this.sData);
        }

        display.call();  // sData value is Wisen 
        ```

## Promises

## Observables
* 

## [ES6 in Depth](https://hacks.mozilla.org/category/es6-in-depth/)
* Arrow functions
    - Lexically binds the `this` value.
    - There is one subtle difference in behavior between ordinary function functions and arrow functions. **Arrow functions do not have their own this value**. The value of `this` inside an arrow function is always inherited from the enclosing scope.
    - Arrow functions are always anonymous.
    - Arrow functions don’t get their own `arguments` object. Use Rest parameters.
    - Note that an arrow function with a block body does not automatically return a value. Use a return statement for that.
    - There is one caveat when using arrow functions to create plain objects. Always wrap the object in parentheses:
        ```javascript
        // create a new empty object for each puppy to play with
        var chewToys = puppies.map(puppy => {});   // BUG! an empty block doing nothing & returns undefined
        var chewToys = puppies.map(puppy => ({})); // ok
        ```
    - In ES6, `this` hacks (using `self`, `that`, etc.) mostly go away if you follow these rules:
        + Use non-arrow functions for methods that will be called using the `object.method()` syntax. Those are the functions that will receive a meaningful `this` value from their caller.
        + Use arrow functions for everything else.
    - As a bonus, ES6 also provides a shorter way to write methods in object literals! So the code above can be simplified further
    ```javascript
    {
    ...
    addAll(pieces) {
        _.each(pieces, piece => this.add(piece));
    },
    ...
    }
    ```
* `Maps` and `Sets`
* Classes
    - Hoisting - An important difference between function declarations and class declarations is that function declarations are hoisted and class declarations are not. You first need to declare your class and then access it, otherwise code like the following will throw a ReferenceError
    - The bodies of class declarations and class expressions are executed in strict mode
    - A constructor can use the super keyword to call the constructor of the super clas
    - A class expression is another way to define a class. Class expressions can be named or unnamed.
        ```javascript
        var Rectangle = class {
            constructor(height, width) {
                this.height = height;
                this.width = width;
            }
        };
        ```

## Resources
* [Front-end interview handbook](https://github.com/yangshun/front-end-interview-handbook)
* [JS trends 2018](https://medium.com/javascript-scene/top-javascript-libraries-tech-to-learn-in-2018-c38028e028e6)
* [Javascript conceptually](https://medium.com/@_ericelliott)