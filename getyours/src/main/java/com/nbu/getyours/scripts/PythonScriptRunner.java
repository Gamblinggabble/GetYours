package com.nbu.getyours.scripts;

import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class PythonScriptRunner {

    PythonInterpreter interpreter = new PythonInterpreter();

    public PythonScriptRunner() {
    }

    public String executeScriptGetPrice(String url) {

        interpreter.execfile("./AboutYou-getPrice.py");

        PyObject get_price = interpreter.get("get_price");
        PyObject product_url = interpreter.eval(url);
        PyObject result = get_price.__call__(product_url);

        PyList pyList = (PyList) result;
        return pyList.get(0).toString();
    }

    public String executeScriptGetBrand(String url) {

        interpreter.execfile("./AboutYou-getBrand.py");

        PyObject get_price = interpreter.get("get_price");
        PyObject product_url = interpreter.eval(url);
        PyObject result = get_price.__call__(product_url);

        PyList pyList = (PyList) result;
        return pyList.get(0).toString();
    }

    public String executeScriptGetName(String url) {

        interpreter.execfile("./AboutYou-getName.py");

        PyObject get_price = interpreter.get("get_price");
        PyObject product_url = interpreter.eval(url);
        PyObject result = get_price.__call__(product_url);

        PyList pyList = (PyList) result;
        return pyList.get(0).toString();
    }
}

