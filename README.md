# jobsweeper-recommendation-engine

A recommendation engines for jobseekers based on tags that represent skills and competences. Each user can be intersted or disintersted in a tag, with an integer representing the degree of interest. Each job has a set of tags that are associated with it. Based on that, each job can have a score for a user that is computed as a sum of tag scores that user is intersted in and a job has. 
The API to recommendation engine is implemented with Spring Boot, the data is stiored in Neo4j graph database and can be queried using Cypher.
