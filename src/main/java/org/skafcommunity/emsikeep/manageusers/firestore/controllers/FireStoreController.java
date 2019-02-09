package org.skafcommunity.emsikeep.manageusers.firestore.controllers;


import org.skafcommunity.emsikeep.manageusers.firestore.services.FireStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class FireStoreController {

  @Autowired
  FireStoreService fireStoreService;

  @RequestMapping(value = "/{collectionName}/add", method = RequestMethod.POST)
  public Map<String, Object> get(HttpServletResponse response, @PathVariable String collectionName, @RequestBody Map<String, Object> data){
    try {
      return fireStoreService.addDocument(collectionName, data);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return errorResult(response);
    } catch (ExecutionException e) {
      e.printStackTrace();
      return errorResult(response);
    }
  }

  @RequestMapping(value = "/{collectionName}", method = RequestMethod.GET)
  public List<Map<String, Object>> getAll(HttpServletResponse response, @PathVariable String collectionName){
    try {
      return fireStoreService.getDocumentsCollection(collectionName);
    } catch (InterruptedException e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return null;
    } catch (ExecutionException e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return null;
    }
  }

  @RequestMapping(value = "/{collectionName}/{documentID}", method = RequestMethod.POST)
  public Map<String, Object> set(HttpServletResponse response, @PathVariable String collectionName, @PathVariable String documentID, @RequestBody Map<String, Object> data){
    try {
      return fireStoreService.updateDocument(collectionName, documentID, data);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return errorResult(response);
    } catch (ExecutionException e) {
      e.printStackTrace();
      return errorResult(response);
    }
  }

  @RequestMapping(value = "/{collectionName}/{documentID}", method = RequestMethod.GET)
  public Map<String, Object> get(HttpServletResponse response, @PathVariable String collectionName, @PathVariable String documentID){
    try {
      return fireStoreService.getDocument(collectionName, documentID);
    } catch (InterruptedException e) {
      e.printStackTrace();
      return errorResult(response);
    } catch (ExecutionException e) {
      e.printStackTrace();
      return errorResult(response);
    }
  }

  @RequestMapping(value = "/{collectionName}/{documentID}", method = RequestMethod.DELETE)
  public Map<String, Object> delete(HttpServletResponse response, @PathVariable String collectionName, @PathVariable String documentID){
    try {
      Map<String, Object> data = new HashMap<>();
      data.put("deleted", (Boolean)fireStoreService.deleteDocument(collectionName, documentID));
      return data;
    }
    catch (Exception e) {
      e.printStackTrace();
      return errorResult(response);
    }
  }

  private Map<String, Object> errorResult(HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    Map<String, Object> error = new HashMap<>();
    error.put("error", true);
    return error;
  }


}
