**Institute Management System**
## Overview

This repository contains a RESTful API for an Institute Management System built using Java and Spring Boot.
## Basic Setup
1. download java 8
2. download STS (Spring Tool Suite)
3. download pgAdmin4
4. Create Database with Name InstituteManagementDB set username :- postgres and password :- postgres
   
## How to Run

1. Clone the repository:
   
git clone https://github.com/Rohinigaudgithub/InstituteManagement.git

If you want to test all the API download Postman and test
In this project I have made 4 API 

1. ## Register Institute
    Endpoint: /InstituteManagement/register
    Method: POST
    ## Request:
    URL: /InstituteManagement/register
    Body:
     {
        "name": "Rohini",
        "location": "D/560 Laxmi Nagar Delhi-93",
        "contactInfo": "rohinigaud2008@gmail.com",
        "website": "www.instituteregistration.com",
        "establishmentyear": 2020
     }
     ## Response
     {
        "id" : 1,
        "name": "Rohini",
        "location": "D/560 Laxmi Nagar Delhi-93",
        "contactInfo": "rohinigaud2008@gmail.com",
        "website": "www.instituteregistration.com",
        "establishmentyear": 2020
     }
   
3. ## Update Institute by Id (In this API you can only able to update institute name, location, and contact information)
    Endpoint: /InstituteManagement/update/{id}
    Method: PUT
    ## Request:
    URL: /InstituteManagement/update/{id}
    Path Variables:
    {id}: The ID of the institute to be updated.
    Body:
     {
        "name": "Rohini",
        "location": "D/560 Laxmi Nagar Delhi-93",
        "contactInfo": "rohinigaud2008@gmail.com",
     }
     ## Response
     {
        "id" : 1,
        "name": "Rohini",
        "location": "D/560 Laxmi Nagar Delhi-93",
        "contactInfo": "rohinigaud2008@gmail.com",
     }
  
5. ## Fetch Institute data by Id
  Endpoint: /InstituteManagement/get/{id}
  Method: GET
  ## Request:
  URL: /InstituteManagement/get/{id}
  Path Variables:
  {id}: The ID of the institute to retrieve.
  ## Response:
  {
        "id" : 1,
        "name": "Rohini",
        "location": "D/560 Laxmi Nagar Delhi-93",
        "contactInfo": "rohinigaud2008@gmail.com",
        "website": "www.instituteregistration.com",
        "establishmentyear": 2020
     }
  
7. ## Get All Institute (I have made this for only test spring security)
  Endpoint: /InstituteManagement/getAllInstitutes
  Method: GET
  ## Request:
  URL: /InstituteManagement/getAllInstitutes
  Response:
  Body: All Institue data json will show 
