package my.test.ScriptEngine;

import javax.script.*;

/**
 * <p>Title: ScriptEngineTest</p>
 * <p>Description: </p>
 *
 * @author rbh011
 * @version 1.0
 * @date 2019/8/5 19:25
 */
public class ScriptEngineTest {

	public static void main(String[] args){

		try {
//			groovyTest001();

//			groovyTest002();

			groovyTest003();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void groovyTest001() throws ScriptException, NoSuchMethodException {
		ScriptEngineManager manager = new ScriptEngineManager();
//		SimpleBindings simpleBindings = new SimpleBindings();
//		manager.setBindings(simpleBindings);
//		simpleBindings.put("name","raobinghua");
//		Object name = manager.get("name");
		ScriptEngine engine = manager.getEngineByName("groovy");
		engine.eval("println \"hellow word\"");//Step 3
		((Invocable) engine).invokeFunction("printEnum", new Object());
	}

	private static void groovyTest002() throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
		Bindings binding = engine.createBindings();
		binding.put("capCode", "FOTIC");
		binding.put("stepStruts", "60");
		binding.put("responseCode", "88889");
		binding.put("responseInfo", "无此交易");
		String condition = "capCode==\"FOTIC\" && responseCode==\"8888\"";
		engine.eval("def isMatch(){return " + condition + ";}", binding);
		Boolean isMatch = (Boolean) ((Invocable) engine).invokeFunction("isMatch");
		System.out.println(">>>>>>isMatch=" + isMatch);
	}

	private static void groovyTest003() throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
		String capCode = "FOTIC";
		String stepStruts = "60";
		String responseCode = "88889";
		String responseInfo = "无此交易";
		String condition = "capCode==\"FOTIC\" && responseInfo.contains(\"无\")";

//		engine.eval("def isMatch(String capCode,String stepStatus,String responseCode,String responseInfo,String condition){return "+ condition +"}");
		engine.eval("def isMatch(capCode,stepStatus,responseCode,responseInfo,condition){return "+ condition +"}");
		Object isMatch = ((Invocable) engine).invokeFunction("isMatch", capCode, stepStruts, responseCode, responseInfo, condition);
		System.out.println(isMatch);
	}
}
