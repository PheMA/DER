package org.mayo.edu.phema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.mayo.edu.phema.rest.ElementRest;

public class SparqlTest extends ElementRest {

  protected int getResponseCount(Response response)  {
    JSONObject temp = (JSONObject) response.getEntity();
    JSONObject temp2 = (JSONObject) temp.get("results");
    JSONArray temp3 = (JSONArray) temp2.get("bindings");
    return temp3.size();
  }

  @Test
  void testConnection() {
    SparqlTest sparqlTest = new SparqlTest();
    Response response = sparqlTest.queryRepository("SELECT * WHERE { ?s ?p ?o } limit 20");
    assertEquals(20, getResponseCount(response));
    assertEquals(200, response.getStatus());
  }
}
