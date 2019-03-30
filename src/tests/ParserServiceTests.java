import org.junit.Assert;
import org.junit.Test;
import org.wasps.model.fromSourceCode.ParsedClass;
import org.wasps.service.concretes.ParserService;

import java.util.ArrayList;


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
                .get(0).getParsedJavaClass().getName(), "RandomClass");
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
        methodLineLength = tempParserService.getParsedDirectory().getParsedClass("RandomClass").get(0)
                .getParsedMethodList().get(0).getLineLength();
        Assert.assertEquals(methodLineLength, 3);
    }

    @Test
    public void ParsedServiceMethodSubDirLookUp(){
        ParserService tempParserService = new ParserService();
        try{
            tempParserService.loadInDirectory("src/tests/test_data_sub");
        }
        catch (Exception e){
            Assert.fail(e.getMessage());
        }

        ArrayList<ParsedClass> returnList = tempParserService.getParsedDirectory().getParsedClass("hello");
        Assert.assertEquals(returnList.size(), 2);
    }


}
