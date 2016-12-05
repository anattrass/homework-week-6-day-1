import static org.junit.Assert.assertEquals;
import org.junit.*;

public class SkyscraperTest{
  Skyscraper skyscraper;
  People people;

  @Before 
  public void before() {
    skyscraper = new Skyscraper("The Shard");
    people = new People();
  }

  @Test
  public void hasName(){
    assertEquals("The Shard", skyscraper.getName()); 
  }

  @Test
  public void liftStartsEmpty(){
    assertEquals(0, skyscraper.countLiftPeople());
  }

  @Test
  public void peopleCanGetInLift(){
    skyscraper.enterLift(people);
    assertEquals(1, skyscraper.countLiftPeople());
  }

  @Test
  public void cannotEnterLiftWhenAtCapacity() {
    for (int i = 0; i < 30; i++) {
      skyscraper.enterLift(people);
    }
    assertEquals(15, skyscraper.countLiftPeople());
  }

  @Test
  public void liftIsFull() {
    for (int i = 0; i < 15; i++){
      skyscraper.enterLift(people);
    }
    assertEquals(true, skyscraper.liftFull());
  }

  @Test
  public void liftBreakdown() {
    skyscraper.enterLift(people);
    assertEquals(1, skyscraper.countLiftPeople());
    skyscraper.closed();
    assertEquals(0, skyscraper.countLiftPeople());
  }

}
