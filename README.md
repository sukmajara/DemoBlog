# Demo Blog
this is a API to get, create, update, delete blog using spring boot with JWT Security.

## Installation
```bash
git clone <URL GIT> <repository>
```
*make sure you clone in right directory*

make sure you have this requirement running in your system:
- java version "1.8.0_251"
- PostgreSQL 14.3

in Spring Tool Suite 4 :
 - Import -> Existing Maven Project 
 - Choose folder from folder you just cloned
 - Update Project to make sure all pom.xml imported
 - Run as Spring Boot App

the app default running on port 8081 for the api and PostgreSQL on 5432

username and password for admin :\
username : admin\
password : admin

please input the JWT token in Header -> Authorization 
example :
Bearer {JWT Token}

## Roles
Admin permission :
- Get
- Create
- Update
- Delete

User permission :
- Get

## Usage
this is the endpoint for the servive
- Register User 	[POST] 	:localhost:8081/auth/register\
Request:
```json
  {
    "username" : "user",
    "password" : "password"
  }
```
- Login User		[POST] 	:localhost:8081/auth/login\
Request login as admin:
```json
  {
    "username":"admin",
    "password":"admin"
  }
```
Request login as user:
```json
  {
    "username" : "user",
    "password" : "password"
  }
```

- Get All Blog 		[GET]	: localhost:8081/blog/user/get-all/{page}/{limitItem}
- Get Detail Blog 	[GET]	: localhost:8081/blog/user/get-detail/{blogId}

- Create Blog 		[POST]	: localhost:8081/blog/admin/create\
  Request:
```json
  {
    "title":"Movie 1",
    "rating":"1",
    "desc":"desc 1"
  } 
```

- Update Blog		[PATCH]	: localhost:8081/blog/admin/update
    Request:
```json
  {
    "title":"1",
    "rating":"0.1",
    "desc":"edit 1"
  }
```
- Delete Blog 		[DELETE]: localhost:8081/blog/admin/delete
    Request:
```json
{
    "id":"3"
}
```
*make adjusment in application.properties if needed*
