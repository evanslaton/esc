package escintegration;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.List;

/** @author      Daniel Logerstedt < daniel.logerstedt @ gmail.com >
 * @version     1.0
 * @since       1.0
 *
 * <p> Integration Testing Suite built for Spring Boot Framework. </p>
 *
 * Utilizes JUnit Test Framework and simplifies the process of performing and building integration testing.
 */

public class EscIntegrationSuite {

    /** Instance variable for storage of port to use in making requests. */
    private int port;

    /** Instance variable for storage of the restTemplate to use in making requests. */
    private TestRestTemplate restTemplate;

    /** Instance variable for storage of HttpHeaders. */
    private HttpHeaders requestHeaders;

    /** Instance variable for storage of MultiValueMap (request body). */
    private MultiValueMap<String, String> requestBody;

    /** Instance variable for storage of HttpEntity. */
    private HttpEntity<Object> requestEntity;

    /** Instance variable for storage of ResponseEntity. */
    private ResponseEntity<String> response;

    /** Constructor for instantiating new Integration Suite objects
     *
     * @param port This is the port assigned by SpringBootTest.WebEnvironment.RANDOM_PORT in the test file, it is stored in the @LocalServerPort Annotated variable.
     * @param restTemplate This is the restTemplate auto wired by the Spring testing framework in the test file, it is passed in so that it can be utilized in making requests from the specific instance.
     */
    public EscIntegrationSuite(int port, TestRestTemplate restTemplate) {
        this.port = port;
        this.restTemplate = restTemplate;
        this.requestHeaders = new HttpHeaders();
        this.requestBody = new LinkedMultiValueMap<>();
        this.requestEntity = null;
        this.response = null;

    }


    /*
     * Getters for Instance Object
     */

    /** Returns the current value for the instance HttpHeaders, is default header information if nothing has been modified.
     *
     * @return HttpHeaders
     */
    public HttpHeaders getHeaders() {
        return this.requestHeaders;
    }

    /** Returns the current value for the instance request Body, is empty if nothing has been added.
     *
     * @return MultiValueMap gets the current body containing request body key value pairs
     */
    public MultiValueMap<String, String> getRequestBody() {
        return this.requestBody;
    }

    /** Returns the current value for the instance HttpEntity, is null if createEntity hasn't been invoked yet.
     *
     * @return HttpEntity gets the current HttpEntity
     */

    public HttpEntity getEntity() {
        return this.requestEntity;
    }

    /*
     * Setters for Instance Object
     */

    /*
     * Header Setter Methods
     */

    /** Returns void after adding the Key Value pair onto the instance Headers for use in requests with this instance.
     *
     * @param key The name of the property being placed in the headers.
     * @param value The value being placed in the property of the provided name.
     */

    public void setHeaders(String key, String value) {
        requestHeaders.add(key, value);
    }

    /** Returns void after adding the List of Values onto the instance Headers under the Key provided for use in requests with this instance.
     *
     * @param key The name of the property being placed in the headers.
     * @param values A list of values being placed in the property of the provided name.
     */

    public void setHeadersAll(String key, List<String> values) {
        requestHeaders.addAll(key, values);
    }

    /** Returns void after adding the Multi Value Map of Key Value pairs onto the instance Headers for use in requests with this instance.
     *
     * @param values A MultiValueMap containing multiple key value pairs to be added to the headers
     */

    public void setHeadersAll(MultiValueMap<String, String> values) {
        requestHeaders.addAll(values);
    }

    /** Returns void after resetting the headers to a default HttpHeader object.
     */

    public void resetHeaders () {
        requestHeaders = new HttpHeaders();
    }

    /*
     * Body Setter Methods
     */

    /** Returns void after adding the Key Value pair onto the instance Body for use in requests with this instance.
     *
     * @param key The name of the property being placed in the body.
     * @param value The value being placed in the property of the provided name.
     */

    public void setBody(String key, String value) {
        requestBody.add(key, value);
    }

    /** Returns void after adding the List of Values onto the instance Body under the Key provided for use in requests with this instance.
     *
     * @param key The name of the property being placed in the body.
     * @param values A list of values being placed in the property of the provided name.
     */
    public void setBodyAll(String key, List<String> values) {
        requestBody.addAll(key, values);
    }

    /** Returns void after adding the Multi Value Map of Key Value pairs onto the instance Body for use in requests with this instance.
     *
     * @param values A MultiValueMap containing multiple key value pairs to be added to the headers
     */
    public void setBodyAll(MultiValueMap<String, String> values) {
        requestBody.addAll(values);
    }

    /** Returns void after resetting the headers to a default LinkedMultiValueMap object.
     */

    public void resetBody () {
        requestBody = new LinkedMultiValueMap<>();
    }

    // Entity Manipulation Methods

    /** Creates the instance HttpEntity from the current instance Headers and Body.
     */

    public void createEntity() {
        this.requestEntity = new HttpEntity<>(this.requestBody, this.requestHeaders);
    }

    /** Resets the instance HttpEntity to null.
     */

    public void resetEntity() {
        this.requestEntity = null;
    }

    /*
     * Request Types
     */

    /** Request Handler, takes request type as String and applies correct method. Accepts "GET", "POST", "PUT", "DELETE", "HEAD" for simple request types. For more extensive types use HttpMethod instead.
     *
     * @param method String method type for request.
     * @param url String url for request.
     */

    public void request(String method, String url) {
        switch (method) {
            case "GET" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.GET, this.requestEntity, String.class);
                break;
            case "PUT" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.PUT, this.requestEntity, String.class);
                break;
            case "POST" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.POST, this.requestEntity, String.class);
                break;
            case "DELETE" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.DELETE, this.requestEntity, String.class);
                break;
            case "HEAD" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.HEAD, this.requestEntity, String.class);
                break;
        }
    }

    /** Request Handler, takes request type as String and applies correct method. Accepts "GET", "POST", "PUT", "DELETE", "HEAD" for simple request types. For more extensive types use HttpMethod instead. This Method also takes a URI for the url instead of a string.
     *
     * @param method String method type for request.
     * @param url URI for request.
     */

    public void request(String method, URI url) {
        switch (method) {
            case "GET" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.GET, this.requestEntity, String.class);
                break;
            case "PUT" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.PUT, this.requestEntity, String.class);
                break;
            case "POST" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.POST, this.requestEntity, String.class);
                break;
            case "DELETE" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.DELETE, this.requestEntity, String.class);
                break;
            case "HEAD" :
                this.response = this.restTemplate.exchange("http://localhost:" + port + url, HttpMethod.HEAD, this.requestEntity, String.class);
                break;
        }
    }

    /** Request Handler, takes HttpMethod for method and string for url.
     *
     * @param method HttpMethod for request.
     * @param url String url for request.
     */

    public void request(HttpMethod method, String url) {
        this.response = this.restTemplate.exchange("http://localhost:" + port + url, method, this.requestEntity, String.class);
    }


    /** Request Handler, takes HttpMethod for method and URI for url.
     *
     * @param method HttpMethod for request.
     * @param url URI for request.
     */

    public void request(HttpMethod method, URI url) {
        this.response = this.restTemplate.exchange("http://localhost:" + port + url, method, this.requestEntity, String.class);
    }

    /*
     * Response handling
     */

    /** Gets response object.
     *
     * @return ResponseEntity is returned from instance variable.
     */
    public ResponseEntity<String> getResponse() {
        return this.response;
    }

    /** Gets all cookies attached to the response.
     *
     * @return List of Strings returned containing all cookies sent on the response object.
     */
    public List<String> responseCookies() {
        return this.response.getHeaders().get("Set-Cookie");
    }

    /** Gets one of the cookies attached to the response at a specific index.
     *
     * @param index The index location of the cookie to be returned.
     * @return The cookie at the provided index.
     */
    public String responseCookieIndex(int index) {
        return this.response.getHeaders().get("Set-Cookie").get(index);
    }

    /** Gets the response code as type of int and returns it.
     *
     * @return The response code in int format.
     */
    public int responseCodeInt() {
        return this.response.getStatusCodeValue();
    }

    /** Gets the response code as type of HttpStatus and returns it.
     *
     * @return The response code in HttpStatus format.
     */
    public HttpStatus responseCodeStatus() {
        return this.response.getStatusCode();
    }

    /** Gets and returns the HttpHeaders attached to the response object.
     *
     * @return HttpHeaders of the most recent response.
     */
    public HttpHeaders responseHeaders() {
        return this.response.getHeaders();
    }

    /** Gets and returns the Body attached to the response object as a string.
     *
     * @return Body of the most recent response.
     */
    public String responseBody() {
        return this.response.getBody();
    }

    /** Resets the response to null for multiple requests
     *
     */
    public void resetResponse() {
        this.response = null;
    }
}
