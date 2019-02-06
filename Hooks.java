package io.cucumber.skeleton;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.BeforeStep;
import gherkin.Parser;
import gherkin.AstBuilder;
import gherkin.TokenMatcher;
import gherkin.ast.GherkinDocument;



public class Hooks {
	static int count =1;
	
    @BeforeStep
    public void initiate(Scenario scenario)  {
        System.out.println(count+"..Scenario:\t"+scenario.getUri());
        parseGherkinSource(scenario.getUri());
    count++;
    }
    private void parseGherkinSource(final String path) {
//        if (!pathToReadEventMap.containsKey(path)) {
//            return;
//        }
        final Parser<GherkinDocument> parser = new Parser<>(new AstBuilder());
        final TokenMatcher matcher = new TokenMatcher();
        try {
            final GherkinDocument gherkinDocument = parser.parse(pathToReadEventMap.get(path).source, matcher);
            pathToAstMap.put(path, gherkinDocument);
            final Map<Integer, AstNode> nodeMap = new HashMap<>();
            final AstNode currentParent = new AstNode(gherkinDocument.getFeature(), null);
            for (ScenarioDefinition child : gherkinDocument.getFeature().getChildren()) {
                processScenarioDefinition(nodeMap, child, currentParent);
            }
            pathToNodeMap.put(path, nodeMap);
        } catch (ParserException e) {
            LOGGER.trace(e.getMessage(), e);
        }
    }

    
    @AfterStep
    public void terminate(Scenario scenario) throws Throwable {
//    	System.out.println("After Step"+scenario.getName());
    }

}
