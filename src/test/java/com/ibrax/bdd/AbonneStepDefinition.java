package com.ibrax.bdd;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;


/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */

public class AbonneStepDefinition {

    private final String BASE_URL = "http://localhost:5000/api/v1";

    private RestTemplate restTemplate;

    private ResponseEntity<String> responseAbonne;

    private ResponseEntity<String> responseContract;

    private ResponseEntity<String> responseMouv;

    private String nouvVal;

    private String anVal;

    private ResponseEntity<String> responseUser;


    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        return headers;
    }

    @Given("un abonne avec une adresse principale en France")
    public void create_Abonne() throws JSONException {
        //creation of a subscriber
        String nom = "test1";
        String prenom = "test2";
        String adresse = "essai";
        String bodyAbonne = "{\"nom\":\"" + nom + "\",\"prenom\":\"" + prenom + "\",\"adresse\":\"" + adresse + "\"}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyAbonne, getHeader());
        restTemplate = new RestTemplate();
        responseAbonne = restTemplate.postForEntity(BASE_URL + "/abonne/", entity, String.class);
        //creation of a contract
        JSONObject jsonAbonne = new JSONObject(responseAbonne.getBody());
        String bodyContrat = "{\"abonne\":\"" + jsonAbonne.get("id") + "\",\"adresse\":\"testAdresse\"}";
        HttpEntity<String> entity1 = new HttpEntity<String>(bodyContrat, getHeader());
        responseContract = restTemplate.postForEntity(BASE_URL + "/contrats/", entity1, String.class);
        //check the status of responses received
        Assert.assertTrue(responseAbonne.getStatusCode() == HttpStatus.OK);
        Assert.assertTrue(responseContract.getStatusCode() == HttpStatus.OK);

    }


    @When("le conseiller modifie l'adresse de l'abonné")
    public void update_Abonne() throws JSONException {
        // create users
        String username = "test1";
        String password = "123456";
        String bodyUser = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyUser, getHeader());
        restTemplate = new RestTemplate();
        restTemplate.postForEntity(BASE_URL + "/users/", entity, String.class);
        // user authentication
        responseUser = restTemplate.postForEntity(BASE_URL + "/users/login", entity, String.class);
        if (responseUser != null) {
            //Retrieving the new value of the subscriber's address
            JSONObject jsonAbonne = new JSONObject(responseAbonne.getBody());
            nouvVal = "test test test ";
            anVal = (String) jsonAbonne.get("adresse");
        }
    }

    @Then("la nouvelle adresse de l’abonné est enregistrée sur l'ensemble des contrats de l'abonné")
    public void save_abonne() throws JSONException {
        //update of the subscriber's address on all contracts
        JSONObject jsonAbonne = new JSONObject(responseAbonne.getBody());
        String nom = (String) jsonAbonne.get("nom");
        String prenom = (String) jsonAbonne.get("prenom");
        String modAdresse = "{\"nom\":\"" + nom + "\",\"prenom\":\"" + prenom + "\",\"adresse\":\"" + nouvVal + "\"}";
        HttpEntity<String> entity = new HttpEntity<String>(modAdresse, getHeader());
        responseAbonne = restTemplate.exchange(BASE_URL + "/abonne/" + jsonAbonne.get("id"), HttpMethod.PUT, entity, String.class);
        //check the status of responses received
        Assert.assertTrue(responseAbonne.getStatusCode() == HttpStatus.OK);
    }

    @And("un mouvement de modification d'adresse est créé avec la nouvelle adresse")
    public void mouvement_adresse() throws JSONException {
        //creation of an address modification movement
        JSONObject jsonAbonne = new JSONObject(responseAbonne.getBody());
        JSONObject jsonContrat = new JSONObject(responseContract.getBody());
        String typeMod = "Mouvement d'adresse";
        String mouvement = "{\"abonne\":\"" + jsonAbonne.get("id") + "\",\"contrat\":\"" + jsonContrat.get("id") + "\",\"typeMod\":\"" + typeMod + "\", \"dateMod\":\"04/12/2020\", \"nouVal\":\"" + nouvVal + "\", \"AnVal\":\"" + anVal + "\"}";
        HttpEntity<String> entity = new HttpEntity<String>(mouvement, getHeader());
        responseMouv = restTemplate.postForEntity(BASE_URL + "/mouvements/", entity, String.class);
        //check the status of responses received
        Assert.assertTrue(responseMouv.getStatusCode() == HttpStatus.OK);
    }


}
