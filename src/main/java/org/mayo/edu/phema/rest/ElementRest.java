package org.mayo.edu.phema.rest;

import com.bigdata.rdf.sail.webapp.client.RemoteRepositoryManager;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.resultio.QueryResultIO;
import org.openrdf.query.resultio.TupleQueryResultFormat;

import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;

public class ElementRest {

    private static final String serviceURL = "http://23.101.174.173:9999/blazegraph";

    protected Response queryRepository(String sparql)  {
        Response response = null;
        TupleQueryResult result = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        final RemoteRepositoryManager repo = new RemoteRepositoryManager(
                serviceURL, false);

        try {
            result = repo.getRepositoryForDefaultNamespace()
                    .prepareTupleQuery(sparql)
                    .evaluate();

            QueryResultIO.write(result, TupleQueryResultFormat.JSON, baos);
            //System.out.println(baos.toString());
            response = Response.status(200).entity(baos.toString()).build();

        } catch(Exception e ) {
            response = Response.status(400).entity(e.getMessage()).build();;
        }

        return response;
    }

}
