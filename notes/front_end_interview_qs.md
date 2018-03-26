# Front-end interview questions

* How does HTTP and HTTPS work?
    - HTTP - Text based request-response protocol. Client-Server based.
        + It opens a TCP connection
        + It then sends:
        + METHOD HTTP_VERSION RESOURCE_LOCATION
        + REQUEST BODY
        + It receives a RESPONSE HEADER and BODY
        + TCP Connection can be kept open or closed.
    - HTTPS - 3 steps
        + Open a TCP connection with server
        + Certificate exchange - Server sends certificate, encryption algo, digital signature
        + Key exchange - Client encrypts randomly generated key (used for symmteric encryption of data) with public key. Client validates digital signature with its own list of allowed certificates and CAs. It can decrypt the encrypted digital signature using the public key present in browser's CA list(encrypted by CA using its private key) and validates the information is valid.
        + HTTP request/response with encryption
* What is CORS?
    - works by adding new HTTP headers that allow servers to describe the set of origins that are permitted to read that information using a web browser.
    - the specification mandates that browsers "preflight" the request, soliciting supported methods from the server with an HTTP OPTIONS request method, and then, upon "approval" from the server, sending the actual request with the actual HTTP request method. 
* How will you design the webpage?
    - Analyze wirefreames/mockups
    - Divide the HTML logically on a piece of paper
    - Use sprites for better performance.
    - Minify JS and CSS
    - Load JS in the bottom of `index.html`
    - Load CSS at the top of `index.html`
    - Cross browser testing.
* CSS resetting vs CSS normalizing?
    - Resetting removes browser added padding/margins on HTML elements.
    - Normalizing makes sure that HTML elements render the same way in all browsers.
* `display` differences - `inline` vs. `inline-block` vs. `inline`
    - `inline` does not allow `height, width, margin-top, margin-bottom,` but only allows padding (All 4) to an element inside.
    - `inline-block` allows setting `height, width, margins and padding` to an element inside parent element. It does NOT take the full width of the parent element.
    - `block` same as inline-block but takes the full width of the parent element.
* CSS box model?
    - Content --> Padding --> Border --> Margin
* What is a variable in javascript?
* Difference between local and global variable
* What is a function in javascript?
* Difference between `==` and `===`