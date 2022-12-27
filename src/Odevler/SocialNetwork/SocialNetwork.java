package Odevler.SocialNetwork;

import java.util.*;
/**
 * Verilen SocialNetwork sınıfı bir sosyal ağı temsil etmektedir. Sınıfın içinde bir kişinin ismini 
 * arkadaş listesine eşleyen bir Map türünde değişken bulunmaktadır.
 * Bu sınıfın sadece friendsOfFriends, mostPopular ve mostCommonFriends metotlarını değiştirin.
 * Diğer metot ve özellikler testlerin çalışması için gereklidir.
 */
public class SocialNetwork {
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************
  // Her bir kişinin ismini arkadaş listesine eşleyen bir harita
  private Map<String, List<String>> adjacencyList;
  // Map nesnesi getter
  public Map<String, List<String>> getAdjacencyList() {
    return adjacencyList;
  }

  // Yapıcı
  public SocialNetwork() {
    adjacencyList = new HashMap<>();
  }

  // Sosyal ağa bir kişi ekler
  public void addPerson(String name) {
    if (!adjacencyList.containsKey(name)) {
      adjacencyList.put(name, new ArrayList<String>());
    }
  }

  // İki kişi arasında bir arkadaşlık ekler
  public void addFriendship(String person1, String person2) {
    addPerson(person1);
    addPerson(person2);
    if (!adjacencyList.get(person1).contains(person2)) {
      adjacencyList.get(person1).add(person2);
      adjacencyList.get(person2).add(person1);        
    }
  }

  // Graftaki köşe(vertex) ve kenarların(edge) string temsilini döndürür
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Vertices:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      builder.append(person + "\n");
    }
    builder.append("\nEdges:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      List<String> friends = entry.getValue();
      builder.append(person + ": [");
      for (int i = 0; i < friends.size(); i++) {
        String friend = friends.get(i);
        if (i == friends.size() - 1) {
          builder.append(friend);
        } else {
          builder.append(friend + ", ");
        }
      }
      builder.append("]\n");
    }
    return builder.toString();
  }
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************

  /**
   * Bir kişinin arkadaşının arkadaşı olan, ancak o kişinin arkadaşı olmayan kişileri döndürür
   * 
   * @param name sorgulanacak kişinin ismi(graftaki bir vertex)
   * @return Arkadaşlarının arkadaşlarının listesi
   */
  public List<String> friendsOfFriends(String name) {
    List<String> result =  new ArrayList<>();
    List<String> arkadaslari = getAdjacencyList().get(name);
    arkadaslari.forEach(s -> {
      List<String> arkadasninArkadaslari = getAdjacencyList().get(s);
      arkadasninArkadaslari.forEach(g -> {
        if(!arkadaslari.contains(g) && !result.contains(g) && !g.equals(name) ){
          result.add(g);
        }
      });
    });
    
    return result;
  }

  /**
   * Graftaki kişileri arkadaş sayısına göre çoktan aza doğru sıralı olarak döndürür
   * 
   * @return Arkadaş sayısına göre azalan sırada kişilerin adlarının listesi
   */
  public List<String> mostPopular() {
    List<String> result = new ArrayList<>();
    Map<String,Integer> resultMap = new HashMap<>();

    getAdjacencyList().forEach((person, friends) ->
            resultMap.put(person,getAdjacencyList().get(person).size())
            );
    List<Map.Entry<String,Integer>> resultList = new ArrayList<>(resultMap.entrySet());
    resultList.sort(Map.Entry.comparingByValue());
    resultList.forEach(entry -> {
      result.add(entry.getKey());
    });
    Collections.reverse(result);
    return result;
  }

  /**
   * En çok ortak arkadaşı olan iki kişiyi liste içinde döndürür. Ortak arkadaş sayısı en çok olan 
   * ikiden fazla kişi olması durumunda herhangi ikisini döndürmek yeterlidir.
   * 
   * @return En çok ortak arkadaşı olan kişilerin isimlerinin bulunduğu liste. Listede 2 vertex bulunmalıdır.
   */
  public List<String> mostCommonFriends() {

    List<String> maxCount =new ArrayList<>();
    List<String> persons = new ArrayList<>(adjacencyList.keySet());
    HashMap<Integer , HashMap<String , String>> mostCommonCount = new HashMap<>();

    try{
      for(int i = 0 ; i<adjacencyList.size()-1 ; i++){
        for(int j =i+1;i<adjacencyList.size();j++){
          int b = findCommonCount(adjacencyList.get(persons.get(i)) , adjacencyList.get(persons.get(j)));
          HashMap<String , String> inner = new HashMap<>();
          inner.put(persons.get(i) , persons.get(j) );
          mostCommonCount.put(b,inner);
        }
      }
    }
    catch (IndexOutOfBoundsException exception){
      System.out.println("a");
    }
    List<Integer> counts = new ArrayList<>(mostCommonCount.keySet());
    int max =findMax(mostCommonCount,counts);

    List<String> c = new ArrayList<>(mostCommonCount.get(max).keySet());
    maxCount.add(c.get(0));
    maxCount.add(mostCommonCount.get(max).get(c.get(0)));
    return maxCount;
  }

  public int findMax(HashMap<Integer , HashMap<String , String>> mostCommonCount,List<Integer> counts){
    int max = 0;
    for (int i = 0 ;i< mostCommonCount.size();i++){
      if(max <= counts.get(i)){
        max = counts.get(i);
      }
    }
    return max;
  }

  public int findCommonCount(List<String> x , List<String> y){

    int result =0;

    for (String s : x) {
      for (String value : y) {
        if (s.equals(value)) {
          result++;
        }
      }
    }

    return result;
  }


}
