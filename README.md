# StoreManagementTool
StoreManagementTool is an API that acts as a store management tool. This is a Java, maven based project and Spring Boot for web part

Each product has id, code, description, price, dateCreated, lastModified
Api help to create, retrieve, update, delete products.
Api also support custom finder methods such as find by published status or by title.

These are APIs that we need to provide:

Methods	Urls	                            Actions
POST	/api/products	                    create new product
GET	    /api/products	                    retrieve all products
GET	    /api/products/:id	                retrieve a product by :id
PUT	    /api/products/:id	                update a product by :id
DELETE	/api/products/:id	                delete a product by :id
DELETE	/api/products	                    delete all products
GET	    /api/products?description=[keyword]	find all products which description contains keyword

I am using the H2 database which is an in-memory database.