package se.openhack.jobsweeper.recommendation.database;

import org.neo4j.driver.v1.*;
import se.openhack.jobsweeper.recommendation.entities.JobRecommendation;
import se.openhack.jobsweeper.recommendation.entities.Tag;
import se.openhack.jobsweeper.recommendation.responses.JobRecommendationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseClient {

    private Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "root" ) );
//    private GraphDatabaseService graphDb;
//    private final ObjectMapper objectMapper;


    public DatabaseClient() {
        Session session = driver.session();
        session.run( "CREATE (a:Job {title:'HR', id:'6965402'})" );
        session.run( "CREATE (a:Job {title:'Java Developer', id:'20662027'})" );

        session.run( "CREATE (a:User {name:'John', id:'1'})" );
        session.run( "CREATE (a:User {name:'Mike', id:'2'})" );


        session.run( "CREATE (a:Tag {name:'Java', id:'1'})" );
        session.run( "CREATE (a:Tag {name:'OOP', id:'2'})" );
        session.run( "CREATE (a:Tag {name:'C#', id:'3'})" );
        session.run( "CREATE (a:Tag {name:'Programming', id:'4'})" );
        session.run( "CREATE (a:Tag {name:'Network', id:'5'})" );
        session.run( "CREATE (a:Tag {name:'Recruitment', id:'6'})" );
        session.run( "CREATE (a:Tag {name:'Human Resource', id:'7'})" );
        session.run( "CREATE (a:Tag {name:'Agile', id:'8'})" );
        session.run( "CREATE (a:Tag {name:'Docker', id:'9'})" );
        session.run( "CREATE (a:Tag {name:'Security', id:'10'})" );


        session.run( "MATCH (a:Job { id:'6965402'}) " + " MATCH (b:Tag {id:'6'})" + "CREATE (a)-[c:has]->(b)" );
        session.run( "MATCH (a:Job { id:'6965402'}) " + " MATCH (b:Tag {id:'7'})" + "CREATE (a)-[c:has]->(b)" );
        session.run( "MATCH (a:Job { id:'6965402'}) " + " MATCH (b:Tag {id:'5'})" + "CREATE (a)-[c:has]->(b)" );

        session.run( "MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'1'})" + "CREATE (a)-[c:has]->(b)" );
        session.run( "MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'10'})" + "CREATE (a)-[c:has]->(b)" );
        session.run( "MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'8'})" + "CREATE (a)-[c:has]->(b)" );
        session.run( "MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'9'})" + "CREATE (a)-[c:has]->(b)" );


        session.run( "MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'6'}) CREATE (a)-[c:interested]->(b)" );
        session.run( "MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'5'}) CREATE (a)-[c:interested]->(b)" );
        session.run( "MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'7'}) CREATE (a)-[c:interested]->(b)" );

        session.run( "MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'1'})" + "CREATE (a)-[c:interested]->(b)" );
        session.run( "MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'10'})" + "CREATE (a)-[c:interested]->(b)" );
        session.run( "MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'8'})" + "CREATE (a)-[c:interested]->(b)" );
        session.run( "MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'9'})" + "CREATE (a)-[c:interested]->(b)" );
    }

    public JobRecommendationResponse recommendJobs(int userId, int recNumber) {
        Session session = driver.session();

        StatementResult result = session.run( "MATCH (a:Job)-[b:has]->(c:Tag)<-[d:interested]-(e:User) WHERE e.id = '"
                + userId + "' RETURN a.id AS id, c.name as tag" );


        HashMap<Integer, JobRecommendation> responseMap = new HashMap<>();
        int counter = recNumber;
        while ( result.hasNext() && counter > 0)
        {
            Record record = result.next();
            int jobId = Integer.parseInt(record.get( "id" ).asString());
            if (responseMap.containsKey(jobId)) {
                JobRecommendation jobRecommendation =
                        responseMap.get(jobId);
                jobRecommendation.getTags().add(new Tag(record.get("tag").asString()));
                responseMap.put(jobId, jobRecommendation);
            } else {
                List<Tag> tags = new ArrayList<>();
                tags.add(new Tag(record.get("tag").asString()));
                responseMap.put(jobId, new JobRecommendation(jobId, tags));
                counter--;
            }
            System.out.println( record.get( "id" ).asString() + " " + record.get("tag").asString() );
        }

        List<JobRecommendation> jobRecommendations = new ArrayList<>();
        for (JobRecommendation jobRecommendation : responseMap.values()) {
            jobRecommendations.add(jobRecommendation);
        }
        JobRecommendationResponse response = new JobRecommendationResponse(jobRecommendations);
        session.close();
        return response;
    }

    public void close() {
        driver.close();
    }
}
