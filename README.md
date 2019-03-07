# Task21

GET samples

http://localhost:8080/users
to get all usernames

http://localhost:8080/user/16
to get a user

http://localhost:8080/character/1
to get a character


http://localhost:8080/class
to get all classes

http://localhost:8080/class/paladin
to get the paladin class info

POST samples

userId and classId must exist in the database to post a character.

There are user IDs starting from 16 to 20.
There are five class IDs from 1-5. 

http://localhost:8080/user
{
  "username" : "ARandomUser",
  "password" : "ARandomPass"
}

http://localhost:8080/character
{
  "name" : "xXCloudXx",
  "level" : "50",
  "userId" : "18",
  "classId" : "4"
}

[alt pic](RPG.png)
