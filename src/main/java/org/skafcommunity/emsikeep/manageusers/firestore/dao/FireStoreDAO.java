package org.skafcommunity.emsikeep.manageusers.firestore.dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.List;
import java.util.Map;

public class FireStoreDAO {

  public static CollectionReference getCollection(String collectionName){
    return FirebaseAdminSDK.getFirestore().collection(collectionName);
  }

  public static DocumentReference getDocument(String collectionName, String documentID){
    return FirebaseAdminSDK.getFirestore().collection(collectionName).document(documentID);
  }

  public static DocumentReference setDocument(String collectionName, String documentID, Map<String, Object> data){
    DocumentReference document = FirebaseAdminSDK.getFirestore().collection(collectionName).document(documentID);
    document.set(data);
    return document;
  }

  public static DocumentReference addDocument(String collectionName,Map<String, Object> data){
    DocumentReference document = FirebaseAdminSDK.getFirestore().collection(collectionName).document();
    document.set(data);
    return document;
  }

  public static boolean deleteCollection(String collectionName){
    try {
      int batchSize = FireStoreDAO.getCollection(collectionName).get().get().size();
      ApiFuture<QuerySnapshot> future = FireStoreDAO.getCollection(collectionName).limit(batchSize).get();
      int deleted = 0;
      List<QueryDocumentSnapshot> documents = future.get().getDocuments();
      for (QueryDocumentSnapshot document : documents) {
        document.getReference().delete();
        ++deleted;
      }
      return true;
    } catch (Exception e) {
      System.err.println("Error deleting collection : " + e.getMessage());
      return false;
    }
  }

  public static CollectionReference addCollection(String collectionName){
    return FirebaseAdminSDK.getFirestore().collection(collectionName);
  }

}
