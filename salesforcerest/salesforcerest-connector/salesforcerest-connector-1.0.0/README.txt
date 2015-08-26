Product: WSO2 ESB Connector for Salesforce REST API + Integration Tests

 Pre-requisites:

    - Maven 3.x
    - Java 1.6 or above
    - The org.wso2.esb.integration.integration-base project is required. The test suite has been configured to download this project automatically. If the automatic download fails, download the following project and compile it using the mvn clean install command to update your local repository:
                 https://github.com/wso2/esb-connectors/tree/master/integration-base-1.0.1

    Tested Platforms:

    - Microsoft WINDOWS V-7
    - Ubuntu 13.04
    - WSO2 ESB 4.9.0-BETA



Steps to follow in setting integration test.


 1. Download ESB 4.9.0-BETA-SNAPSHOT by navigating to the following URL: http://svn.wso2.org/repos/wso2/people/malaka/ESB/beta/


 2. Deploy relevant patches, if applicable. Place the patch files into location <ESB_HOME>/repository/components/patches.

 3. ESB should be configured as below.
    Please make sure that the below mentioned Axis configurations are enabled (\repository\conf\axis2\axis2.xml)

	    Message Formatters :-
	    <messageFormatter contentType="application/json"
							  class="org.apache.synapse.commons.json.JsonStreamFormatter"/>
	    <messageFormatter contentType="text/html"
        						  class="org.wso2.carbon.relay.ExpandingMessageFormatter"/>

	    Message Builders :-
	    <messageBuilder contentType="application/json"
							  class="org.apache.synapse.commons.json.JsonStreamBuilder"/>
	    <messageBuilder contentType="text/html"
							  class="org.wso2.carbon.relay.BinaryRelayBuilder"/>



 4. Compress modified ESB as wso2esb-4.9.0-BETA.zip and copy that zip file in to location "<ESB_CONNECTORS_HOME>/repository/".


 5. Create a Salesforce account and create a connected app.
       i)  Using the URL "https://salesforce.com" create an account and connected app.

 Follow the below URL to 


 6. Make sure that salesforcerest is specified as a module in ESB Connector Parent pom.
            <module>salesforcerest/salesforcerest-connector/salesforcerest-connector-1.0.0/org.wso2.carbon.connector</module>

 7. Update the salesforcerest properties file at location "<SALESFORCEREST_CONNECTOR_HOME>/salesforcerest-connector/salesforcerest-connector-1.0.0/org.wso2.carbon.connector/src/test/resources/artifacts/ESB/connector/config" as below.

        i)	apiUrl 							- 	The URL of your salesforce connected app.
        ii)apiVersion=v32.0                                             -       The api version for the connected app(New version is better because some of the features are supported only on the new 											version).
        iii)refreshToken                                                -       The refresh token to access the API.
        iv)clientId=3MVG9ZL0ppGP5UrBrnsanGUZRgHqc8gTV4t_6               -       The Consumer key of API to access the connected app.
        v)clientSecret=9104967092887676680                              -       The consumer key of API to access the connected app.
        vi)hostName=https://login.salesforce.com                        -       Value of the hostname to authenticate salesforce(If you are using sandbox then the hostName is "https://                     											test.salesforce.com" instead of "https://login.salesforce.com").

        vii)accessToken=00D28000000eWK8!AQUAQOG5YOK4BEZmrJYGuYPB8eS     -       The access Token to access the API.
        viii)apiUrl=https://ap2.salesforce.com                          -       The URL of the connected app.

        ix)sobject=Account						-       The type of the sObject.

        x)startTime=2015-08-08T12:30:30+05:30                           -       The start time of the period 
        xi)endTime=2015-08-25T20:30:30+05:30

        xii)userId=00528000000yl7j


        xiii)Id=00128000006RbCB

        xiv)idToDelete=00128000006RbEg



        xviii)#actionName=hariprasath__NewAccount

        xviv)rowId=00128000005YjDnAAK


        xx)queryString=select+id+,+name+from+Account

        xxi)#nextRecordsUrl=x

        xxii)#actionName=x

        xxiii)#newPassword=test123
        xxiv)fields=id,name

        xxv)searchString=FIND+{map*}+IN+ALL+FIELDS+RETURNING+Account+(Id,+Name),+Contact,+Opportunity,+Lead

        xxvi)sObjectList=Account,User

        xxvii)sobjectType=Account

        xviii)listViewID=00B28000002yqeVEAQ

        xvix)fields=AccountNumber,BillingPostalCode

        xxx)name=harrri
        xxxi)description=hello man how are har






 8.  Navigate to "{ESB_Connector_Home}/" and run the following command.
             $ mvn clean install