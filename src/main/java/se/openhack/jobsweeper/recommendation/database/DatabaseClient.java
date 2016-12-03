package se.openhack.jobsweeper.recommendation.database;

import org.neo4j.driver.v1.*;
import se.openhack.jobsweeper.recommendation.entities.*;
import se.openhack.jobsweeper.recommendation.responses.JobRecommendationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseClient {

    private Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j",
            "root"));


    public DatabaseClient() {
        try (Session session = driver.session()) {
            if (!session.run("MATCH (a:Job { id:'6965402'}) RETURN a").hasNext())
                initDatabase();
        }
    }

    private void initDatabase() {
        try (Session session = driver.session()) {
            session.run("CREATE (a:Job {title:'HR', id:'6965402'})");
            session.run("CREATE (a:Job {title:'Java Developer', id:'20662027'})");
            session.run("CREATE (a:Job {title:'Java Tester Unix', id:'20674382'})");
            session.run("CREATE (a:Job {title:'Web Developer', id:'20673861'})");
            session.run("CREATE (a:Job {title:'Beauty Saloon Staff', id:'20674929'})");


            session.run("CREATE (a:User {name:'John', id:'1'})");
            session.run("CREATE (a:User {name:'Mike', id:'2'})");


            session.run("CREATE (a:Tag {name:'Java', id:'1'})");
            session.run("CREATE (a:Tag {name:'OOP', id:'2'})");
            session.run("CREATE (a:Tag {name:'C#', id:'3'})");
            session.run("CREATE (a:Tag {name:'Programming', id:'4'})");
            session.run("CREATE (a:Tag {name:'Network', id:'5'})");
            session.run("CREATE (a:Tag {name:'Recruitment', id:'6'})");
            session.run("CREATE (a:Tag {name:'Human Resource', id:'7'})");
            session.run("CREATE (a:Tag {name:'Agile', id:'8'})");
            session.run("CREATE (a:Tag {name:'Docker', id:'9'})");
            session.run("CREATE (a:Tag {name:'Security', id:'10'})");
            session.run("CREATE (a:Tag {name:'Linux', id:'11'})");
            session.run("CREATE (a:Tag {name:'Testing', id:'12'})");
            session.run("CREATE (a:Tag {name:'Web', id:'13'})");
            session.run("CREATE (a:Tag {name:'HTML5', id:'14'})");
            session.run("CREATE (a:Tag {name:'Javascript', id:'15'})");
            session.run("CREATE (a:Tag {name:'Beauty', id:'16'})");
            session.run("CREATE (a:Tag {name:'Make-up', id:'17'})");


            session.run("MATCH (a:Job { id:'6965402'}) " + " MATCH (b:Tag {id:'6'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'6965402'}) " + " MATCH (b:Tag {id:'7'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'6965402'}) " + " MATCH (b:Tag {id:'5'})" + "CREATE (a)-[c:has]->(b)");

            session.run("MATCH (a:Job { id:'20674382'}) " + " MATCH (b:Tag {id:'1'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20674382'}) " + " MATCH (b:Tag {id:'11'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20674382'}) " + " MATCH (b:Tag {id:'12'})" + "CREATE (a)-[c:has]->(b)");

            session.run("MATCH (a:Job { id:'20673861'}) " + " MATCH (b:Tag {id:'13'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20673861'}) " + " MATCH (b:Tag {id:'14'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20673861'}) " + " MATCH (b:Tag {id:'15'})" + "CREATE (a)-[c:has]->(b)");

            session.run("MATCH (a:Job { id:'20674929'}) " + " MATCH (b:Tag {id:'16'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20674929'}) " + " MATCH (b:Tag {id:'17'})" + "CREATE (a)-[c:has]->(b)");

            session.run("MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'1'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'10'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'8'})" + "CREATE (a)-[c:has]->(b)");
            session.run("MATCH (a:Job { id:'20662027'}) " + " MATCH (b:Tag {id:'9'})" + "CREATE (a)-[c:has]->(b)");


            session.run("MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'6'}) CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'5'}) CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'7'}) CREATE (a)-[c:interested {counter:1}]->(b)");

            session.run("MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'16'}) CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'1'})  MATCH (b:Tag {id:'15'}) CREATE (a)-[c:interested {counter:1}]->(b)");

            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'1'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'10'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'8'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'9'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");

            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'11'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'12'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");

            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'13'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'14'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");
            session.run("MATCH (a:User { id:'2'}) " + " MATCH (b:Tag {id:'15'})" + "CREATE (a)-[c:interested {counter:1}]->(b)");
        }
    }

    public JobRecommendationResponse recommendJobs(int userId, int recNumber) {
        try (Session session = driver.session()) {
            StatementResult jobs = session.run("MATCH (a:Job)-[b:has]->(c:Tag)<-[d:interested]-(e:User) " +
                    "WHERE e.id = '" + userId + "' RETURN a.id AS id, SUM(d.counter) + ABS(MIN(d.counter)) as score ORDER BY score DESC\n" +
                    "LIMIT " + recNumber);

            List<JobRecommendation> jobRecommendations = new ArrayList<>();
            while (jobs.hasNext()) {
                Record record = jobs.next();
                int jobId = Integer.parseInt(record.get("id").asString());
                StatementResult result = session.run("MATCH (a:Job {id:'" + jobId + "'})-[b:has]->(c:Tag) " +
                        "return c.name as tag");
                List<Tag> tags = new ArrayList<>();
                while (result.hasNext()) {
                    Record jobTag = result.next();
                    tags.add(new Tag(jobTag.get("tag").asString()));
                }
                jobRecommendations.add(new JobRecommendation(jobId, tags));
            }
            return new JobRecommendationResponse(jobRecommendations);
        }
    }

    public void updateTags(int userId, List<TagDelta> tags) {
        try (Session session = driver.session()) {
            for (TagDelta tag : tags) {
                updateTag(userId, tag.getName(), tag.getDelta(), session);
            }
        }
    }

    private void updateTag(int userId, String tagName, int delta, Session session) {
        StatementResult result = session.run("MATCH (c:Tag {name:'" + tagName + "'})<-[d:interested]-(e:User) WHERE e.id = '"
                + userId + "' RETURN d.counter as counter");
        Record record = result.next();
        int counter = record.get("counter").asInt();
        counter += delta;
        session.run("MATCH (c:Tag {name:'" + tagName + "'})<-[d:interested]-(e:User) WHERE e.id = '"
                + userId + "' SET d.counter=" + counter);

    }

    public void createUser(int userId, String name) {
        try (Session session = driver.session()) {
            session.run("CREATE (a:User {name:'" + name + "', id:'" + userId + "'})");
        }
    }

    public void insertNewJobs(List<Job> jobs) {
        try (Session session = driver.session()) {
            for (Job job : jobs) {
                insertJob(job.getId(), job.getTitle(), job.getTags(), session);
            }
        }
    }

    private void insertJob(int id, String title, List<Tag> tags, Session session) {
        session.run("CREATE (a:Job {id:'"+id+"', title:'"+title+"'})");

       for (Tag tag : tags) {
           int tagId = 0;
           StatementResult tagDb = session.run("MATCH (a:Tag { name:'"+tag.getName()+"'}) RETURN a.id as id");
           if (!tagDb.hasNext()) {
               tagId = session.run("MATCH (a:Tag) RETURN count(a) as count").next().get("count").asInt()+1;
               session.run("CREATE (a:Tag {name:'" + tag.getName() + "', id:'"+ tagId+"'})");
           } else {
               tagId = Integer.parseInt(tagDb.next().get("id").asString());
           }
           session.run("MATCH (a:Job { id:'"+id+"'}) " + " MATCH (b:Tag {id:'"+tagId+"'})" + "CREATE (a)-[c:has]->(b)");
       }

    }

    public void close() {
        driver.close();
    }

    public List<TagWithCounter> getTagsForUser(int userId) {
        try (Session session = driver.session()) {
            StatementResult result = session.run("MATCH (a:User {id:'" + userId + "'})-[b:interested]->(c:Tag) " +
                    "return c.name as tag, b.counter as counter");
            List<TagWithCounter> tags = new ArrayList<>();
            while (result.hasNext()) {
                Record tag = result.next();
                tags.add(new TagWithCounter(tag.get("tag").asString(), tag.get("counter").asInt()));
            }
            return tags;
        }
    }

    public void jobSwipe(int userId, int jobId, boolean like) {
        try (Session session = driver.session()) {
            String query = "MATCH (a:User {id:'" + userId + "'}) " +
                    "MATCH (b:Job {id:'"+jobId+"'}) ";
            if (like) {
                query += "CREATE (a)-[c:like]->(b)";
            } else {
                query += "CREATE (a)-[c:dislike]->(b)";

            }
            session.run(query);
        }
    }
}
