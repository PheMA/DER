package org.mayo.edu.phema;

import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SparqlTest {

  protected int getResponseCount(Response response)  {
    JSONObject temp = (JSONObject) response.getEntity();
    JSONObject temp2 = (JSONObject) temp.get("results");
    JSONArray temp3 = (JSONArray) temp2.get("bindings");
    return temp3.size();
  }

}
