import org.junit.Assert;
import org.junit.Test;
import org.wasps.service.concretes.ParserService;


public class ParserServiceTests {

    @Test
    public void ParsedServiceClassGetTest(){
        ParserService tempService = new ParserService();

        try {
            tempService.loadInDirectory("src/tests/test_data");
        } catch (Exception e) {
            Assert.fail(e.toString());
        }

        Assert.assertEquals(tempService.getParsedDirectory().getParsedClass("RandomClass")
                .getParsedJavaClass().getName(), "RandomClass");
    }

    @Test
    public void ParsedServiceSingleUseCheck(){
        ParserService tempService = new ParserService();
        Boolean singleUseCheckTriggered = false;

        try{
            tempService.loadInDirectory("src/tests/test_data");
            tempService.loadInDirectory("src/tests/test_data");
        }
        catch (Exception e){
            singleUseCheckTriggered = true;
        }
        Assert.assertEquals(singleUseCheckTriggered, true);
    }

    @Test
    public void ParsedServiceMethodLineCheck(){
        ParserService tempParserService = new ParserService();
        int methodLineLength = 0;

        try{
            tempParserService.loadInDirectory("src/tests/test_data");
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }
        methodLineLength = tempParserService.getParsedDirectory().getParsedClass("RandomClass")
                .getParsedMethodList().get(0).getLineLength();
        Assert.assertEquals(methodLineLength, 3);
    }
}
