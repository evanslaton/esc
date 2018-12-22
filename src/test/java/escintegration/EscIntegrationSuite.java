package escintegration;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EscIntegrationSuite {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders requestHeaders;
    private MultiValueMap<String, String> requestBody;
    private HttpEntity<Object> requestEntity;
    private ResponseEntity<String> response;


    public EscIntegrationSuite() {

        this.requestHeaders = new HttpHeaders();
        this.requestBody = new LinkedMultiValueMap<>();
        this.requestEntity = null;
        this.response = null;

    }

    /*
     Returns the current value for the instance HttpHeaders, is default header information if nothing has been modified.
     */

    // Getters for Instance Object

    public HttpHeaders getHeaders() {
        return this.requestHeaders;
    }

    /*
     Returns the current value for the instance request Body, is empty if nothing has been added.
     */

    public MultiValueMap<String, String> getRequestBody() {
        return this.requestBody;
    }

    /*
     Returns the current value for the instance HttpEntity, is null if createEntity hasn't been invoked yet.
     */

    public HttpEntity getEntity() {
        return this.requestEntity;
    }

    // Setters for Instance Object

    // Header Setter Methods

    /*
     Returns void after adding the Key Value pair onto the instance Headers for use in requests with this instance.
     */

    public void setHeaders(String key, String value) {
        requestHeaders.add(key, value);
    }

    /*
     Returns void after adding the List of Values onto the instance Headers under the Key provided for use in requests with this instance.
     */

    public void setHeadersAll(String key, List<String> values) {
        requestHeaders.addAll(key, values);
    }

    /*
     Returns void after adding the Multi Value Map of Key Value pairs onto the instance Headers for use in requests with this instance.
     */

    public void setHeadersAll(MultiValueMap<String, String> values) {
        requestHeaders.addAll(values);
    }

    /*
     Returns void after resetting the headers to a default HttpHeader object.
     */

    public void resetHeaders () {
        requestHeaders = new HttpHeaders();
    }

    // Body Setter Methods

    /*
     Returns void after adding the Key Value pair onto the instance Body for use in requests with this instance.
     */

    public void setBody(String key, String value) {
        requestBody.add(key, value);
    }

    /*
     Returns void after adding the List of Values onto the instance Body under the Key provided for use in requests with this instance.
     */

    public void setBodyAll(String key, List<String> values) {
        requestBody.addAll(key, values);
    }

    /*
     Returns void after adding the Multi Value Map of Key Value pairs onto the instance Body for use in requests with this instance.
     */

    public void setBodyAll(MultiValueMap<String, String> values) {
        requestBody.addAll(values);
    }

    /*
     Returns void after resetting the headers to a default LinkedMultiValueMap object.
     */

    public void resetBody () {
        requestBody = new LinkedMultiValueMap<>();
    }

    // Entity Manipulation Methods

    /*
     Creates the instance HttpEntity from the current instance Headers and Body. It then Returns the Entity.
     */

    public HttpEntity<Object> createEntity() {
        this.requestEntity = new HttpEntity<>(this.requestHeaders, this.requestBody);
        return this.requestEntity;
    }

    /*
     Resets the instance HttpEntity to null.
     */

    public void resetEntity() {
        this.requestEntity = null;
    }

    // Request Types

    /*
     Request Handler, takes request type as String and applies correct method. Accepts "GET", "POST", "PUT", "DELETE", "HEAD" for simple request types. For more extensive types use HttpMethod instead.
     */

    public void request(String method, String url) {
        switch (method) {
            case "GET" :
                this.response = this.restTemplate.exchange(url, HttpMethod.GET, this.requestEntity, String.class);
                break;
            case "PUT" :
                this.response = this.restTemplate.exchange(url, HttpMethod.PUT, this.requestEntity, String.class);
                break;
            case "POST" :
                this.response = this.restTemplate.exchange(url, HttpMethod.POST, this.requestEntity, String.class);
                break;
            case "DELETE" :
                this.response = this.restTemplate.exchange(url, HttpMethod.DELETE, this.requestEntity, String.class);
                break;
            case "HEAD" :
                this.response = this.restTemplate.exchange(url, HttpMethod.HEAD, this.requestEntity, String.class);
                break;
        }
    }

    /*
     Request Handler, takes request type as String and applies correct method. Accepts "GET", "POST", "PUT", "DELETE", "HEAD" for simple request types. For more extensive types use HttpMethod instead. This Method also takes a URI for the url instead of a string.
     */

    public void request(String method, URI url) {
        switch (method) {
            case "GET" :
                this.response = this.restTemplate.exchange(url, HttpMethod.GET, this.requestEntity, String.class);
                break;
            case "PUT" :
                this.response = this.restTemplate.exchange(url, HttpMethod.PUT, this.requestEntity, String.class);
                break;
            case "POST" :
                this.response = this.restTemplate.exchange(url, HttpMethod.POST, this.requestEntity, String.class);
                break;
            case "DELETE" :
                this.response = this.restTemplate.exchange(url, HttpMethod.DELETE, this.requestEntity, String.class);
                break;
            case "HEAD" :
                this.response = this.restTemplate.exchange(url, HttpMethod.HEAD, this.requestEntity, String.class);
                break;
        }
    }

    /*
     Request Handler, takes HttpMethod for method and string for url.
     */

    public void request(HttpMethod method, String url) {
        this.response = this.restTemplate.exchange(url, method, this.requestEntity, String.class);
    }


    /*
     Request Handler, takes HttpMethod for method and URI for url.
     */

    public void request(HttpMethod method, URI url) {
        this.response = this.restTemplate.exchange(url, method, this.requestEntity, String.class);
    }

    // Response handling

    /*
     Gets all cookies attached to the response.
     */

    public String responseCookieIndex(int index) {
        return this.response.getHeaders().get("Set-Cookie").get(index);
    }

    /*
     Gets one of the cookies attached to the response at a specific index.
     */
    public List<String> responseCookies() {
        return this.response.getHeaders().get("Set-Cookie");
    }

    /*
     Gets the response code as type of int and returns it.
     */
    public int responseCodeInt() {
        return this.response.getStatusCodeValue();
    }

    /*
     Gets the response code as type of HttpStatus and returns it.
     */
    public HttpStatus responseCodeStatus() {
        return this.response.getStatusCode();
    }

    /*
     Gets and returns the HttpHeaders attached to the response object.
     */
    public HttpHeaders responseHeaders() {
        return this.response.getHeaders();
    }

    /*
     Gets and returns the Body attached to the response object as a string.
     */

    public String responseBody() {
        return this.response.getBody();
    }
}
