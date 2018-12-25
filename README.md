# DSS webservices CRUD

CRUD-service implementation in Java.

We call 'CRUD' (Create, Read, Update, Delete) a Web Service (WS) that has to be RESTful and will allow us to keep and manage an object list made up with entities extracted from a free-choice and specific data domain (bibliographic reviews, car catalog, movies critics, etc.). The data model managed by the WS can include images and sounds, which can be included from a Web page through HTTP calls.

-We need to create a data model, as well as a Singleton class that will act as the only "data provider" of the model

-We will use a Java enumeration class for programming a "contents provider" to the client applications (web page) through Internet 

-We will create the resources needed by the service

-Finally, the REST service that we have programmed has to be able to be used by HTML forms.

The Web form will allow doing POST on new data, which are included in the service database: we then need to create a .html page in the folder  "WebContent" of our Eclipse project, which has to be zipped and sent in the due date.   