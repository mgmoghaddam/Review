
# Review Test Application

An example Application to show the relations between Providers, Products, Users and reviews.

## API Reference for User

#### Create User

```http
  POST /api/v1.0/user/
```

#### Input parameters "UserDto"
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `fullName` | `string` in json body | **Required**. full name of user. |
| `phoneNumber` | `string` in json body | **Required**. phone number of user. |

.................................................................................................
#### Get User by Id

```http
  GET /api/v1.0/user/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` in path parameters | **Required**. Id of User to fetch |


.................................................................................................

#### Update User

```http
  PUT /api/v1.0/user/
```

#### Input parameters "UserDto"
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `fullName` | `string` in json body | **Required**. full name of user. |
| `phoneNumber` | `string` in json body | **Required**. phone number of user. |

.................................................................................................

#### Delete User

```http
  Delete /api/v1.0/user/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` path parameters | **Required**. Id of User to Delete |


==========================================================================


## API Reference for Comment

#### Add Comment

```http
  POST /api/v1.0/comment/
```

#### Input parameters "CommentDto"
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `presentable` | `Boolean` in json body | **Required**. to know if comment showable or not. |
| `comment` | `String` in json body | **Required**. the text of comment. |
| `score` | `Long` in json body | the score to product . |
| `score` | `Long` in json body | the score to product . |

#### Query parameters
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `Long` query parameter | the user Id . |
| `productId` | `Long` query parameter | the product Id . |

.................................................................................................
#### Get Comment by Id

```http
  GET /api/v1.0/comment/${commentId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `commentId` | `String` in path parameters | **Required**. Id of Comment to fetch |


.................................................................................................

#### Update Comment

```http
  PUT /api/v1.0/comment/
```

#### Input parameters "CommentDto"
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` in json body |**Required**. the id of comment . |
| `presentable` | `Boolean` in json body | to know if comment showable or not. |
| `comment` | `String` in json body |  the text of comment. |
| `score` | `Long` in json body | the score to product . |
| `score` | `Long` in json body | the score to product . |

.................................................................................................

#### Delete Comment

```http
  Delete /api/v1.0/comment/${commentId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` path parameters | **Required**. Id of comment to Delete |


.................................................................................................

## Run Locally

Clone the project

```bash
  git clone https://github.com/mgmoghaddam/review.git
```

Open it with IntellijIdea

Create databse

```bash
  CREATE DATABASE review;
```
**Then you can run application and see the tables and relations.**
**even can use Postman collection to call webservices.**

## Running Tests

**To run tests, we have two classes**

- **UserControllerIntegrationTest**
- **CommentControllerIntegrationTest**

**You can test user logic and comment logic working with above classes**

# Hey, I'm Mosatafa! 👋


## 🚀 About Me
I'm a Java and Kotlin developer.
Always Trying to be better.

## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/mganjianm/)


## 🛠 Skills
Java, Kotlin, Spring FrameworkSpring, Docker, Elasticsearch, Oracle, Mysql, Apache Kafka, RabbitMQ, **Infrastructure**


