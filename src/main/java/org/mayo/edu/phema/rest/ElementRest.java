package org.mayo.edu.phema.rest;

import com.bigdata.rdf.sail.webapp.client.RemoteRepositoryManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.resultio.QueryResultIO;
import org.openrdf.query.resultio.TupleQueryResultFormat;

import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;

public abstract class ElementRest {

    private static String sparqlEndpoint = "http://52.23.162.55:9999/blazegraph";

    protected Response queryRepository(String sparql)  {
        Response response = null;
        TupleQueryResult result = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        final RemoteRepositoryManager repo = new RemoteRepositoryManager(
                sparqlEndpoint, false);

        try {
            result = repo.getRepositoryForDefaultNamespace()
                    .prepareTupleQuery(sparql)
                    .evaluate();

            QueryResultIO.write(result, TupleQueryResultFormat.JSON, baos);
            String respString = baos.toString();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(respString);

            response = Response.status(200).entity(json).build();

        } catch(Exception e ) {
            response = Response.status(400).entity(e.getMessage()).build();
        }
        finally  {
            try {
                repo.close();
            } catch (Exception e)  {
                // swallow
            }
        }

        return response;
    }

}
