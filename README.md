# QuizApp API
A RESTful API for managing and conducting quizzes.

# About the Project
The QuizApp API provides backend functionalities for a quiz application, allowing users to create quizzes, fetch questions, and manage scores.

# Features
Start New Quiz Session: Initiate a fresh quiz session for users.<br>
Get Random Questions: Retrieve a random multiple-choice question from the database.<br>
Submit Answer: Submit a user's answer and evaluate correctness.<br>
Track Progress: Retrieve details on the total questions answered, including correct and incorrect submissions.

# Tech Stack
Backend: Java, Spring Boot<br>
Database: H2 Database (In-Memory)<br>
API Testing: Postman<br>
Version Control: Git, GitHub

# Installation
Steps to Run the Project Locally
1. Clone the Repository:
Open your terminal or command prompt and run:
```
git clone https://github.com/AkashChaudhari1/quizapp.git  
cd quizapp
```
2. Build the Project:
Use Maven to build the project:
```
mvn clean install
```
3. Run the Application:
Start the Spring Boot application using:
```
mvn spring-boot:run
```
4. The server will start running at:
```
http://localhost:8080  
```
5.Test the Endpoints:<br>
Use Postman or any API testing tool to interact with the endpoints:<br>
<ul>
<li>Start a new quiz session : http://localhost:8080/api/quiz/start<br></li>
<li><b>(Note: The Id displayed using above endpoint will be used as sessionId. If Id is 1 then following endpoint will look like this "http://localhost:8080/api/quiz/question/1")</b><br></li>
<li>Fetch random questions : http://localhost:8080/api/quiz/question/{sessionId}<br></li>
<li>Submit answers : http://localhost:8080/api/quiz/answer/{sessionId}<br></li>
<li><b>(Note: Using Submit answer end-point requires a request body provide it in raw section as Json as given below. The Value of answerIndex will be the choosen answer which varys between 0 to 3)</b><br>
```
{
"answerIndex" : 1
}
```</li>
<li>Get progress and score : http://localhost:8080/api/quiz/stats/{sessionId}</li>
</ul>





# API Endpoints
<table>
  <tr>
    <td>Endpoint</td>
    <td>Method</td>
    <td>Description</td>
    <td>Example Request Body</td>
  </tr>
  <tr>
    <td>/api/quiz/start</td>
    <td>POST</td>
    <td>Starts new session of quiz</td>
    <td>none</td>
  </tr>
  <tr>
    <td>/api/quiz/question/{sessionId}</td>
    <td>GET</td>
    <td>fetches a question from database</td>
    <td>none</td>
  </tr>
  <tr>
    <td>/api/quiz/answer/{sessionId}</td>
    <td>POST</td>
    <td>gets a answer from user and checks it</td>
    <td>{ "anwserIndex" : your answer as integer}</td>
  </tr>
  <tr>
    <td>/api/quiz/stats/{sessionId}</td>
    <td>GET</td>
    <td>Shows the results</td>
    <td>none</td>
  </tr>
</table>
