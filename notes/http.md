## HTTP and the Internet

## DNS resolution
* Recursive DNS resolver (OS -> Resolving --> Root --> ANS)
* Types of servers
	1. Resolving Name Server (provided by ISP)
		* Directly finds out information about the root servers, top level domains and authoritative name servers.
	2. Root name Server *(com, org, io, etc..)*
	3. Authoritative Name Server
		* Nam server that holds the actual DNS records.
		
* DNS propogation of updates a.k.a refreshes

## HTTP - application level protocol
* text based
* Initial communication
	* Send - Method, Headers, URI with protocol version
	* Receive - Response code, Headers
* Second communication
	* Receive data packets
* Methods
	* `OPTIONS`
	* `GET` - Transfer a current representation of the target resource.
	* `HEAD` - Same as GET, but only transfer the status line and header section.
	* `POST`
	* `PUT`
	* `DELETE`
	* `TRACE`
	* `CONNECT`
* Status codes (summary of families)
	-  `1xx`  (Informational): Request received, continuing process.
	-   `2xx`  (Successful): The action was successfully received, understood, and accepted.
	-   `3xx`  (Redirection): Further action needs to be taken in order to complete the request.
	-   `4xx`  (Client Error): The request contains bad syntax or cannot be fulfilled.
	-   `5xx`  (Server Error): The server failed to fulfil an apparently valid request.
* HTTP status codes have consequences on caching, and handling of URIs on the client side.
* Status codes (in detail)
	* `200 OK`
	* `201 Accepted`
	* `301 Moved Permanently`
	* `307 Temporary Redirect`
	* `410 Gone` - Dont remember this URI
	* `500 Internal Server Error`
	* 
* CDN - Content Data Network
* DDoS prevention using Akamai
* 
* Component files
	* Code files - HTML, CSS, JS
	* Assets - Images, Music, Video etc
* CDN for deliverying Assets and code files
