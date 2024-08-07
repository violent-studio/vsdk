EzXML is a high-level layer between JavaX.XML and W3C.DOM + (Java IO) with utilities to simplify some things.
It allows you to read or write XML easier and faster.

### Reading XML.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<anim>
    <x>10</x>
    <y>20</y>
    <z>30</z>
</anim>
```

```java
import gsdk.glib.ezxml.EzXML;

import static gsdk.source.generic.Assert.assert_t;

public class Main {
    public static void main(String[] args) {
        EzXML xmlf = new EzXML();

        assert_t(xmlf.new_() != EzXML.OK, "xmlf.new_() != EzXML.OK");
        assert_t(xmlf.parseDoc("new.xml") != EzXML.OK, "xmlf.parseDoc(new.xml) != EzXML.OK");

        // root(anim)->x/y/z
        System.out.println(xmlf.rootGetElemsByTag("x").item(0).getTextContent());
        System.out.println(xmlf.rootGetElemsByTag("y").item(0).getTextContent());
        System.out.println(xmlf.rootGetElemsByTag("z").item(0).getTextContent());
    }
}
```

Output:
```
10
20
30
```

### Writing XML.

```java
import org.w3c.dom.Element;

import gsdk.glib.ezxml.EzXML;

import static gsdk.source.generic.Assert.assert_t;

public class Main {
    public static void main(String[] args) {
        EzXML xmlf = new EzXML();

        assert_t(xmlf.new_() != EzXML.OK, "xmlf.new_() != EzXML.OK");
        assert_t(xmlf.parseDoc(EzXML.NEW_DOCUMENT) != EzXML.OK, "xmlf.parseDoc(NEW_DOCUMENT) != EzXML.OK");

        xmlf.getWriter().addDocComment("Generated by EzXML.");

        Element animRoot = xmlf.getWriter().append("anim", xmlf.getDocument());

        Element xEl = xmlf.getWriter().create("x");
        xEl.setTextContent("10");
        xmlf.getWriter().appendElement(xEl, animRoot);

        Element yEl = xmlf.getWriter().create("y");
        yEl.setTextContent("20");
        xmlf.getWriter().appendElement(yEl, animRoot);

        Element zEl = xmlf.getWriter().create("z");
        zEl.setTextContent("30");
        xmlf.getWriter().appendElement(zEl, animRoot);

        assert_t(xmlf.getWriter().write("new.xml") != EzXML.OK, "xmlf.getWriter().write(new.xml) != EzXML.OK");
    }
}
```

`new.xml`:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!--
Generated by EzXML.
--><anim>
    <x>10</x>
    <y>20</y>
    <z>30</z>
</anim>
```

(You can read/write XML file at same time.)
