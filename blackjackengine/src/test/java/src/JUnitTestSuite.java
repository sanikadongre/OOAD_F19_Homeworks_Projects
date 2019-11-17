package src;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   CardTest.class ,DeckTest.class
})

public class JUnitTestSuite {
}