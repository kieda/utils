package com.zkieda.string.escape;

import java.util.List;


public interface StringListSerializer{
    public List<String> get(String stringToSplit);
    public String put(List<String> stringToSplit);
}