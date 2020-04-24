# Library Management

Library Management is a WEB application which deals with some library operations like Keeping an eye on Book Stock , Provide book to users and get back from users.

## Architectural Thoughts

Before I define the Pre requisites , I want to brief the architecture which I kept in my mind before preparing it. 
As per my expecrience I followed 
```
Service Oriented Architecture i.e. SOA

```
Where I kept focus on 

```
PARALLEL DEVELOPMENT , TEAM COLLABORATION , PAIR PROGRAMMING

```

for UI/UX as well as Backend development by using

```
SWAGGER CONTRACTS

```

SOA described in a way where each layer does have their own responsbility. Please see through below.


```
REST LAYER [RESPONSIBLE FOR UI/UX INTERACTION] <---> SERVICE LAYER [RESPONSIBLE FOR BUSINESS LOGIC , AND PASS THROUGH DATA TO DAO LAYER] <--> DAO LAYER [RESPONSIBLE FOR DATA BASE OPERATIONS]

```

AS UI is not made for this I request to deploy this and test it via POST MAN or Advanced REST Client.

## DATABASE DESIGN

Library Management is a API based approch where we have to keep track for users data along with books.

As per the design please find below table approach kept in Database.

```
Users > This table responsible for storing Users data like 
		Full name of user , 
		Email ID , 
		Phone no , 
		User ID [PK , which is an Auto Generated No]

```

```
Book > 	This table responsible for storing books data like 
		Book name , 
		Author name , 
		ISBN No [A unique no for books] , 
		Book ID [PK , which is an Auto Generated No],
		No of Copies [No of copies present in Library]

```

```
User_Book > This table in designed in such a way which keep records of many to many relationship between Users and Book 
			so that this could be tracked which book are assigned to which user and viceversa.

```


## Assumptions


While designing Library Management WEB Application I tried to satisfy the scenarios given in Assignment PDF which are briefed below.

	* USER are not permitted to borrow more than 2 Books
	* USER are not permitted to keep the same book twice
	* If a book is already assigned to user and if User again tries to borrow the same book , Application won't permit
	* If borrow successfully happen after passing all the criteria , Application decrease the no of copies by 1
	* If return successfully happen, Application increases the no of copies in book by 1
	

### Prerequisites

For using application , seek below softwares to be available in system

```
JAVA [>=1.8]
MAVEN 3
APACHE TOMCAT [>=8]
REST CLIENT [IF CURL DOESN'T WORK]
INTERNET BROWSER [FOR SEEING SWAGGER CONTRACT]
MYSQL
Eclipse [for code walkthrough]

```

Import Library management schema [available in ../resources/library_mgmt.sql] in mysql

```
mysql > source library_mgmt.sql;

```

User can see Swagger API Docs over internet [https://editor.swagger.io/] by importing/coping Swagger contract [available in ../resources/library_management.yaml]

### Installing

Please see through below steps for system to be up and running

Create the build by changing the directory to library management folder using below command 

```
mvn clean install
```

## Deployment

Once build successfull , copy  generated .war file in tomcat using below command 

```
cp target/libraryMgmt.war /{tomcatpath}/webapps
```

Start the tomcat

```
{tomcatpath}/bin > sh catalina.sh run

```

Please to try access below URL once tomcat is up and running on given port.

```
http://localhost:{givenport}

```

Or use below URL for accessing Users data :

```
http://localhost:{givenport}/libraryMgmt/users

```

## Built With

* [Swagger](https://editor.swagger.io/) - API docs
* [Spring](https://docs.spring.io/spring/) - The web framework used
* [jaxrs](http://cxf.apache.org/docs/jax-rs.html) - The Rest Apis framework
* [Hibernate](https://hibernate.org/orm/documentation/5.4/) - The DB framework used
* [Maven](https://maven.apache.org/) - Dependency Management

## Author

* **Pushpank Tugnawat** - (https://in.linkedin.com/in/pushpank-tugnawat-a8a24370)


