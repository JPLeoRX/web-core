# Web-Core
An attempt to implement a generic flow of data between layers of web-application. I aim to reduce the amount of boilerplate code that's needed to build a complex, multi-layered web-app.

Generic implementation of persistence services, business services, APIs and REST APIs will dramatically reduce the amount of copy-paste-rewrite code.

In these implementations 7 basic operations on entities are provided: get by ID, get by property, get all, add, update, remove, remove all.

This approach also provides an automated exception management as well as seamless flow of data between each layer in your application via converter object.