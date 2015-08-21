package org.wso2.carbon.connector.integration.test.salesforcerest;

/*
 *
 *  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 * /
 */
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SalesforceRestConnectorIntegrationTest extends ConnectorIntegrationTestBase {
    private Map<String, String> esbRequestHeadersMap = new HashMap<String, String>();

    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

    private Map<String, String> mpRequestHeadersMap = new HashMap<String, String>();

    private String multipartProxyUrl;

    /**
     * Set up the environment.
     */
    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {

        init("salesforcerest-connector-1.0.0");
        esbRequestHeadersMap.put("Accept-Charset", "UTF-8");
        esbRequestHeadersMap.put("Content-Type", "application/json");

        apiRequestHeadersMap.put("Accept-Charset", "UTF-8");
        apiRequestHeadersMap.put("Content-Type", "application/json");
        String accessToken = connectorProperties.getProperty("accessToken");
        apiRequestHeadersMap.put("Authorization", "Bearer "+ accessToken);


    }



    /**
     * Test case for describeSGlobal method.
     */
    @Test(enabled = true, description = "salesforcerest {describeGlobal} integration test.")
    public void describeGlobal() throws IOException, JSONException {

       // String methodName = "describeGlobal";
        System.out.println("pass1");
       // RestResponse<JSONObject> esbRestResponse = sendJsonRestRequest(getProxyServiceURL(methodName), "POST", esbRequestHeadersMap, "describeGlobal.json");
       // System.out.println("pass2");
        String apiEndPoint = connectorProperties.getProperty("apiUrl") + "/services/data/"+ connectorProperties.getProperty("apiVersion")+"/sobjects";
        System.out.println("pass3");

        RestResponse<JSONObject> apiRestResponse = sendJsonRestRequest(apiEndPoint, "GET", apiRequestHeadersMap);
        System.out.println("pass4");


        //Assert.assertEquals(esbRestResponse.getBody().toString(), apiRestResponse.getBody().toString());
        System.out.println("pass5");
    }


}