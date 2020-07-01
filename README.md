# RandomNumberObserver
Java service that observes for Random numbers and returns the cumulated data

# API Deftinitions : 
1. @GET /getCumulation : Accepts  a query parameter, Delta which represent the time(in minutes) upto which we want our cumulated Data. This api would return the cumulated data of all the numbers seen in the last "delta" minutes.
2. @GET /getOverallCumulation : Returns the cumulated data of numbers seen in last 5, 15 and 30 minutes.

Assumptions : 
Cumulation of data could possibly mean any business logic we want to run on top of our data.
i have assumed, we want the data collecfted in list and have calculated the sum and average aggregate for the numbers in the given window.


# How to run the application ? 
Its a Spring boot application and the main class is RandomNumberObserverApplication.java
This class can be used to run as a spring boot app. or alternatively we can run it from command line. using the below command <br />
### mvn spring-boot:run 

## Sample request and output : 

#####Request -> curl http://localhost:8080/getCumulation?delta=5  <br /> 

Response -> {
   "cumulation":[[
         68,
         92,
         58,
         81,
         10
      ]],
   "message":"Aggregation of Numbers emitted in last 1 minutes : \n  1)Sum = 7473\n 2) Average = 14"
} <br /> 


#####Request -> curl http://localhost:8080/getOverallCumulation  <br /> 






