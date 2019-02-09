package org.skafcommunity.emsikeep.manageusers.firestore.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import org.skafcommunity.emsikeep.manageusers.firestore.dao.FireStoreDAO;
import org.skafcommunity.emsikeep.manageusers.firestore.dao.FirebaseAdminSDK;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FireStoreService {

  public List<Map<String, Object>> getDocumentsCollection(String collectionName) throws ExecutionException, InterruptedException {
    CollectionReference collection = FirebaseAdminSDK.getFirestore().collection(collectionName);
    ApiFuture<QuerySnapshot> query = collection.get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    List<Map<String, Object>> collectionData = new ArrayList<>();
    for (QueryDocumentSnapshot document : documents){
      Map<String, Object> data = document.getData();
      data.put("id", document.getId());
      collectionData.add(data);
    }
    return collectionData;
  }

  public Map<String, Object> addDocument(String collectionName, Map<String, Object> data) throws ExecutionException, InterruptedException {
    DocumentReference document = FireStoreDAO.addDocument(collectionName, data);
    data = FireStoreDAO.getDocument(collectionName, document.getId()).get().get().getData();
    data.put("id", document.getId());
    return data;
  }

  public Map<String, Object> updateDocument(String collectionName, String documentID, Map<String, Object> data) throws ExecutionException, InterruptedException {
    DocumentReference document = FireStoreDAO.setDocument(collectionName, documentID ,data);
    data = FireStoreDAO.getDocument(collectionName, documentID).get().get().getData();
    data.put("id", document.getId());
    return data;
  }

  public Map<String, Object> getDocument(String collectionName, String documentID) throws ExecutionException, InterruptedException {
    DocumentReference document = FireStoreDAO.getDocument(collectionName, documentID);
    Map<String, Object> data = document.get().get().getData();
    data.put("id", document.getId());
    return data;
  }

  public boolean deleteDocument(String collectionName, String documentID) {
    DocumentReference document = FireStoreDAO.getDocument(collectionName, documentID);
    try {
      if(document.get().get().exists()){
        ApiFuture<WriteResult> writeResult = document.delete();
        System.out.println(writeResult.get().getUpdateTime());
        return !(FireStoreDAO.getDocument(collectionName, documentID).get().get().exists());
      }
      else {
        return false;
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
      return false;
    } catch (ExecutionException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean deleteCollection(String collectionName){
    return FireStoreDAO.deleteCollection(collectionName);
  }

}
