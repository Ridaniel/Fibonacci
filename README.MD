# **About the Fibonacci API**

For this REST API, I used Spring due to my familiarity with this framework. Spring is a widely known framework, which facilitates code maintenance. In addition, the quick generation of the project with the basics I need through Spring Initializr is a great advantage.

To build the API, I used Spring Web and Spring Framework. I divided the project into infrastructure and application to keep the program logic separate from what is necessary for the REST API.

To implement the Fibonacci sequence, I used Dynamic Programming to make it as efficient as possible. I also added a cache to avoid having to repeat the process.
And to manage really big numbers , I used the library BigNumber and transform them to String.

### For future improvements, I would consider:

* Adding reactivity to process multiple requests at the same time.
* Incorporating a database as the cache is lost each time the project is restarted. However, the database would have to be fast-access, such as Redis or MongoDB.
* Adding some form of security to ensure only authorized individuals can use the API, such as JWT or OAuth.
* Incorporating documentation, such as OpenAPI, to document the API.
* Adding more unit tests.
* We could also add a test pipeline and a deployment pipelne.
