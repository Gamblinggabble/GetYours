package com.nbu.getyours.scripts;

import org.python.util.PythonInterpreter;
import org.python.core.PyObject;
import org.python.core.PyString;

public class PythonScriptRunner {
    public String executeScript() {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("path/to/your/python/script.py");

        // Call the Python function to fetch and return the desired divs
        PyObject divs = interpreter.get("get_divs");
        PyObject result = divs.__call__();

        return result.toString();
    }
}

