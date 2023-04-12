package chat.crawling;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class JythonTest {

    private static PythonInterpreter interpreter;

    public static void main(String[] args) {

        interpreter = new PythonInterpreter();
        interpreter.execfile("src/main/java/chat/crawling/bot/pyTest2.py");
        interpreter.exec("result = Sum(5, 10)");

        PyObject result = interpreter.get("result");
        System.out.println("a + b = "+result);
    }
}
