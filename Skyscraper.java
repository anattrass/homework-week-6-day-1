public class Skyscraper{

  private String name;

  private People[] lift;


  public Skyscraper(String name){
    this.name = name;
    this.lift = new People[15];
  }

  public String getName(){
    return this.name;
  }

  public int countLiftPeople(){
    int count = 0;
    for (People people : lift){
      if (people != null){
        count++;
      }
    }
    return count;
  }  

  public boolean liftFull() {
    return countLiftPeople() == lift.length;
  }

  public void enterLift(People people) {
    if (liftFull()) {
      return;
    }
    int countLiftPeople = countLiftPeople();
    lift[countLiftPeople] = people;
  }

  public void closed() {
    for (int i = 0; i < lift.length; i++) {
      lift[i] = null;
    }
  }




}