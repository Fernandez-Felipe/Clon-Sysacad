//Descriptions

this microsevice was made for realize all registrations and users logins

//Technologies used

#Java
#Springboot
#SpringData
#SpringSecurity
#JWT for asymmetrict authentication

//Architecture

Made with Hexagonal architecture, this program was thought for be friendly with futures developers who looking for update it. It have Three (3) mains folder:

-aplication
 |-service

-domain
 |-model
 |-port
   |-in
   |-out

-infrastructure
 |-Adapter
 | |-in
 | | |-dtos
 | | |-rest
 | |-out
 | | |-persistance
 | | | |-entity
 | | | |-repository
 | | | |-mapper
 |-Config
 | |-security


//END POINTS

GET: /public-key/jwks.json

  --return the public for needed for futures authetications 

POST: /auth/login

 request:
 {

     "legajo": "32987" // [10000;99999]
     "Password": "123456789"

 }

 response:
 {

     "token": "auth-token" // token claims: legajo, rol. subject: user name

 }

POST: /auth/register

 request:
 {

     "id": "1"
     "nombre": "juan"
     "legajo": "34591"
     "password": "987654321"
     "rol": "user"

 }
 
 response:
 {

     "id": "1"
     "nombre": "juan"
     "legajo": "34591"
     "rol": "user"

 }

//Futures updates

To use /auth/register will be required a "ADMIN" claim